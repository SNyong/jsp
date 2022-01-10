package action.Order;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.Order.OrderOkListSvc;
import vo.ActionForward;
import vo.Order;

public class OrderOkListAction implements Action {

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      HttpSession session = request.getSession();
      String id = (String) session.getAttribute("MemberId");
      System.out.println(id);
      ActionForward forward = null;
   
      if (id == null) { // 아이디 만들고 사용
         forward = new ActionForward();
         forward.setRedirect(true);
         forward.setPath("loginForm.mem");
      } else {
         forward = new ActionForward();
         OrderOkListSvc orderOKListSvc = new OrderOkListSvc();
         ArrayList<Order> order = orderOKListSvc.getOrderList(id);
         
         request.setAttribute("order", order);
         request.setAttribute("pagefile", "./order/orderOKList.jsp");
         forward.setPath("template.jsp");
         
      }
      return forward;
   }
}