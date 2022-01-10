package svc.product;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.ProductDAO;

public class ProDelService {

	public boolean delProduct(int ProductCode) {
		boolean deleteResult = false;

		Connection con = null;

		try {
			con = getConnection();
			ProductDAO productDAO = ProductDAO.getInstance();
			productDAO.setConnection(con);
			int deleteCount = productDAO.delProduct(ProductCode);
			if (deleteCount > 0) {
				deleteResult = true;
				commit(con);
			} else {
				rollback(con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return deleteResult;
	}
}
