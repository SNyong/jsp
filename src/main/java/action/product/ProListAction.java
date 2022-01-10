package action.product;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.product.ProListService;
import vo.ActionForward;
import vo.PageInfo;
import vo.Product;

public class ProListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("MemberId");
		String category = request.getParameter("category");
		ActionForward forward = null;

		int page = 1;
		int limit = 15;
		int limitPage = 10;
			
		if (id == null) { // 아이디 만들고 사용
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("loginForm.mem");
		} else if (!id.equals("smart21kph")) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('관리자가 아닙니다.');");
			out.println("history.back();");
			out.println("</script>");

		} else {
			
			if(request.getParameter("page") != null
				&& !request.getParameter("page").trim().equals("")
				&& !request.getParameter("page").trim().equals("null")) {
			page = Integer.parseInt(request.getParameter("page"));
		}
			
			
			forward = new ActionForward();
			ProListService proListService = new ProListService();
			
			int listCount = proListService.getListCount();
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
			
			ArrayList<Product> proList = proListService.getproList(page, limit ,category);
			request.setAttribute("pageInfo", pageInfo);
			request.setAttribute("proList", proList);
			request.setAttribute("pagefile", "./admin.jsp");
			request.setAttribute("pagefile2", "./product/productList.jsp");
			forward.setPath("template.jsp");
		}
		return forward;
	}

}
