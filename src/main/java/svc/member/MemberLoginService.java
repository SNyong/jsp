package svc.member;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;
import vo.MemberBean;

public class MemberLoginService {
	public MemberLoginService() {
	}

	public MemberBean loginId(String memberId, String memberPw) {
		Connection con = getConnection();
		MemberBean member = null;
		try {
			MemberDAO memberDAO = MemberDAO.getInstance();
			memberDAO.setConnection(con);
			member = memberDAO.selectLoginId(memberId, memberPw);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return member;
	}

}
