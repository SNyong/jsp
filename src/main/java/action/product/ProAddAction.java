package action.product;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import action.Action;
import svc.product.ProAddService;
import vo.ActionForward;

import vo.Product;

public class ProAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		boolean addResult = false;
		ActionForward forward = null;
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("MemberId");

		//파일 업로드
		String realFolder = "./image";
		//파일 업로드될 서버 상의물리적인 경로
		String saveFolder = "./image";
		String encType = "UTF-8";
		int maxSize = 30*1024*1024;
		//파일 업로드 할수있는 크기 30mb
		
		
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest(request,realFolder,maxSize, encType, new DefaultFileRenamePolicy());
		String image = multi.getFilesystemName("image");
		
		if (id == null) { // 로그인 했을시 사용(admin 권한)
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("loginForm.mem");
		} else if (!id.equals("smart21kph")) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('관리자만 가능합니다.');");
			out.println("history.back();");
			out.println("</script>");
		} else { // 세션 id가 smart21kph 일경우
			Product proAdd = new Product(
					0,
					multi.getParameter("name"),
					Integer.parseInt(multi.getParameter("category")),
					Integer.parseInt(multi.getParameter("buyprice")),
					Integer.parseInt(multi.getParameter("sellprice")),
					multi.getParameter("note"),
					0,
					image,
					Integer.parseInt(multi.getParameter("hidden")),
					0
					);
			
			ProAddService productAddService = new ProAddService();
			addResult = productAddService.addProduct(proAdd);

			if (addResult == false) {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('물품 등록실패');");
				out.println("history.back();");
				out.println("</script>");
			} else {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("productList.pro");
			}
		}
		return forward;
	}
}