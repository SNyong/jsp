package svc.product;

import java.sql.Connection;

import dao.ProductDAO;

import static db.JdbcUtil.*;

import vo.Product;

public class ProInfoService {

	public Product getproInfo(int productCode) {
		Product product = null;

		Connection con = null;

		try {
			con = getConnection();
			ProductDAO productDAO = ProductDAO.getInstance();
			productDAO.setConnection(con);
			product = productDAO.selectProduct(productCode);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return product;
	}
}