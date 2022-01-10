package svc.product;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.ProductDAO;
import vo.Inventory;

public class InvenSelectService {

	public Inventory getInvenSelect(String productCode) {
		Connection con = null;
		Inventory inventory = null;
		try {
			con = getConnection();
			ProductDAO productDAO = ProductDAO.getInstance();
			productDAO.setConnection(con);
			inventory = productDAO.selectInventory(productCode);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return inventory;
	}

}