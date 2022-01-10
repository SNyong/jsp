package svc.Bucket;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BucketDAO;
import vo.Bucket;

public class BucketListService {

	public ArrayList<Bucket> getbucketList(String id) {
		Connection con = null;
		ArrayList<Bucket> bucketList = null;

		try {
			con = getConnection();
			BucketDAO bucketDAO = BucketDAO.getInstance();
			bucketDAO.setConnection(con);
			bucketList = bucketDAO.bucketList(id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}

		return bucketList;
	}
}
