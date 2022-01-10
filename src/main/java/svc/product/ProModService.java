package svc.product;

import static db.JdbcUtil.*;

import java.sql.Connection;


import dao.ProductDAO;

import vo.Product;

public class ProModService {

	public boolean ModProduct(Product proAdd) {
//		public boolean ModMember(MemberBean member) {
	
		boolean ModSuccess = false;
		Connection con = null;
		try {

			ProductDAO productDAO = ProductDAO.getInstance();
			con = getConnection();
			productDAO.setConnection(con);
			int modCount = productDAO.modProduct(proAdd);
			if (modCount > 0) {
				ModSuccess = true;
				commit(con);
			} else {
				rollback(con);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}

		return ModSuccess;
	}

}
