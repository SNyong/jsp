package action.Bucket;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.Bucket.BucketAddService;
import vo.ActionForward;
import vo.Bucket;

public class BucketAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("MemberId");
		System.out.println(id);
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("utf-8");
		boolean AddResult = false;

		if (id == null) {
			forward.setRedirect(true);
			forward.setPath("loginForm.mem");
			return forward;
		}

		Bucket bucket = new Bucket();
		bucket.setProductCode(Integer.parseInt(request.getParameter("productCode")));
		bucket.setBucketQ(Integer.parseInt(request.getParameter("count")));
		bucket.setMemberId(id);

		BucketAddService bucketAddService = new BucketAddService();
		AddResult = bucketAddService.addBucket(bucket);

		if (AddResult == false) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('장바구니 담기 실패');");
			out.print("history.back();");
			out.print("</script>");
		} else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("bucketList.buc");
		}
		return forward;
	}

}
