package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.UserBean;

/**
 * Servlet implementation class MakeAccountServlet
 */
@WebServlet("/MakeAccount")
public class MakeAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher rd = request.getRequestDispatcher("/view/MakeAccount.jsp");
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		UserDao ud =new UserDao();
		String name =request.getParameter("id");
		String password=request.getParameter("password");


		if(name.equals("")||password.equals("")) {
			request.setAttribute("error", "IDまたはパスワードが入力されていません。");
			RequestDispatcher rd = request.getRequestDispatcher("/view/MakeAccount.jsp");
			rd.forward(request,response);
		}

		ArrayList<UserBean> aub =ud.make(name, password);
		if(aub.size()==0) {
			ud.MakeAccount(name, password);
			request.setAttribute("set","アカウント作成完了しました。" );
			RequestDispatcher rd = request.getRequestDispatcher("/view/Login.jsp");
			rd.forward(request,response);
		}else {
			request.setAttribute("error","ユーザー名またはパスワードが既に使用されています。" );
			RequestDispatcher rd = request.getRequestDispatcher("/view/MakeAccount.jsp");
			rd.forward(request,response);
		}




	}

}
