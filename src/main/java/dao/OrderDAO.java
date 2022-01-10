package dao;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import vo.Order;
import vo.OrderDetail;

public class OrderDAO {
	private static OrderDAO instance;
	Connection con = null;

	private OrderDAO() {
	} // 생성자

	public static OrderDAO getInstance() { // 싱글톤 패턴
		if (instance == null) {
			instance = new OrderDAO();
		}
		return instance;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public int addOrder(Order order) { /* 주문서 */
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int addCount = 0;
		int num = 0;

		try {
			String sql = "insert into OrderSheet (OrderCode, OrderDate, Position, TotalPrice, MemberId, Address) values (?,?,?,?,?,?)";
			pstmt = con.prepareStatement("select max(OrderCode) from OrderSheet");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				num = rs.getInt(1) + 1;
			} else {
				num = 1;
			}

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, order.getOrderDate());
			pstmt.setInt(3, 1);
			pstmt.setInt(4, order.getTotalPrice());
			pstmt.setString(5, order.getMemberId());
			pstmt.setString(6, order.getAddress());
			System.out.println(pstmt);
			addCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return addCount;
	}

	public int addDetail(OrderDetail orderDetail) { /* 상세주문 */
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int addCount2 = 0;
		int num = 0;

		String sql = "insert into OrderDetail (DetailCode, ProductCode, DetailQ, OrderCode) values (?,?,?,(select max(OrderCode) from OrderSheet))";
		// OrderCode 가장 높은(최근)값 작성

		try {
			pstmt = con.prepareStatement("select max(DetailCode) from OrderDetail");
			// DetailCode 가장 높은(최근)값 작성
			rs = pstmt.executeQuery();

			if (rs.next())
				num = rs.getInt(1) + 1;
			else
				num = 1;
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setInt(2, orderDetail.getProductCode());
			pstmt.setInt(3, orderDetail.getDetailQ());
			System.out.println(pstmt);
			addCount2 = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return addCount2;
	}

	public ArrayList<Order> orderList(String id) { /* 주문서 출력 */
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Order order = null;

		String sql = "select * from OrderSheet a, OrderDetail b, Product c" 
				+ " where a.OrderCode = b.OrderCode"
				+ " and a.OrderCode = (select max(OrderCode) from OrderDetail)" 
				+ " and a.MemberId = ?";

		ArrayList<Order> orderList = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			System.out.println(pstmt);

			if (rs.next()) {
				orderList = new ArrayList<Order>();
				do {
					order = new Order();
					order.setOrderCode(rs.getInt("OrderCode"));
					order.setOrderDate(rs.getString("OrderDate"));
					order.setPosition(rs.getInt("Position"));
					order.setTotalPrice(rs.getInt("TotalPrice"));
					order.setMemberId(rs.getString("MemberId"));
//					order.setAddress(rs.getString("DeliveryCode"));
					order.setDetailCode(rs.getInt("DetailCode"));
					order.setDetailQ(rs.getInt("DetailQ"));
					order.setProductCode(rs.getInt("ProductCode"));
					order.setProductSellPrice(rs.getInt("ProductSellPrice"));
					order.setProductName(rs.getString("productName"));
					order.setProductBuyPrice(rs.getInt("productBuyPrice"));

					orderList.add(order);
				} while (rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return orderList;
	}

	public ArrayList<Order> selectOrderList(String id) {/* 내 주문 목록 */
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Order> orderList = null;
		Order order = null;
		
		String sql = "select OrderCode, OrderDate, TotalPrice from OrderSheet"
				+ " where memberId = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			System.out.println(pstmt);

			if (rs.next()) {
				orderList = new ArrayList<Order>();
				
				do {
				order = new Order();
				
				order.setOrderCode(rs.getInt("OrderCode"));
				order.setOrderDate(rs.getString("OrderDate"));
				order.setTotalPrice(rs.getInt("TotalPrice"));
				orderList.add(order);
				} while(rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return orderList;
	}

	public ArrayList<Order> orderView(int orderCode) {  //주문 상세정보 보기
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Order order = null;
		ArrayList<Order> orderList = null;
		String sql = "select * from Product a, OrderDetail b where a.ProductCode = b.ProductCode  and b.OrderCode = ?;";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, orderCode);
			System.out.println(pstmt);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				orderList = new ArrayList<Order>();
				do {
					order = new Order();
				order.setProductName(rs.getString("ProductName"));
				order.setProductSellPrice(rs.getInt("ProductSellPrice"));
				order.setDetailCode(rs.getInt("DetailCode"));
				order.setDetailQ(rs.getInt("DetailQ"));
				order.setProductCode(rs.getInt("ProductCode"));
				orderList.add(order);
			}while(rs.next());
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return orderList;
	}
}