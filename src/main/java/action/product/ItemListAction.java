package action.product;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.product.ProListService;
import vo.ActionForward;
import vo.Product;

public class ItemListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = null;

			int Category = Integer.parseInt(request.getParameter("Category"));
			forward = new ActionForward();
			ProListService proListService = new ProListService();
			ArrayList<Product> proList = proListService.getItemList(Category);
			request.setAttribute("proList", proList);
//			forward.setPath("./product/itemList.jsp");
			
			request.setAttribute("pagefile", "./product/itemList.jsp");
			forward.setPath("template.jsp");
		
		return forward;
	}

}
