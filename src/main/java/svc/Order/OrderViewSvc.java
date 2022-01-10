package svc.Order;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BucketDAO;
import dao.MemberDAO;
import dao.OrderDAO;
import vo.Bucket;
import vo.MemberBean;
import vo.Order;

public class OrderViewSvc {

	public ArrayList<Order> getOrderView(int orderCode) {
		ArrayList<Order> orderList = null;
		Connection con = null;
		
		try {
			con = getConnection();
			OrderDAO orderDAO = OrderDAO.getInstance();
			orderDAO.setConnection(con);
			orderList = orderDAO.orderView(orderCode);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		
		return orderList;
	}

	public ArrayList<Order> orderList(String id) {
		 ArrayList<Order> result = null;
		Connection con = null;
		try {
			con = getConnection();
			OrderDAO orderDAO = OrderDAO.getInstance();
			orderDAO.setConnection(con);
			result = orderDAO.orderList(id);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return result;
	}

	public MemberBean loginMember(String id) {
		MemberBean member = new MemberBean();
		Connection con = null;
		try {
			con = getConnection();
			MemberDAO memberDAO = MemberDAO.getInstance();
			memberDAO.setConnection(con);
			member = memberDAO.selectMember(id);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return member;
	}
}