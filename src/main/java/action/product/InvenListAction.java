package action.product;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.product.InvenListService;
import svc.product.ProListService;
import vo.ActionForward;
import vo.Inventory;
import vo.PageInfo;
import vo.Product;

public class InvenListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("MemberId");
		
		int page = 1;
		int limit = 15;
		int limitPage = 10;

		if (id == null) { // 로그인 했을시 사용(admin 권한)
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("loginForm.mem");
		} else if (!id.equals("smart21kph")) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('관리자만 가능합니다.');");
			out.println("history.back();");
			out.println("</script>");
		} else { // 세션 id가 smart21kph 일경우
		
			if(request.getParameter("page") != null
					&& !request.getParameter("page").trim().equals("")
					&& !request.getParameter("page").trim().equals("null")) {
				page = Integer.parseInt(request.getParameter("page"));
			}
		forward = new ActionForward();
		InvenListService invenListService = new InvenListService();
		
		int listCount = invenListService.getListCount();
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
		
		
		
		ArrayList<Inventory> invenList = invenListService.getinvenList(page, limit);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("invenList", invenList);
		request.setAttribute("pagefile", "./admin.jsp");
		request.setAttribute("pagefile2", "./product/invenList.jsp");
		forward.setPath("template.jsp");
		
		}
		return forward;
	}

}
