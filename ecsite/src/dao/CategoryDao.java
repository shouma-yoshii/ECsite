package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.CategoryBean;

public class CategoryDao {

	public ArrayList<CategoryBean> Category() {
		String url = "jdbc:mysql://localhost/ecsite";
		String id = "root";
		String pass = "password";
		Connection conn = null;
		PreparedStatement pstmt = null;

		ArrayList<CategoryBean> acb =new ArrayList<CategoryBean>();

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

			String query = "select * from category";
			pstmt = conn.prepareStatement(query);
			rs=pstmt.executeQuery();

			while(rs.next()) {
				CategoryBean cb = new CategoryBean();

				cb.setCat_id(rs.getInt("cat_id"));
				cb.setCat_name(rs.getString("cat_name"));

				acb.add(cb);
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
		}return acb;







		}
	}
	public CategoryBean Category(int Cat_id) {
		String url = "jdbc:mysql://localhost/ecsite";
		String id = "root";
		String pass = "password";
		Connection conn = null;
		PreparedStatement pstmt = null;

		CategoryBean cb = new CategoryBean();


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

			String query = "select * from category where cat_id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Cat_id);

			rs=pstmt.executeQuery();

			while(rs.next()) {

				cb.setCat_id(rs.getInt("cat_id"));
				cb.setCat_name(rs.getString("cat_name"));

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
		}return cb;




		}


		}

	}
