package action.Bucket;

import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.Bucket.BucketModService;
import svc.product.InvenModService;
import vo.ActionForward;
import vo.Bucket;
import vo.Inventory;

public class BucketModAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("MemberId");

		ActionForward forward = null;
		
		boolean modResult = false;
		
		String ProductCode[] = request.getParameterValues("productCode");
		String BucketQ[] = request.getParameterValues("bucketQ");
		
//		int ProductCode = Integer.parseInt(request.getParameter("productCode"));
//		int BucketQ = Integer.parseInt(request.getParameter("bucketQ"));

		for (int j = 0; j < ProductCode.length; j++) {
			BucketModService bucketModService = new BucketModService();
			modResult = bucketModService.bucketMod(id, ProductCode[j], BucketQ[j]);
		}

		
		if(modResult == false) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('수량변경 실패');");
			out.print("history.back();");
			out.print("</script>");
		}else {
			forward = new ActionForward();
			forward.setRedirect(true);

			forward.setPath("bucketList.buc");
		}
		return forward;
	}

}
