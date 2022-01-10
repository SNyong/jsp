package action.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.member.MemberFindIdService;
import vo.ActionForward;
import vo.MemberBean;

public class FindIdAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		MemberBean member = new MemberBean();
		ActionForward forward = null;
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String id = request.getParameter("memberId");

		MemberFindIdService memberFindIdService = new MemberFindIdService();
		MemberBean memberFind = memberFindIdService.findId(name, email, id);

		if (memberFind != null) {
			forward = new ActionForward();
			request.setAttribute("memberFind", memberFind);
			System.out.println("비밀번호찾기 id " + id);
			if(id != null) {
			request.setAttribute("pagefile", "./member/idPwFind.jsp");
			forward.setPath("template.jsp");
			}else {
				request.setAttribute("pagefile", "./member/findId.jsp");
				forward.setPath("template.jsp");	
			}
		} else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('이름 또는 이메일을 확인하세요');");
			out.println("history.back();");
			out.println("</script>");
		}

		return forward;
	}

}