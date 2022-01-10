package action.Order;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.member.MemberInfoService;
import vo.*;

public class OrderAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		String productCode[] = request.getParameterValues("chkbox");
		String ch[] = request.getParameterValues("chkbox");

		if (productCode == null) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('주문을 선택하십시오.');");
			out.println("history.back();");
			out.println("</script>");
		} else {

			for (int j = 0; j < ch.length; j++) {
				for (int i = 0; i < productCode.length; i++) {
					if (Integer.parseInt(ch[j]) == i) {
						System.out.println("ch : " + ch[j] + " code : " + productCode[i]);
					}
				}
			}

			HttpSession session = request.getSession();
			String id = (String) session.getAttribute("MemberId");

			MemberInfoService memberInfoService = new MemberInfoService();
			MemberBean memberBean = memberInfoService.loginMember(id);
			ArrayList<Bucket> result = memberInfoService.selects(id, productCode);

			forward = new ActionForward();
			request.setAttribute("orderList", result);
			request.setAttribute("member", memberBean);
			request.setAttribute("pagefile", "./order/orderList.jsp");
			forward.setPath("template.jsp");
		}

		return forward;
	}
}