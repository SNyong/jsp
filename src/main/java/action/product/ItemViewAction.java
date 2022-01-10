package action.product;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.product.ProInfoService;
import vo.ActionForward;
import vo.Product;

public class ItemViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;

		int ProductCode = Integer.parseInt(request.getParameter("ProductCode"));
		ProInfoService proInfoService = new ProInfoService();
		Product product = proInfoService.getproInfo(ProductCode);
		if (product == null) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('불러올 물품이 없습니다.');");
			out.println("history.back();");
			out.println("</script>");
		} else {
			request.setAttribute("product", product);
			forward = new ActionForward();

			request.setAttribute("pagefile", "./product/itemView.jsp");
			forward.setPath("template.jsp");
		}
		return forward;
	}
}