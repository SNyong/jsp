package svc.product;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.ProductDAO;
import vo.Product;

public class ProSelectService {

	public Product getProSelect(int productCode) {
		Connection con = null;
		Product product = null;
		try {
			con = getConnection();
			ProductDAO productDAO = ProductDAO.getInstance();
			productDAO.setConnection(con);
			product = productDAO.selectProduct(productCode);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return product;
	}
	
}
