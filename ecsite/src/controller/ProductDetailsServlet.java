package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDao;
import model.CartBean;
import model.ProductBean;

/**
 * Servlet implementation class ProductDetailsServlet
 */
@WebServlet("/product")
public class ProductDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /*
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		ProductDao pd = new ProductDao();

		int cd =Integer.parseInt(request.getParameter("cd"));
		ProductBean pb = pd.product(cd);
		int stock =Integer.parseInt(request.getParameter("stock"));
		ArrayList<CartBean> cart =(ArrayList<CartBean>) session.getAttribute("cart");

		if(cart!=null) {
			CartBean cb = new CartBean();


				cb.setPro_name(pb.getPro_name());
				cb.setPro_cd(pb.getPro_cd());
				cb.setPro_price(pb.getPro_price());
				cb.setStock_no(stock);

				cart.add(cb);

				session.setAttribute("cart", cart);
				response.sendRedirect("/ecsite/view/Cart.jsp");

		}else{
			 cart = new ArrayList<CartBean>();
			CartBean cb = new CartBean();


				cb.setPro_name(pb.getPro_name());
				cb.setPro_cd(pb.getPro_cd());
				cb.setPro_price(pb.getPro_price());
				cb.setStock_no(stock);

				cart.add(cb);


			session.setAttribute("cart", cart);

			response.sendRedirect("/ecsite/view/Cart.jsp");

		}

	}

}
