package model;

import java.util.Date;

public class SalesBean {
	int seles_id ;
	int user_id;
	int pro_cd ;
	Date ko_date= new Date();
	int sales_price;
	public int getSeles_id() {
		return seles_id;
	}
	public void setSeles_id(int seles_id) {
		this.seles_id = seles_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getPro_cd() {
		return pro_cd;
	}
	public void setPro_cd(int pro_cd) {
		this.pro_cd = pro_cd;
	}
	public Date getKo_date() {
		return ko_date;
	}
	public void setKo_date(Date ko_date) {
		this.ko_date = ko_date;
	}
	public int getSales_price() {
		return sales_price;
	}
	public void setSales_price(int sales_price) {
		this.sales_price = sales_price;
	}


}
