package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CategoryDao;
import dao.UserDao;
import model.CategoryBean;
import model.UserBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");


		RequestDispatcher rd = request.getRequestDispatcher("/jsp/Login.jsp");
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		UserBean ub = new UserBean();
		String name =request.getParameter("name");
		String pw =request.getParameter("pass");


		if(name.equals("") || pw.equals("")) {
			request.setAttribute("error", "名前またはパスワードを入力してください");
			RequestDispatcher rd = request.getRequestDispatcher("/view/Login.jsp");
			rd.forward(request,response);
			return;
		}


		UserDao ud =new UserDao();
		ub=ud.login(name, pw);


		if(ub.getId() ==0) {

			request.setAttribute("error", "名前またはパスワードが一致しません");
			RequestDispatcher rd = request.getRequestDispatcher("/view/Login.jsp");
			rd.forward(request,response);
			return;

		}else {

			HttpSession sc = request.getSession(true);
			sc.setAttribute("ui", ub);

			CategoryDao cd = new CategoryDao();
			ArrayList<CategoryBean> list2 = cd.Category();
			sc.setAttribute("Category", list2);
			RequestDispatcher rd = request.getRequestDispatcher("/view/Search.jsp");
			rd.forward(request,response);
			return;
		}

















	}

}
