package svc.Bucket;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.BucketDAO;
import dao.ProductDAO;

public class BucketDelService {

	public boolean bucketDal(String id, int productCode) {
		boolean deleteResult = false;

		Connection con = null;

		try {
			con = getConnection();
			BucketDAO bucketDAO = BucketDAO.getInstance();
			bucketDAO.setConnection(con);
			int deleteCount = bucketDAO.bucketDel(id, productCode);
			if (deleteCount > 0) {
				deleteResult = true;
				commit(con);
			} else {
				rollback(con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return deleteResult;
	}
}