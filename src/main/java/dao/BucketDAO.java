package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import vo.Bucket;
import vo.Inventory;
import vo.Order;
import vo.Product;

public class BucketDAO {
	
	private static BucketDAO instance;
	Connection con = null;

	Product pro = null;
	Inventory inven = null;

	private BucketDAO() {
	}

	public static BucketDAO getInstance() {
		if (instance == null) {
			instance = new BucketDAO();
		}
		return instance;
	}

	public void setConnection(Connection con) {
		this.con = con;

	}
	/// 추가 시작

	public int addBucket(Bucket bucket) { // 장바구니 추가
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int addCount = 0;
		int num = 0;
		String sql = "insert into Bucket values (?,?,?,?)";

		try {

			pstmt = con.prepareStatement("select max(BucketCode) from Bucket");
			rs = pstmt.executeQuery();

			if (rs.next())
				num = rs.getInt(1) + 1;
			else
				num = 1;

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);

			if (bucket.getBucketQ() == 0) {
				pstmt.setInt(2, 1);
			} else {
				pstmt.setInt(2, bucket.getBucketQ());
			}
			pstmt.setString(3, bucket.getMemberId());
			pstmt.setInt(4, bucket.getProductCode());
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

	public ArrayList<Bucket> selects(String id, String codes[]) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM Bucket B LEFT JOIN Product P on B.ProductCode = P.ProductCode "
				+ "WHERE B.MemberId='" + id + "' and B.ProductCode IN (";

		for (int i = 0; i < codes.length; i++) {
			sql += "'" + codes[i] + "'";
			if (i != codes.length - 1)
				sql += ", ";
		}
		sql += ")";

		Bucket bucket = null;
		ArrayList<Bucket> bucketList = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				bucketList = new ArrayList<Bucket>();
				do {
					bucket = new Bucket();
					bucket.setBucketCode(rs.getInt("BucketCode"));
					bucket.setBucketQ(rs.getInt("BucketQ"));
					bucket.setProductCode(rs.getInt("ProductCode"));
					bucket.setMemberId(id);
					bucket.setProductName(rs.getString("ProductName"));
					bucket.setProductSellPrice(rs.getInt("ProductSellPrice"));
					bucket.setImage(rs.getString("Image"));
					bucketList.add(bucket);

				} while (rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return bucketList;
	}

	public ArrayList<Bucket> bucketList(String id) { // id별 장바구니 보기

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Bucket bucket = null;
		String sql = "select BucketCode, BuCketQ, ProductCode,MemberId,"
				+ "(select ProductName from Product where ProductCode = Bucket.ProductCode) as ProductName,"
				+ "(select ProductSellPrice from Product where ProductCode = Bucket.ProductCode) as ProductSellPrice,"
				+ "(select image from Product where ProductCode = Bucket.ProductCode) as Image"
				+ " from Bucket where MemberId = ?";

		ArrayList<Bucket> bucketList = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			System.out.println(pstmt);
			if (rs.next()) {
				bucketList = new ArrayList<Bucket>();
				do {
					bucket = new Bucket();
					bucket.setBucketCode(rs.getInt("BucketCode"));
					bucket.setBucketQ(rs.getInt("BucketQ"));
					bucket.setProductCode(rs.getInt("ProductCode"));
					bucket.setMemberId(id);
					bucket.setProductName(rs.getString("ProductName"));
					bucket.setProductSellPrice(rs.getInt("ProductSellPrice"));
					bucket.setImage(rs.getString("Image"));
					bucketList.add(bucket);

				} while (rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return bucketList;
	}

	public int bucketDel(String id, int productCode) { // 장바구니 항목 삭제
		PreparedStatement pstmt = null;
		int deleteCount = 0;
		String sql = "delete from Bucket where MemberId=? and ProductCode=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, productCode);
			System.out.println(pstmt);
			deleteCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return deleteCount;
	}

	public int bucketMod(String id, String productCode, String bucketQ) { // 장바구니 갯수 추가
		PreparedStatement pstmt = null;
		int modCount = 0;
		String sql = "update Bucket set BucketQ = ? where MemberId =? and ProductCode =? ";

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, bucketQ);
			pstmt.setString(2, id);
			pstmt.setString(3, productCode);
			System.out.println(pstmt);
			modCount = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return modCount;
	}

	public int checkBucket(Bucket bucket) { // 장바구니 중복으로 들어왔을때 갯수증가
		int check = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from Bucket where MemberId = ? and ProductCode = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bucket.getMemberId());
			pstmt.setInt(2, bucket.getProductCode());
			System.out.println(pstmt);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				check = 1;
				sql = "update Bucket set BucketQ=BucketQ+1 where MemberId = ? and ProductCode = ? ";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, bucket.getMemberId());
				pstmt.setInt(2, bucket.getProductCode());
				System.out.println(pstmt);
				pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return check;
	}

	public int bucketDel2(Order order) { // 장바구니 항목이 결제가되면 삭제
		int delCount = 0;
		PreparedStatement pstmt = null;

		String sql = "delete from Bucket where BucketCode=?";

		try {
			pstmt = con.prepareStatement(sql);

			for (int j = 0; j < order.getOrderList().size(); j++) {
				pstmt.setInt(1, order.getOrderList().get(j).getBucketCode());
				delCount = pstmt.executeUpdate();
			}

			System.out.println(pstmt);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return delCount;
	}

//      String sql = "delete from Bucket where MemberId=? and ProductCode=?";
//      try {
//    	  System.out.println(sql);
//         pstmt = con.prepareStatement(sql);
//         pstmt.setString(1, id);
//         pstmt.setInt(2, orderDetail.getProductCode());
//         System.out.println(pstmt);
//         delCount = pstmt.executeUpdate();
//      } catch (Exception e) {
//         e.printStackTrace();
//      } finally {
//         close(pstmt);
//      }
//      return delCount;
//   }
}