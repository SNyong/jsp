package action.product;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.product.ProDelService;
import vo.ActionForward;

public class ProDelAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("MemberId");
		ActionForward forward = null;
		
		if(id == null) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("loginForm.mem");
			
		} else if(!id.equals("smart21kph")) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('관리자만 삭제 가능합니다.');");
			out.println("history.back();");
			out.println("</script>");
		}else {
			int ProductCode = Integer.parseInt(request.getParameter("ProductCode"));
			ProDelService proDelService = new ProDelService();
			boolean deleteResult = proDelService.delProduct(ProductCode);
		
			if (deleteResult == false) {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('물품 삭제 실패');");
				out.println("history.back();");
				out.println("</script>");
			} else {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("productList.pro");
			}
			
		}
		return forward;
	}

}
