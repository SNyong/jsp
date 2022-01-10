package action.product;

import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.product.InvenModService;
import vo.ActionForward;
import vo.Inventory;

public class InvenModAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Inventory inven = new Inventory();
		boolean modResult = false;
		ActionForward forward = null;
		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("MemberId");

		if (id == null) { // 로그인 했을시 사용(admin 권한)
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./memberLogin.mem");
		} else if (!id.equals("smart21kph")) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('관리자만 가능합니다.');");
			out.println("history.back();");
			out.println("</script>");
		} else { // 세션 id가 smart21kph 일경우

			inven.setInOutcomming(Integer.parseInt(request.getParameter("inout")));
			inven.setI_Date(LocalDate.now().toString());
			inven.setProductCount(Integer.parseInt(request.getParameter("inoutCount")));
			inven.setProductCode(Integer.parseInt(request.getParameter("ProductCode")));
			inven.setTotalCount(Integer.parseInt(request.getParameter("TotalCount")));

			InvenModService invenModService = new InvenModService();
			modResult = invenModService.modInven(inven);

			if (modResult == false) {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print("<script>");
				out.print("alert('재고등록 실패');");
				out.print("history.back();");
				out.print("</script>");
			} else {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("productList.pro");
			}
		}
		return forward;
	}

}
