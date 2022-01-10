package action.product;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.product.ProSelectService;
import vo.ActionForward;

import vo.Product;

public class InvenModFormAction implements Action {

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
			
			forward = new ActionForward();
			int productCode = Integer.parseInt(request.getParameter("productCode"));
			ProSelectService proSelectService = new ProSelectService();
			Product product = proSelectService.getProSelect(productCode);
			request.setAttribute("product", product);

//			CountSelectService countSelectService = new CountSelectService();
//			Inventory inven = countSelectService.getCountSelect(productCode);
//			request.setAttribute("inven", inven);
			request.setAttribute("pagefile", "./admin.jsp");
			request.setAttribute("pagefile2", "./product/invenMod.jsp");
			forward.setPath("template.jsp");


			System.out.println("product : " + product);
//			System.out.println("inven : " + inven);
		}
		return forward;
	}

}