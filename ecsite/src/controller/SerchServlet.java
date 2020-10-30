package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDao;
import dao.ProductDao;
import model.CategoryBean;
import model.ProductBean;

/**
 * Servlet implementation class SerchServlet
 */
@WebServlet("/serch")
public class SerchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SerchServlet() {
        super();
    }




	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ

		String name =request.getParameter("name");
		ProductDao pd =new ProductDao();
		ProductBean pb =pd.product(name);
		CategoryDao cd =new CategoryDao();
		int cat_id=pb.getCat_id();
		CategoryBean product =cd.Category(cat_id);

			String cat_name = product.getCat_name();

			 request.setAttribute("cat_name", cat_name);

		request.setAttribute("pb",pb);

		RequestDispatcher rd = request.getRequestDispatcher("/view/ProductDetails.jsp");
		rd.forward(request,response);

	}








	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String key =request.getParameter("keyword");
		int category =Integer.parseInt(request.getParameter("category"));
		System.out.println(key + ":" + category);
		ProductDao pd = new ProductDao();
		ProductBean pb =new ProductBean();

		ArrayList<ProductBean> plist =new ArrayList<ProductBean>();

		if(key.equals("") && category==0) {
			System.out.println("全検索");
			plist=pd.kensaku();
			for(int i=0;i<plist.size();i++) {
				pb=plist.get(i);

			}
		}else if (key.equals("")&&category>0) {
			System.out.println("カテゴリー検索");
			plist=pd.kensaku(category);


		}else if(key!=""&&category==0) {
			System.out.println("キーワード検索");
			plist=pd.kensaku(key);

		}else if(key!=""&&category>0){
			System.out.println("両方検索");
			plist=pd.kensaku(key, category);


		}


		if(plist.size()==0){
			plist=null;
			request.setAttribute("error", "該当する結果がありませんでした。");

		}

		request.setAttribute("result", plist);
		RequestDispatcher rd = request.getRequestDispatcher("/view/Search.jsp");
		rd.forward(request,response);



	}

}
