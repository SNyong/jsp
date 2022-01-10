package action.member;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.member.MemberListService;
import vo.ActionForward;
import vo.MemberBean;
import vo.PageInfo;

public class MemberListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String memberId = (String) session.getAttribute("MemberId");
		ActionForward forward = null;

		int page = 1;
		int limit = 15;
		int limitPage = 10;
		
		
		if (memberId == null) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('관리자만 가능합니다 로그인하세요');");
			out.println("history.back();");
			out.println("</script>");
			
		} else if (!memberId.equals("smart21kph")) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('관리자 아이디 접속');");
			out.println("history.back();");
			out.println("</script>");

		} else {

			if(request.getParameter("page") != null
					&& !request.getParameter("page").trim().equals("")
					&& !request.getParameter("page").trim().equals("null")) {
				page = Integer.parseInt(request.getParameter("page")); 
				
			}
			forward = new ActionForward();
			MemberListService memberListService = new MemberListService();
			
			int listCount = memberListService.getListCount();
			int maxPage = (int) ((double) listCount / limit + 0.95);
			int startPage = ((int) ((double) page / limitPage + 0.9) - 1) * limitPage + 1;
			int endPage = startPage + limitPage - 1;
			if (endPage > maxPage) endPage = maxPage;
			
			PageInfo pageInfo = new PageInfo();
			pageInfo.setEndPage(endPage);
			pageInfo.setListCount(listCount);
			pageInfo.setMaxPage(maxPage);
			pageInfo.setPage(page);
			pageInfo.setStartPage(startPage);
			
			
			ArrayList<MemberBean> memberList = memberListService.getMemberList(page, limit);
			request.setAttribute("memberList", memberList);
			request.setAttribute("pageInfo", pageInfo);
			request.setAttribute("pagefile", "./admin.jsp");
			request.setAttribute("pagefile2", "./member/member_list.jsp");
			forward.setPath("template.jsp");
			

		}
		return forward;
	}

}
