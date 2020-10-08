package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ProductBean;

public class ProductDao {

	public ArrayList<ProductBean> kensaku(){
		String url = "jdbc:mysql://localhost/ecsite";
		String id = "root";
		String pass = "password";
		Connection conn = null;
		PreparedStatement pstmt = null;

		ArrayList<ProductBean> apb =new ArrayList<ProductBean>();

		ResultSet rs = null;

		{
		//JDBcドライバの登録
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		//データベースへの接続
		try {
			//SQLの発行
			conn = DriverManager.getConnection(url, id, pass);


			String query = "select * from product";
			pstmt = conn.prepareStatement(query);
			rs=pstmt.executeQuery();

			while(rs.next()) {
				ProductBean pb = new ProductBean();

				pb.setPro_cd(rs.getInt("pro_cd"));
				pb.setPro_name(rs.getString("pro_name"));
				pb.setStock_no(rs.getInt("stock_no"));
				pb.setPro_price(rs.getInt("pro_price"));
				pb.setCat_id(rs.getInt("cat_id"));
				pb.setPro_img(rs.getString("pro_img"));
				pb.setPro_msg(rs.getString("pro_msg"));

				apb.add(pb);
			}


		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
			}

		}return apb;
	}
		}

	public ArrayList<ProductBean> kensaku(String key){
	String url = "jdbc:mysql://localhost/ecsite";
	String id = "root";
	String pass = "password";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ProductBean pb = new ProductBean();
	ArrayList<ProductBean> apb =new ArrayList<ProductBean>();


	ResultSet rs = null;

	{
	//JDBcドライバの登録
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException ex) {
		ex.printStackTrace();
	}
	//データベースへの接続
	try {
		//SQLの発行
		conn = DriverManager.getConnection(url, id, pass);


		String query = "select * from product where pro_name like ? ";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, "%" + key + "%");
		rs=pstmt.executeQuery();

		while(rs.next()) {


			pb.setPro_cd(rs.getInt("pro_cd"));
			pb.setPro_name(rs.getString("pro_name"));
			pb.setStock_no(rs.getInt("stock_no"));
			pb.setPro_price(rs.getInt("pro_price"));
			pb.setCat_id(rs.getInt("cat_id"));
			pb.setPro_img(rs.getString("pro_img"));
			pb.setPro_msg(rs.getString("pro_msg"));

			apb.add(pb);
		}


	} catch (SQLException ex) {
		ex.printStackTrace();
	} finally {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception ex) {
		}

	}return apb;
}




}
	public ArrayList<ProductBean> kensaku(int cat_id){
		String url = "jdbc:mysql://localhost/ecsite";
		String id = "root";
		String pass = "password";
		Connection conn = null;
		PreparedStatement pstmt = null;

		ArrayList<ProductBean> apb =new ArrayList<ProductBean>();

		ResultSet rs = null;

		{
		//JDBcドライバの登録
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		//データベースへの接続
		try {
			//SQLの発行
			conn = DriverManager.getConnection(url, id, pass);


			String query = "select * from product where cat_id like ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,  cat_id );
			rs=pstmt.executeQuery();

			while(rs.next()) {
				ProductBean pb = new ProductBean();

				pb.setPro_cd(rs.getInt("pro_cd"));
				pb.setPro_name(rs.getString("pro_name"));
				pb.setStock_no(rs.getInt("stock_no"));
				pb.setPro_price(rs.getInt("pro_price"));
				pb.setCat_id(rs.getInt("cat_id"));
				pb.setPro_img(rs.getString("pro_img"));
				pb.setPro_msg(rs.getString("pro_msg"));

				apb.add(pb);
			}


		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
			}

		}return apb;
	}




	}

	public ArrayList<ProductBean> kensaku(String key,int cat_id){
		String url = "jdbc:mysql://localhost/ecsite";
		String id = "root";
		String pass = "password";
		Connection conn = null;
		PreparedStatement pstmt = null;

		ArrayList<ProductBean> apb =new ArrayList<ProductBean>();

		ResultSet rs = null;

		{
		//JDBcドライバの登録
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		//データベースへの接続
		try {
			//SQLの発行
			conn = DriverManager.getConnection(url, id, pass);


			String query = "select * from product where cat_id like ? and pro_name like ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cat_id);
			pstmt.setString(2,"%" + key + "%");

			rs=pstmt.executeQuery();

			while(rs.next()) {
				ProductBean pb = new ProductBean();

				pb.setPro_cd(rs.getInt("pro_cd"));
				pb.setPro_name(rs.getString("pro_name"));
				pb.setStock_no(rs.getInt("stock_no"));
				pb.setPro_price(rs.getInt("pro_price"));
				pb.setCat_id(rs.getInt("cat_id"));
				pb.setPro_img(rs.getString("pro_img"));
				pb.setPro_msg(rs.getString("pro_msg"));

				apb.add(pb);
			}


		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
			}

		}return apb;
	}




	}
	public ProductBean product(String key){
		String url = "jdbc:mysql://localhost/ecsite";
		String id = "root";
		String pass = "password";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ProductBean pb = new ProductBean();


		ResultSet rs = null;

		{
		//JDBcドライバの登録
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		//データベースへの接続
		try {
			//SQLの発行
			conn = DriverManager.getConnection(url, id, pass);


			String query = "select * from product where pro_name like ? ";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + key + "%");
			rs=pstmt.executeQuery();

			while(rs.next()) {


				pb.setPro_cd(rs.getInt("pro_cd"));
				pb.setPro_name(rs.getString("pro_name"));
				pb.setStock_no(rs.getInt("stock_no"));
				pb.setPro_price(rs.getInt("pro_price"));
				pb.setCat_id(rs.getInt("cat_id"));
				pb.setPro_img(rs.getString("pro_img"));
				pb.setPro_msg(rs.getString("pro_msg"));


			}


		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
			}

		}return pb;
	}




	}
	public void update(int a,int b){
		String url = "jdbc:mysql://localhost/ecsite";
		String id = "root";
		String pass = "password";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ProductBean pb = new ProductBean();



		ResultSet rs = null;

		{
		//JDBcドライバの登録
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		//データベースへの接続
		try {
			//SQLの発行
			conn = DriverManager.getConnection(url, id, pass);


			String query = "update product set stock_no=? where pro_cd=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, a);
			pstmt.setInt(2, b);

			int t=pstmt.executeUpdate();




		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
			}

		}return ;
	}




	}
	public ProductBean product(int a){
		String url = "jdbc:mysql://localhost/ecsite";
		String id = "root";
		String pass = "password";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ProductBean pb = new ProductBean();



		ResultSet rs = null;

		{
		//JDBcドライバの登録
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		//データベースへの接続
		try {
			//SQLの発行
			conn = DriverManager.getConnection(url, id, pass);


			String query = "select * from product where pro_cd = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, a);
			rs=pstmt.executeQuery();

			rs.next();

			pb.setPro_cd(rs.getInt("pro_cd"));
			pb.setPro_name(rs.getString("pro_name"));
			pb.setStock_no(rs.getInt("stock_no"));
			pb.setPro_price(rs.getInt("pro_price"));
			pb.setCat_id(rs.getInt("cat_id"));
			pb.setPro_img(rs.getString("pro_img"));
			pb.setPro_msg(rs.getString("pro_msg"));





		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
			}

		}return pb;
	}

	}

}
