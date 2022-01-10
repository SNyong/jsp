package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.product.*;
import vo.ActionForward;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("*.pro")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		System.out.println(command);

		Action action = null;
		ActionForward forward = null;

		if (command.equals("/productList.pro")) { //물품 리스트
			action = new ProListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/productAdd.pro")) {  //물품 추가
			action = new ProAddAction();
			try {
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/productAddForm.pro")) {  //물품 추가
			try {
				forward = new ActionForward();
				request.setAttribute("pagefile", "./admin.jsp");
				request.setAttribute("pagefile2", "./product/productAdd.jsp");
				forward.setPath("template.jsp");
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/proDelAction.pro")) { //삭제 액션
			action = new ProDelAction();
			try {
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/proModForm.pro")) { //삭제 액션
			action = new ProModFormAction();
			try {
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/productMod.pro")) { //삭제 액션
			action = new ProModAction();
			try {
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/invenModForm.pro")) { //재고 입출고 입력폼
			action = new InvenModFormAction();
			try {
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/invenMod.pro")) { //재고 입출고
			action = new InvenModAction();
			try {
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/invenList.pro")) { //입출고 내역 리스트
			action = new InvenListAction();
			try {
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/invenListfilter.pro")) {  //입출고 내역 리스트 필터
			action = new InvenListFilterAction();
			try {
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/itemList.pro")) {  //아이템 리스트
			action = new ItemListAction();
			try {
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/itemView.pro")) {  //아이템 상세보기
			action = new ItemViewAction();
			try {
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/main.pro")) {  //메인페이지 가기
			forward = new ActionForward();
			request.setAttribute("pagefile", "./index_main.jsp");
			forward.setPath("template.jsp");
		}else if(command.equals("/admin.pro")) {  //관리자 페이지
			forward = new ActionForward();
			request.setAttribute("pagefile", "./admin.jsp");
			forward.setPath("template.jsp");
		}
		
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}
}
