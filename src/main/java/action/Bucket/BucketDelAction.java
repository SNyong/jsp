package action.Bucket;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.Bucket.BucketDelService;
import svc.product.ProDelService;
import vo.ActionForward;

public class BucketDelAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("MemberId");
		ActionForward forward = null;
		
		
		int ProductCode = Integer.parseInt(request.getParameter("productCode"));
		BucketDelService bucketDelService = new BucketDelService();
		boolean deleteResult = bucketDelService.bucketDal(id, ProductCode);
		
		if (deleteResult == false) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('장바구니 삭제 실패');");
			out.println("history.back();");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("bucketList.buc");
		}
		
		
		
		return forward;
	}

}
