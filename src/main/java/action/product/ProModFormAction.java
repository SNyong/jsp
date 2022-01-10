package action.product;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.product.ProInfoService;
import vo.ActionForward;
import vo.Product;

public class ProModFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("MemberId");
		

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

			int ProductCode = Integer.parseInt(request.getParameter("ProductCode"));
			ProInfoService proInfoService = new ProInfoService();
			Product product = proInfoService.getproInfo(ProductCode);
			if (product == null) {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('수정할 물품정보가 없습니다.');");
				out.println("history.back();");
				out.println("</script>");
			} else {
				request.setAttribute("product", product);
				forward = new ActionForward();
				request.setAttribute("pagefile", "./admin.jsp");
				request.setAttribute("pagefile2", "./product/productMod.jsp");
				forward.setPath("template.jsp");
			}
		}

		return forward;
	}
}