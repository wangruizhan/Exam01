package com.hand.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Select {

	public static void main(String[] args) {
		System.out.println("请输入Country ID:");
		Scanner  sn = new Scanner(System.in);
		int i = sn.nextInt();
		
		
		
		String sql = "select city_id,city from city where country_id='"+i+"'";
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","123456");
			
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			System.out.println("输出：");
			while(rs.next()){
				System.out.println("城市ID  城市名称");
				System.out.print(rs.getInt("city_id")+" ");
				System.out.println(rs.getString("city")+" ");
				
				System.out.println();
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			try {
				rs.close();
			} catch (Exception e2) {
				
			}
			try {
				st.close();
			} catch (Exception e2) {
				
			}
			try {
				conn.close();
			} catch (Exception e2) {
				
			}
		}
		
		
		
	}
	

}
