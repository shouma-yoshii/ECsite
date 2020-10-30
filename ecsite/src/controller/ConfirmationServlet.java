package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GetConnention;
import dao.ProductDao;
import dao.SalesDao;
import model.CartBean;
import model.ProductBean;
import model.UserBean;

/**
 * Servlet implementation class ConfirmationServlet
 */
@WebServlet("/Confirmation")
public class ConfirmationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session =request.getSession();
		CartBean cb =new CartBean();
		ProductBean pb =new ProductBean();
		ProductDao pd =new ProductDao();
		String name=null;
		int stock =0;
		int cd=0;
		int price=0;
		int pStock=0;
		Connection connection =null;
		UserBean ub = (UserBean)session.getAttribute("ui");
		ArrayList<CartBean> cart =(ArrayList<CartBean>)session.getAttribute("cart");

		try {
			connection = GetConnention.getConnection();
			connection.setAutoCommit(false);
			for(int i =0;i<cart.size();i++) {
				cb=cart.get(i);

				 name=cb.getPro_name();
				 stock=cb.getStock_no();
				 cd=cb.getPro_cd();
				 price=cb.getPro_price();


			ArrayList<ProductBean> product =pd.kensaku(name);

			for(int b = 0;b<product.size();b++) {
				pb=product.get(b);

				pStock=pb.getStock_no();
			}



			if(stock<=pStock) {
				SalesDao sd = new SalesDao();
				sd.sales(ub,cart,connection);
				pd.update(pStock-stock,cd,connection);



			}else {
				request.setAttribute("error", "在庫が無いか在庫数を超えた発注になっています。");
				RequestDispatcher rd = request.getRequestDispatcher("/view/Confirmation.jsp");
				rd.forward(request,response);
				connection.rollback();
			}

			}

			connection.commit();

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			try {



				connection.rollback();
			}catch(SQLException ex){
System.out.println("SQLExceptionだお");
			}

		}
		RequestDispatcher rd = request.getRequestDispatcher("/view/Complete.jsp");
		rd.forward(request,response);


	}


	}


