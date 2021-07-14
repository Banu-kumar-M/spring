package com.example.demo.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class connection {
	
	public void update(int eid, String date, String radio )
	{
		String url ="jdbc:mysql://localhost:3306/spri";
		String uname = "root";
		String pass = "Kannada123";
		
		String sql = "update spri.attendance set status = "+ "'" +radio + "'" + " where eid= " + eid + " and date =" + "'" + date + "'"+";";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,uname,pass);
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		
		public void updateSalary(int eid, int salary )
		{
			String url ="jdbc:mysql://localhost:3306/spri";
			String uname = "root";
			String pass = "Kannada123";
			
			String sql = "update spri.emp set sal = "+ salary  + " where eid= " + eid +";";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,uname,pass);
				Statement st = con.createStatement();
				st.executeUpdate(sql);
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
