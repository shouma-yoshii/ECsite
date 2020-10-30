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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		ProductDao pd = new ProductDao();

		//選ばれたpro_cd
		int cd = Integer.parseInt(request.getParameter("cd"));

		//選ばれたpro_cdをもとに商品情報を格納
		ProductBean pb = pd.product(cd);
		//選ばれた購入数
		int stock = Integer.parseInt(request.getParameter("stock"));
		//カート情報格納
		ArrayList<CartBean> cart = (ArrayList<CartBean>) session.getAttribute("cart");

		//カートがnullじゃなかった場合
		if (cart != null) {
			CartBean cb = new CartBean();

			int pro_cd = 0;
			int buy = 0;
			int i=0;
			for ( i = 0; i < cart.size(); i++) {
				cb = new CartBean();
				cb = cart.get(i);
				System.out.println(i);
				pro_cd = cb.getPro_cd();
				buy = cb.getStock_no();

				if (pro_cd == cd) {

					break;
				}

			}
			if(pro_cd == cd) {
				System.out.println("pro_cd:" + pro_cd + "、cd:" + cd);
				stock = buy + stock;
				cb.setStock_no(stock);
				cart.set(i, cb);
			}else {
				CartBean cartBean = new CartBean();
				cartBean.setPro_name(pb.getPro_name());
				cartBean.setPro_cd(pb.getPro_cd());
				cartBean.setPro_price(pb.getPro_price());
				cartBean.setStock_no(stock);
				cart.add(cartBean);
			}



			session.setAttribute("cart", cart);
			response.sendRedirect("/ecsite/view/Cart.jsp");

		} else {
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
