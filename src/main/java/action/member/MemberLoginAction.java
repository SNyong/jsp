package action.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.member.MemberLoginService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberLoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		MemberBean member = new MemberBean();
		ActionForward forward = null;

		member.setMemberId(request.getParameter("MemberId"));
		member.setMemberPw(request.getParameter("MemberPw"));

		MemberLoginService memberLoginService = new MemberLoginService();
		MemberBean loginResult = memberLoginService.loginId(member.getMemberId(), member.getMemberPw());

		if (loginResult != null) {
			forward = new ActionForward();
			session.setAttribute("MemberId", member.getMemberId());
			if (member.getMemberId().equals("smart21kph")) {
				forward.setRedirect(true);
				forward.setPath("main.pro");
			} else {
				forward.setRedirect(true);
				forward.setPath("main.pro");
			
			}

		} else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('아이디 비밀번호를 확인하세요');");
			out.println("history.back();");
			out.println("</script>");
		}
		return forward;
	}

}
