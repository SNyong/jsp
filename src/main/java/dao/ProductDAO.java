package dao;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import vo.Inventory;
import vo.Order;
import vo.Product;

public class ProductDAO {
	private static ProductDAO instance;
	Connection con = null;

	Product pro = null;
	Inventory inven = null;

	private ProductDAO() {
	}

	public static ProductDAO getInstance() {
		if (instance == null) {
			instance = new ProductDAO();
		}
		return instance;
	}

	public void setConnection(Connection con) {
		this.con = con;

	}
	//////////// 추가 시작

	public int addProduct(Product proAdd) { /* 물품 추가 */
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int addCount = 0;
		String sql = "insert into Product values (?,?,?,?,?,?,?,?)";
		int num = 0;
		try {
			pstmt = con.prepareStatement("select max(ProductCode) from Product");
			rs = pstmt.executeQuery();

			if (rs.next())
				num = rs.getInt(1) + 1;
			else
				num = 1;

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, proAdd.getProductName());
			pstmt.setInt(3, proAdd.getCategory());
			pstmt.setInt(4, proAdd.getProductBuyPrice());
			pstmt.setInt(5, proAdd.getProductSellPrice());
			pstmt.setString(6, proAdd.getNote());
			pstmt.setString(7, proAdd.getImage());
			pstmt.setInt(8, proAdd.getHidden());
			addCount = pstmt.executeUpdate();
			System.out.println(pstmt);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return addCount;
	}

	public ArrayList<Product> selectProductList(int page, int limit, String category) { /* 물품 리스트보기 */

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Product pro = null;

		String sql = "SELECT *,"
				+ "(SELECT TotalCount FROM Inventory WHERE Inventory.ProductCode = Product.ProductCode order by InventoryNum desc limit 1) "
				+ "AS TotalCount FROM Product";
		if (category != null) {
			sql += " where category = ? ";
		}
		sql += " order by ProductCode asc limit ?,?";

		ArrayList<Product> proList = null;
		int startrow = (page - 1) * limit;

		try {

			pstmt = con.prepareStatement(sql);
			if (category != null) {
				pstmt.setString(1, category);
				pstmt.setInt(2, startrow);
				pstmt.setInt(3, limit);
			} else {
				pstmt.setInt(1, startrow);
				pstmt.setInt(2, limit);
			}
			System.out.println(pstmt);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				proList = new ArrayList<Product>();
				do {
					pro = new Product();

					pro.setProductCode(rs.getInt("ProductCode"));
					pro.setProductName(rs.getString("ProductName"));
					pro.setCategory(rs.getInt("Category"));
					pro.setProductBuyPrice(rs.getInt("ProductBuyPrice"));
					pro.setProductSellPrice(rs.getInt("ProductSellPrice"));
					pro.setNote(rs.getString("Note"));
					pro.setTotalCount(rs.getInt("TotalCount"));
					pro.setImage(rs.getString("image"));
					pro.setHidden(rs.getInt("Hidden"));
					proList.add(pro);

				} while (rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return proList;
	}

	public int delProduct(int ProductCode) {
		PreparedStatement pstmt = null;

		int deleteCount = 0;
		String sql = "delete from Product where ProductCode=?";
		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ProductCode);
			deleteCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return deleteCount;
	}

	public Product selectProduct(int productCode) { // 물품 정보
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT *,"
				+ "(SELECT TotalCount FROM Inventory WHERE Inventory.ProductCode = Product.ProductCode order by InventoryNum desc limit 1) "
				+ "AS TotalCount FROM Product where ProductCode = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, productCode);
			System.out.println(pstmt);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				pro = new Product();
				pro.setProductCode(rs.getInt("ProductCode"));
				pro.setProductName(rs.getString("Productname"));
				pro.setCategory(rs.getInt("Category"));
				pro.setProductBuyPrice(rs.getInt("ProductBuyPrice"));
				pro.setProductSellPrice(rs.getInt("ProductSellPrice"));
				pro.setNote(rs.getString("Note"));
				pro.setTotalCount(rs.getInt("TotalCount"));
				pro.setImage(rs.getString("Image"));
				pro.setHidden(rs.getInt("Hidden"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return pro;

	}

	public int modProduct(Product proAdd) { // 물품 수정
		int modCount = 0;
		PreparedStatement pstmt = null;
		String sql = "update Product set ProductName = ?, ProductBuyPrice = ?, ProductSellPrice = ?, Note = ?, Hidden = ?";

		if (proAdd.getImage() != null) {
			sql += ", image ='" + proAdd.getImage() + "'";
		}
		sql += " where ProductCode = ? ";

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, proAdd.getProductName());
			pstmt.setInt(2, proAdd.getProductBuyPrice());
			pstmt.setInt(3, proAdd.getProductSellPrice());
			pstmt.setString(4, proAdd.getNote());
			pstmt.setInt(5, proAdd.getHidden());
			pstmt.setInt(6, proAdd.getProductCode());
			System.out.println(pstmt);
			modCount = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return modCount;
	}

	public int modInventory(Inventory inven) { // 재고 추가
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int modCount = 0;
		String sql = "insert into Inventory values (?,?,?,?,?,?)";

		int num = 0;
		int totalCount = inven.getTotalCount();
		if (inven.getInOutcomming() == 1) {
			totalCount += inven.getProductCount();
		} else {
			totalCount -= inven.getProductCount();
		}
		try {

			pstmt = con.prepareStatement("select max(InventoryNum) from Inventory");
			rs = pstmt.executeQuery();

			if (rs.next())
				num = rs.getInt(1) + 1;
			else
				num = 1;

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setInt(2, inven.getInOutcomming());
			pstmt.setString(3, inven.getI_Date());
			pstmt.setInt(4, inven.getProductCount());
			pstmt.setInt(5, inven.getProductCode());
			pstmt.setInt(6, totalCount);
			modCount = pstmt.executeUpdate();

			System.out.println(pstmt);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return modCount;
	}

	public Inventory selectInventory(String productCode) { // 인벤토리 정보 불러오기
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from Inventory where ProductCode = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, productCode);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				inven = new Inventory();
				inven.setInventoryNum(rs.getInt("InventoryNum"));
				inven.setInOutcomming(rs.getInt("InOutcomming"));
				inven.setI_Date(rs.getString("I_Date"));
				inven.setProductCount(rs.getInt("ProductCount"));
				inven.setProductCode(rs.getInt("ProductCode"));
				inven.setTotalCount(rs.getInt("TotalCount"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return inven;
	}

	public Inventory selectCount(int productCode) { // 가장 최근 재고 ( 사용 안함)
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from Inventory where ProductCode = ? and InventoryNum = (select max(InventoryNum) from Inventory)";
		// select
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, productCode);
			rs = pstmt.executeQuery();
			System.out.println(pstmt);
			if (rs.next()) {
				inven = new Inventory();
				inven.setInventoryNum(rs.getInt("InventoryNum"));
				inven.setInOutcomming(rs.getInt("InOutcomming"));
				inven.setI_Date(rs.getString("I_Date"));
				inven.setProductCount(rs.getInt("ProductCount"));
				inven.setProductCode(rs.getInt("ProductCode"));
				inven.setTotalCount(rs.getInt("TotalCount"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return inven;
	}

	public ArrayList<Inventory> selectInventoryList(int page, int limit) { // 재고 입출고현황

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Inventory inven = null;

		String sql = "select * from Inventory a, Product b where a.ProductCode = b.ProductCode order by InventoryNum asc limit ?,?";
		ArrayList<Inventory> invneList = null;
		int startrow = (page - 1) * limit;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, limit);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				invneList = new ArrayList<Inventory>();
				do {
					inven = new Inventory();
					inven.setInventoryNum(rs.getInt("InventoryNum"));
					inven.setInOutcomming(rs.getInt("InOutcomming"));
					inven.setI_Date(rs.getString("I_Date"));
					inven.setProductCount(rs.getInt("ProductCount"));
					inven.setProductCode(rs.getInt("ProductCode"));
					inven.setTotalCount(rs.getInt("TotalCount"));
					inven.setProductName(rs.getString("ProductName"));
					invneList.add(inven);

				} while (rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return invneList;
	}

	public ArrayList<Inventory> selectInventoryListFilter(int code, int page, int limit) { // 재고 입출고현황 필터
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Inventory inven = null;
		String sql = "select * from Inventory a, Product b where a.ProductCode = b.ProductCode and a.ProductCode = ? limit ?,? ";

		ArrayList<Inventory> invneList = null;
		int startrow = (page - 1) * limit;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, code);
			pstmt.setInt(2, startrow);
			pstmt.setInt(3, limit);
			rs = pstmt.executeQuery();
			System.out.println(pstmt);
			if (rs.next()) {
				invneList = new ArrayList<Inventory>();
				do {
					inven = new Inventory();
					inven.setInventoryNum(rs.getInt("InventoryNum"));
					inven.setInOutcomming(rs.getInt("InOutcomming"));
					inven.setI_Date(rs.getString("I_Date"));
					inven.setProductCount(rs.getInt("ProductCount"));
					inven.setProductCode(rs.getInt("ProductCode"));
					inven.setTotalCount(rs.getInt("TotalCount"));
					inven.setProductName(rs.getString("ProductName"));
					invneList.add(inven);

				} while (rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return invneList;
	}

	public ArrayList<Product> selectItemList(int category) { // 아이템 리스트 보기 ( 히든 1(보임) 만 출력)

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Product pro = null;

		String sql = "SELECT *,"
				+ "(SELECT max(TotalCount) FROM Inventory WHERE Inventory.ProductCode = Product.ProductCode) "
				+ "AS TotalCount FROM Product where Category = ? and Hidden = 1";
		ArrayList<Product> proList = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, category);
			System.out.println(pstmt);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				proList = new ArrayList<Product>();
				do {
					pro = new Product();

					pro.setProductCode(rs.getInt("ProductCode"));
					pro.setProductName(rs.getString("ProductName"));
					pro.setCategory(rs.getInt("Category"));
					pro.setProductBuyPrice(rs.getInt("ProductBuyPrice"));
					pro.setProductSellPrice(rs.getInt("ProductSellPrice"));
					pro.setNote(rs.getString("Note"));
					pro.setTotalCount(rs.getInt("TotalCount"));
					pro.setImage(rs.getString("image"));
					proList.add(pro);

				} while (rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return proList;
	}

	public int selectListCount() { // 페이지 설정시 출력할것들 갯수 카운트 (물품목록)
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement("select count(*) from Product");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}

	public int selectListCountI() { // 페이지 설정시 출력할것들 갯수 카운트 (재고 수정 이력)
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement("select count(*) from Inventory");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}

	public int selectListCountIF(int code) { // 페이지 설정시 출력할것들 갯수 카운트(재고 수정 이력 필터사용)
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement("select count(*) from Inventory where ProductCode = ?");
			pstmt.setInt(1, code);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}

	public int productDel(Order order) { // 주문완료시 재고 수량차감

		int delCount2 = 0;
		PreparedStatement pstmt = null;

		String sql = "insert into Inventory (InOutcomming, I_Date, ProductCount, ProductCode, TotalCount)"
				+ " values (2, ?, ?, ?, " + "(select totalCount-? from Inventory a where ProductCode = ? "
				+ "order by InventoryNum desc limit 1))";

//		(입출고, 입출고날짜, 입출고갯수, 상품코드, 총수량) 

		try {
			pstmt = con.prepareStatement(sql);

			for (int i = 0; i < order.getOrderList().size(); i++) {
				pstmt.setString(1, LocalDate.now().toString());
				pstmt.setInt(2, order.getOrderList().get(i).getDetailQ());
				pstmt.setInt(3, order.getOrderList().get(i).getProductCode());
				pstmt.setInt(4, order.getOrderList().get(i).getDetailQ());
				pstmt.setInt(5, order.getOrderList().get(i).getProductCode());
				System.out.println(pstmt);
				delCount2 = pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return delCount2;
	}
}