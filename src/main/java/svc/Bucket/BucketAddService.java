package svc.Bucket;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.BucketDAO;
import vo.Bucket;

public class BucketAddService {

	public boolean addBucket(Bucket bucket) {
		boolean AddResult = false;
		Connection con = null;
		int addCount = 0;
		try {
			BucketDAO bucketDAO = BucketDAO.getInstance();
			con = getConnection();
			bucketDAO.setConnection(con);
			int check = bucketDAO.checkBucket(bucket);

			if(check == 1) {
				addCount = 1;
			}else {
				addCount = bucketDAO.addBucket(bucket);
			}
			
			if(addCount > 0) {
				AddResult = true;
				commit(con);
			}else {
				rollback(con);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		
		return AddResult;
	}

}
