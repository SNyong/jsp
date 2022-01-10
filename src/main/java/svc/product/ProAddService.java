package svc.product;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.ProductDAO;
import vo.Product;

public class ProAddService {

	public boolean addProduct(Product proAdd) {
		boolean addResult = false;
		Connection con = null;

		try {
			ProductDAO productDAO = ProductDAO.getInstance();
			con = getConnection();
			productDAO.setConnection(con);
			int addCount = productDAO.addProduct(proAdd);

			if (addCount > 0) {
				addResult = true;
				commit(con);
			} else {
				rollback(con);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}

		return addResult;
	}

}
