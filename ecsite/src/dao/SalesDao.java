package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.CartBean;
import model.UserBean;

public class SalesDao {

	public void sales(UserBean ui,ArrayList<CartBean> cart,Connection conn) {

		PreparedStatement pstmt = null;
		UserBean ub=ui;
		int uid =ui.getId();
		CartBean cb =new CartBean();
		int pro_cd =0;
		int total =0;



		ResultSet rs = null;

		{
		//JDBcドライバの登録

		//データベースへの接続
		try {
			//SQLの発行


			for(int i=0;i<cart.size();i++) {
				cb=cart.get(i);

				pro_cd=cb.getPro_cd();
				total =cb.getPro_price()*cb.getStock_no();


			String query = "insert into sales values(null,?,?,now(),?) ";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, uid);
			pstmt.setInt(2, pro_cd);
			pstmt.setInt(3, total);

			int sales=pstmt.executeUpdate();

			}




		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception ex) {
			}

		}return ;
	}
	}
}
