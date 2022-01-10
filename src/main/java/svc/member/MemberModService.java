package svc.member;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;
import vo.MemberBean;

public class MemberModService {
	public boolean ModMember(MemberBean member) {
		boolean ModSuccess = false;
		Connection con = null;
		try {

			MemberDAO memberDAO = MemberDAO.getInstance();
			con = getConnection();
			memberDAO.setConnection(con);
			int modyfiCount = memberDAO.updateMember(member);
			if (modyfiCount > 0) {
				ModSuccess = true;
				commit(con);
			} else {
				rollback(con);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}

		return ModSuccess;
	}
}
