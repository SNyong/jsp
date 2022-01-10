package action.Bucket;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.Bucket.BucketListService;
import vo.ActionForward;
import vo.Bucket;

public class BucketListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("MemberId");
		System.out.println(id);
		
		
		if (id == null) { // 로그인 했을시 사용(관리자 권한)
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("loginForm.mem");
		}else {
		forward = new ActionForward();
		BucketListService BucketListService = new BucketListService();
		ArrayList<Bucket> bucketList = BucketListService.getbucketList(id);
		request.setAttribute("bucketList", bucketList);
		request.setAttribute("pagefile", "./product/bucketList.jsp");
		forward.setPath("template.jsp");

		}
		return forward;
	}

}
