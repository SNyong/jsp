package svc.Bucket;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.BucketDAO;

public class BucketModService {

	public boolean bucketMod(String id, String productCode, String bucketQ) {
		boolean modResult = false;
		Connection con = null;
		

		try {
			BucketDAO bucketDAO = BucketDAO.getInstance();
			con = getConnection();
			bucketDAO.setConnection(con);
			int modCount = bucketDAO.bucketMod(id, productCode, bucketQ);
			
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
