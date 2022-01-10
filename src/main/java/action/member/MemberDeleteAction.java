package action.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.member.MemberDeleteService;
import vo.ActionForward;

public class MemberDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		if ((session.getAttribute("MemberId") == null) || (!((String) session.getAttribute("MemberId")).equals("smart21kph"))) {
			response.setContentType("text/html;character=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('관리자로 로그인하세요.');");
			out.println("history.back();");
			out.println("</script>");
		} else {
			String del_id = request.getParameter("id");
			MemberDeleteService memberDeleteService = new MemberDeleteService();
			boolean isDeleteSuccess = memberDeleteService.deleteMember(del_id);

			if (!isDeleteSuccess) {
				response.setContentType("text/html;character=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('회원정보 삭제가 실패했습니다.');");
				out.println("history.back();");
				out.println("</script>");
			}else {
				forward =new ActionForward();
				forward.setPath("memberListAction.mem");
				forward.setRedirect(true);
			}
		}
		return forward;
	}

}
