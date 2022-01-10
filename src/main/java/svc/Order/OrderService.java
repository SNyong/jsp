package svc.Order;

import static db.JdbcUtil.*;
import java.sql.*;

import dao.BucketDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import vo.Order;

public class OrderService {
	public boolean addOrder(Order order, String id) {
		boolean orderResult = false;
		Connection con = null;
		try {
			con = getConnection();
			BucketDAO bucketDAO = BucketDAO.getInstance();
			bucketDAO.setConnection(con);

			OrderDAO orderDAO = OrderDAO.getInstance();
			orderDAO.setConnection(con);
			
			ProductDAO productDAO = ProductDAO.getInstance();
			productDAO.setConnection(con);
			
			int addCount = orderDAO.addOrder(order);  //주문
			int addCount2 = 0;  //상세주문
			int delCount = 0;  //주문완료시 장바구니 삭제
			int delCount2 = 0;  //주문완료시 재고 수량차감

			// 상세주문이 생성되지않으면 롤백
			for (int i = 0; i < order.getOrderList().size(); i++) {
				addCount2 = orderDAO.addDetail(order.getOrderList().get(i));
			}
				
			// 결제시 장바구니에서 삭제되지 않으면 롤백
			delCount = bucketDAO.bucketDel2(order);			
			
			
			// 결제시 주문된 상품의 수량만큼 재고에서 차감
			delCount2 = productDAO.productDel(order);
			
						
			// Order가 생성되어야 Detail이 같이 생성
			if (addCount > 0 && addCount2 > 0 && delCount > 0 && delCount2 > 0) {
				orderResult = true;
				commit(con);
			} else {
				rollback(con);
			}

		} catch (Exception e) {
			e.printStackTrace();
			rollback(con);
		} finally {
			close(con);
		}
		return orderResult;
	}
}