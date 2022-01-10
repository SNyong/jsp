package action.product;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import action.Action;
import svc.product.ProModService;
import vo.ActionForward;
import vo.Product;

public class ProModAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		boolean modResult = false;

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
			request.setAttribute("pagefile", "loginForm.mem");
			forward.setPath("template.jsp");
		} else if (!id.equals("smart21kph")) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('관리자만 가능합니다.');");
			out.println("history.back();");
			out.println("</script>");
		} else { // 세션 id가 smart21kph 일경우

			request.setCharacterEncoding("utf-8");

		System.out.println("image" + image);
			Product proAdd = new Product(
					Integer.parseInt(multi.getParameter("code")),
					multi.getParameter("name"),
					0,
					Integer.parseInt(multi.getParameter("buyprice")),
					Integer.parseInt(multi.getParameter("sellprice")),
					multi.getParameter("note"),
					0,
					image,
					Integer.parseInt(multi.getParameter("hidden")),
					0
					);

//			product.setProductCode(Integer.parseInt(request.getParameter("code")));
//			product.setProductName(request.getParameter("name"));
//			product.setProductBuyPrice(Integer.parseInt(request.getParameter("buyprice")));
//			product.setProductSellPrice(Integer.parseInt(request.getParameter("sellprice")));
//			product.setNote(request.getParameter("note"));
//			product.setImage(request.getParameter("image"));
//			product.setHidden(Integer.parseInt(request.getParameter("hidden")));

			ProModService proModService = new ProModService();
			modResult = proModService.ModProduct(proAdd);

			if (modResult == false) {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('물품 수정 실패');");
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
