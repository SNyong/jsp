package svc.Order;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.OrderDAO;
import vo.Order;

public class OrderOkListSvc {

	public ArrayList<Order> getOrderList(String id) {
		ArrayList<Order> order = null;
		Connection con = null;

		try {
			con = getConnection();
			OrderDAO orderDAO = OrderDAO.getInstance();
			orderDAO.setConnection(con);
			order = orderDAO.selectOrderList(id);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}

		return order;
	}
}