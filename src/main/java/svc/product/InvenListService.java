package svc.product;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ProductDAO;
import vo.Inventory;
import vo.Product;

public class InvenListService {

	public int getListCount() {
		int listCount = 0;
		Connection con = null;
		try {
			con = getConnection();
			ProductDAO productDAO = ProductDAO.getInstance();
			productDAO.setConnection(con);
			listCount = productDAO.selectListCountI();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return listCount;
	}
	
	public ArrayList<Inventory> getinvenList(int page, int limit) {
		Connection con = null;
		ArrayList<Inventory> invenList = null;

		try {
			con = getConnection();
			ProductDAO productDAO = ProductDAO.getInstance();
			productDAO.setConnection(con);
			invenList = productDAO.selectInventoryList(page, limit);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}

		return invenList;
	}

	


}
