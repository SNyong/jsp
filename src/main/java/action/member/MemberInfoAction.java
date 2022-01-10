package action.member;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.member.MemberInfoService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberInfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;

		HttpSession session = request.getSession();
		String id = request.getQueryString().split("=")[1];	
				
		if (id == null || !session.getAttribute("MemberId").equals("smart21kph")) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('관리자로 로그인하세요!!')");
			out.println("history.back();");
			out.println("</script>");
		} else {
			MemberInfoService memberInfoService = new MemberInfoService();
			MemberBean member = memberInfoService.loginMember(id);

			if (member == null) {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('검색한 회원 정보가 없습니다.');");
				out.println("history.back();");
				out.println("</script>");
			} else {
				forward = new ActionForward();
				request.setAttribute("member", member);
				request.setAttribute("pagefile", "./admin.jsp");
				request.setAttribute("pagefile2", "./member/member_info.jsp");
				forward.setPath("template.jsp");
			}
		}

		return forward;
	}

}
