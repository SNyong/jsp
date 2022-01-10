package action.Order;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.Order.OrderListService;
import vo.ActionForward;
import vo.Order;

public class OrderListAction implements Action {
@Override
public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("MemberId");
		System.out.println(id);
		
		if (id == null) { // 로그인 했을시 사용(admin 권한)
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("loginForm.mem");
		} else {
		
		forward = new ActionForward();
		OrderListService orderListService = new OrderListService();
		ArrayList<Order> orderList = orderListService.getOrderList(id);
		
		request.setAttribute("orderList", orderList);
		request.setAttribute("pagefile", "./order/orderList.jsp");
		forward.setPath("template.jsp");
		
		}
		return forward;
	}
}