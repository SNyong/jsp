package svc.member;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;

public class MemberDeleteService {
	public boolean deleteMember(String deleteId) {
		boolean deleteResult = false;

		Connection con = null;

		try {
			con = getConnection();
			MemberDAO memberDAO = MemberDAO.getInstance();
			memberDAO.setConnection(con);
			int deleteCount = memberDAO.deleteMember(deleteId);
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
