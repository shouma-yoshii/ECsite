package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.UserBean;

public class UserDao {

	public UserBean login(String name, String pw) {
		String url = "jdbc:mysql://localhost/ecsite";
		String id = "root";
		String pass = "password";
		Connection conn = null;
		PreparedStatement pstmt = null;
		UserBean ub = new UserBean();

		ResultSet rs = null;

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

			String query = "select * from user where login_cd = ? and login_pw=? ";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, pw);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				ub.setId(rs.getInt("user_id"));
				ub.setName(rs.getString("login_cd"));
				ub.setPass(rs.getString("login_pw"));
				System.out.println("ユーザー情報セッツ");
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
		}
		return ub;
	}
}
