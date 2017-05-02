package com.zzim.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
		  
		  private static Connection conn = null;
		  
		  public static Connection getConnection(){
			  if(conn == null){
				  try {
					  Class.forName("com.mysql.jdbc.Driver"); //드라이버 로딩: DriverManager에 등록
				  }catch(ClassNotFoundException e) {
					  System.err.print("ClassNotFoundException: ");
				  }
				  
				  try {
					   String jdbcUrl = "jdbc:mysql://localhost:3306/cokcok";//사용하는 데이터베이스명을 포함한 url
					   String userId = "root";    //사용자 계정
					   String userPass = "1234";  //사용자 패스워드
					   
					   conn = DriverManager.getConnection(jdbcUrl, userId, userPass);//Connection 객체를 얻어냄

				  }catch(SQLException e) {
					  System.out.println("SQLException: " + e.getMessage());
				  } 
			  }
			  
			  return conn;
		  }
		  
		  public static void disconnect(){
			  if(conn != null){
				  try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  }
		  }
		 }
