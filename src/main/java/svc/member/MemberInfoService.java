package svc.member;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BucketDAO;
import dao.MemberDAO;
import vo.Bucket;
import vo.MemberBean;

public class MemberInfoService {
	public MemberBean loginMember(String id) {
		MemberBean member = new MemberBean();
		Connection con = null;
		try {
			con = getConnection();
			MemberDAO memberDAO = MemberDAO.getInstance();
			memberDAO.setConnection(con);
			member = memberDAO.selectMember(id);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return member;
	}

	public ArrayList<Bucket> selects(String id, String[] productCode) {
		 ArrayList<Bucket> result = null;
		Connection con = null;
		try {
			con = getConnection();
			BucketDAO bucketDAO = BucketDAO.getInstance();
			bucketDAO.setConnection(con);
			result = bucketDAO.selects(id, productCode);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return result;
	}

}
