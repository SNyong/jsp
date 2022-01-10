package svc.product;

import vo.Inventory;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.ProductDAO;

public class InvenModService {
	public boolean modInven(Inventory inven) {
		boolean modResult = false;
		Connection con = null;
		try {
			ProductDAO productDAO = ProductDAO.getInstance();
			con = getConnection();
			productDAO.setConnection(con);
			int modCount = productDAO.modInventory(inven);
			
			if(modCount > 0) {
				modResult = true;
				commit(con);
			}else {
				rollback(con);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		
		return modResult;
	}

}
