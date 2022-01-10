package action.Order;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.Order.OrderViewSvc;
import vo.ActionForward;
import vo.MemberBean;
import vo.Order;

public class OrderViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("MemberId");
		int orderCode = Integer.parseInt(request.getParameter("code"));
	System.out.println(orderCode);
		forward = new ActionForward();
		OrderViewSvc orderViewSvc = new OrderViewSvc();
		
		if(orderCode > 0) {
			ArrayList<Order> orderList = orderViewSvc.getOrderView(orderCode);
			MemberBean memberBean = orderViewSvc.loginMember(id);
			forward = new ActionForward();
			request.setAttribute("orderList", orderList);
			request.setAttribute("member", memberBean);
			request.setAttribute("pagefile", "./order/orderView.jsp");
			forward.setPath("template.jsp");
		}else {
			ArrayList<Order> result = orderViewSvc.orderList(id);
			MemberBean memberBean = orderViewSvc.loginMember(id);
			forward = new ActionForward();
			request.setAttribute("order", result);
			request.setAttribute("member", memberBean);
			request.setAttribute("pagefile", "./order/orderView.jsp");
			forward.setPath("template.jsp");
		}
		
		
		return forward;
	}
}