package action.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.member.MemberModService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;

		HttpSession session = request.getSession();
		String sid = (String) session.getAttribute("MemberId");
		String id = request.getParameter("MemberId");
		System.out.println(id);

		if (id == null || (!sid.equals("smart21kph")) && !sid.equals(id)) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('관리자로 로그인 하세요.');");
			out.println("history.back();");
			out.println("</script>");
		} else {
			MemberBean member = new MemberBean();
			member.setMemberId(request.getParameter("MemberId"));
			member.setMemberPw(request.getParameter("MemberPw"));
			member.setM_Date(request.getParameter("M_Date"));
			member.setName(request.getParameter("Name"));
			member.setNumber(request.getParameter("Number"));
			member.setAge(Integer.parseInt(request.getParameter("Age")));
			member.setGender(Integer.parseInt(request.getParameter("Gender")));
			member.setEmail(request.getParameter("Email"));
			member.setAddress(request.getParameter("Address"));
			member.setPost(request.getParameter("Post"));
			member.setAddress1(request.getParameter("Address1"));

			MemberModService memberModService = new MemberModService();
			boolean isModifySuccess = memberModService.ModMember(member);

			if (!isModifySuccess) {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('수정이 완료되지 않았습니다.');");
				out.println("history.back();");
				out.println("</script>");
			} else {
				forward = new ActionForward();

				if (sid.equals("smart21kph")) {
					forward.setPath("memberListAction.mem");
				} else {
					forward.setPath("main.pro");
				}
				forward.setRedirect(true);
			}	
		}

		return forward;
	}
}
