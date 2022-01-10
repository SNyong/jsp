package dao;

import static db.JdbcUtil.*;

import java.sql.*;
import java.util.ArrayList;
import vo.MemberBean;

public class MemberDAO {
	private Connection con;
	
	private static MemberDAO memberDAO;

	public static MemberDAO getInstance() {
		if (memberDAO == null)
			memberDAO = new MemberDAO();
		return memberDAO;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public int insertMember(MemberBean member) {
		int insertCount = 0;
		PreparedStatement pstmt = null;
		String sql = "insert into Member values (?,?,?,?,?,?,?,?,?,?,?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getM_Date());
			pstmt.setString(4, member.getName());
			pstmt.setString(5, member.getNumber());
			pstmt.setInt(6, member.getAge());
			pstmt.setInt(7, member.getGender());
			pstmt.setString(8, member.getEmail());
			pstmt.setString(9, member.getAddress());
			pstmt.setString(10, member.getPost());
			pstmt.setString(11, member.getAddress1());

			insertCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return insertCount;
	}

	public MemberBean selectMember(String MemberId) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		MemberBean member = null;
		try {
			pstmt = con.prepareStatement("select * from Member where MemberId=?");
			pstmt.setString(1, MemberId);
			rs = pstmt.executeQuery();
			System.out.println(MemberId);
			if (rs.next()) {
				member = new MemberBean();
				member.setMemberId(rs.getString("MemberId"));
				member.setMemberPw(rs.getString("MemberPw"));
				member.setM_Date(rs.getString("M_Date"));
				member.setName(rs.getString("Name"));
				member.setNumber(rs.getString("Number"));
				member.setAge(rs.getInt("Age"));
				member.setGender(rs.getInt("Gender"));
				member.setEmail(rs.getString("Email"));
				member.setAddress(rs.getString("Address"));
				member.setPost(rs.getString("Post"));
				member.setAddress1(rs.getString("Address1"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return member;
	}

	public MemberBean selectLoginId(String memberId, String memberPw) {

		MemberBean member = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from Member where MemberId=? and MemberPw = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				member = new MemberBean();
				member.setMemberId(rs.getString("MemberId"));
				member.setMemberPw(rs.getString("MemberPw"));
				member.setM_Date(rs.getString("M_Date"));
				member.setName(rs.getString("Name"));
				member.setNumber(rs.getString("Number"));
				member.setAge(rs.getInt("Age"));
				member.setGender(rs.getInt("Gender"));
				member.setEmail(rs.getString("Email"));
				member.setAddress(rs.getString("Address"));
				member.setPost(rs.getString("Post"));
				member.setAddress1(rs.getString("Address1"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return member;
	}

	public MemberBean selectMemberAddress(String id) {
		MemberBean member = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from Member where MemberId =?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				member = new MemberBean();
				member.setName(rs.getString("Name"));
				member.setNumber(rs.getString("Number"));
				member.setAddress(rs.getString("Address"));
				member.setPost(rs.getString("Post"));
				member.setAddress1(rs.getString("Address1"));
				member.setMemberId(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return member;
	}

	public ArrayList<MemberBean> selectMemberList(int page, int limit) {
		// TODO Auto-generated method stub
		MemberBean member = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM Member order by MemberId asc limit ?,?";
		ArrayList<MemberBean> memberList = null;
		int startrow = (page - 1) * limit;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, limit);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				memberList = new ArrayList<MemberBean>();
				do {
					member = new MemberBean();
					member.setMemberId(rs.getString("MemberId"));
					member.setMemberPw(rs.getString("MemberPw"));
					member.setM_Date(rs.getString("M_Date"));
					member.setName(rs.getString("Name"));
					member.setNumber(rs.getString("Number"));
					member.setAge(rs.getInt("Age"));
					member.setGender(rs.getInt("Gender"));
					member.setEmail(rs.getString("Email"));
					member.setAddress(rs.getString("Address"));
					member.setPost(rs.getString("Post"));
					member.setAddress(rs.getString("Address1"));
					memberList.add(member);
				} while (rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return memberList;
	}

	public int updateMember(MemberBean member) {
		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql = "update Member set MemberPw = ?, Name = ?, Number =?, Age = ?, Gender = ?, Email = ?, Address = ?, Post = ?, Address1 = ? where MemberId = ?";
		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, member.getMemberPw());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getNumber());
			pstmt.setInt(4, member.getAge());
			pstmt.setInt(5, member.getGender());
			pstmt.setString(6, member.getEmail());
			pstmt.setString(7, member.getAddress());
			pstmt.setString(8, member.getPost());
			pstmt.setString(9, member.getAddress1());
			pstmt.setString(10, member.getMemberId());

			updateCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return updateCount;
	}

	public int deleteMember(String memberId) {

		PreparedStatement pstmt = null;
		int deleteCount = 0;
		String sql = "delete from Member where MemberId=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberId);
			deleteCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return deleteCount;
	}

	public int selectListCount() {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement("select count(*) from Member");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("getListCount 에러 : " + e);
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return listCount;
	}

	public MemberBean findId(String name, String email, String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberBean memberFind = null;
		String sql = "select * from Member where Name =? and Email =?";
		
		if(id != null) {
			sql += "and MemberId =?";
		}
		try {

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, name);
			pstmt.setString(2, email);
			if(id != null) {
			pstmt.setString(3, id);
			}
			rs = pstmt.executeQuery();
			System.out.println(pstmt);

			if (rs.next()) {
				memberFind = new MemberBean();
				memberFind.setMemberId(rs.getString("MemberId"));
				memberFind.setMemberPw(rs.getString("MemberPw"));
				memberFind.setName(rs.getString("Name"));
				memberFind.setEmail(rs.getString("Email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return memberFind;
	}

}
