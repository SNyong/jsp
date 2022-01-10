package svc.member;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import dao.MemberDAO;
import vo.MemberBean;

public class MemberAddressService {

	public MemberBean getMemberAddress(String id) {
		Connection con = null;
		MemberBean member = null;

		try {
			con = getConnection();
			MemberDAO memberDAO = MemberDAO.getInstance();
			memberDAO.setConnection(con);
			member = memberDAO.selectMemberAddress(id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}

		return member;
	}

}
