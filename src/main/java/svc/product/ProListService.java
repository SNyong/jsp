package svc.product;

import java.sql.Connection;
import java.util.ArrayList;
import static db.JdbcUtil.*;

import dao.ProductDAO;
import vo.Product;

public class ProListService {

	public int getListCount() throws Exception {
		int listCount = 0;
		Connection con = null;
		try {
			con = getConnection();
			ProductDAO productDAO = ProductDAO.getInstance();
			productDAO.setConnection(con);
			listCount = productDAO.selectListCount();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return listCount;
	}

	public ArrayList<Product> getproList(int page, int limit, String category) {
		Connection con = null;
		ArrayList<Product> proList = null;

		try {
			con = getConnection();
			ProductDAO productDAO = ProductDAO.getInstance();
			productDAO.setConnection(con);
			proList = productDAO.selectProductList(page, limit, category);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}

		return proList;
	}

	public ArrayList<Product> getItemList(int category) {
		Connection con = null;
		ArrayList<Product> proList = null;

		try {
			con = getConnection();
			ProductDAO productDAO = ProductDAO.getInstance();
			productDAO.setConnection(con);
			proList = productDAO.selectItemList(category);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return proList;
	}

}
