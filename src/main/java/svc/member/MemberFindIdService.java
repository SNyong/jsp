package svc.member;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;
import vo.MemberBean;

public class MemberFindIdService {

	public MemberFindIdService() {
	}

	public MemberBean findId(String name, String email, String id) {
		MemberBean memberFind = new MemberBean();
		Connection con = null;
		try {
			con = getConnection();
			MemberDAO memberDAO = MemberDAO.getInstance();
			memberDAO.setConnection(con);
			memberFind = memberDAO.findId(name, email, id);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return memberFind;
	}

}