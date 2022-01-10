package action.member;

import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.member.MemberJoinService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberJoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberBean member = new MemberBean();
		boolean joinResult = false;
		ActionForward forward = null;
		
		member.setMemberId(request.getParameter("MemberId"));
		member.setMemberPw(request.getParameter("MemberPw"));
		member.setM_Date(LocalDate.now().toString());
		member.setName(request.getParameter("Name"));
		member.setNumber(request.getParameter("Number"));
		member.setAge(Integer.parseInt(request.getParameter("Age")));
		member.setGender(Integer.parseInt(request.getParameter("Gender")));
		member.setEmail(request.getParameter("Email"));
		member.setAddress(request.getParameter("Address"));
		member.setPost(request.getParameter("Post"));
		member.setAddress1(request.getParameter("Address1"));
		
		MemberJoinService memberJoinService = new MemberJoinService();
		joinResult = memberJoinService.joinMember(member);

		
		if(joinResult == false) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('우편번호를 입력해 주세요');");
			out.println("history.back();");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("loginForm.mem");
		}
		return forward;
	}

}
