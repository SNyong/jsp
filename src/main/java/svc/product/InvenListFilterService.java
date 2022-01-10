package svc.product;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ProductDAO;
import vo.Inventory;

public class InvenListFilterService {

	public ArrayList<Inventory> getinvenListFilter(int code, int page, int limit) {
		Connection con = null;
		ArrayList<Inventory> invenList = null;

		try {
			con = getConnection();
			ProductDAO productDAO = ProductDAO.getInstance();
			productDAO.setConnection(con);
			invenList = productDAO.selectInventoryListFilter(code, page, limit);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}

		return invenList;
	}

	public int getListCount(int code) {
		int listCount = 0;
		Connection con = null;
		try {
			con = getConnection();
			ProductDAO productDAO = ProductDAO.getInstance();
			productDAO.setConnection(con);
			listCount = productDAO.selectListCountIF(code);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return listCount;
	}
}
