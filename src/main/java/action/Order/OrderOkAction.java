package action.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.Order.OrderService;
import vo.ActionForward;
import vo.Order;
import vo.OrderDetail;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderOkAction implements Action {

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      ActionForward forward = null;
      HttpSession session = request.getSession();
      request.setCharacterEncoding("utf-8");

      String id = (String) session.getAttribute("MemberId");
      String productCode[] = request.getParameterValues("productCode");
      String detailQ[] = request.getParameterValues("qntty");
      String address = request.getParameter("address");
      String bucketCode[] = request.getParameterValues("bucketCode");
      int total = Integer.parseInt(request.getParameter("total"));

      if (id == null) {
    	 forward = new ActionForward();
         forward.setRedirect(true);
         forward.setPath("loginForm.mem");
         return forward;
      } else {

      Order order = new Order();
      order.setOrderDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
      order.setMemberId(id);
      order.setAddress(address);
      order.setTotalPrice(total);

      List<OrderDetail> orderList = new ArrayList<>();
      
      for(int i=0; i<productCode.length; i++) {
         OrderDetail orderDetail = new OrderDetail();
         orderDetail.setProductCode(Integer.parseInt(productCode[i]));
         orderDetail.setDetailQ(Integer.parseInt(detailQ[i]));
         orderDetail.setBucketCode(Integer.parseInt((bucketCode[i])));
         orderList.add(orderDetail);
      }
      
      order.setOrderList(orderList);
      OrderService orderService = new OrderService();
      orderService.addOrder(order, id);

      
      
      forward = new ActionForward();
      request.setAttribute("orderList", orderList);
      request.setAttribute("pagefile", "./order/orderOK.jsp");
      forward.setPath("template.jsp");
      }
      
      return forward;
   }
}