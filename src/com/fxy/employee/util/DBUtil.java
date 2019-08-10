package com.fxy.employee.util;

import java.sql.*;

/** 数据库连接获取和释放工具类
 * @author 方星宇
 *
 */
public class DBUtil {
		//实例化赋值数据库变量
		static String user = "root";
		static String passwd = "123456";
		static String url = "jdbc:mysql://localhost:3306/employee?useSSL=false&serverTimezone=UTC";
		static String driver = "com.mysql.cj.jdbc.Driver";
		
		//数据库加载驱动，每次该类被实例化，静态代码块会被调用一次
		public static void getDriver() {
			try {
				Class.forName(driver);
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		//获取数据库的连接
		public static Connection getConnection() {
			Connection conn = null;
			try {
				conn = DriverManager.getConnection(url,user,passwd);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		}
		
		//关闭数据库连接对象
		public static void close(ResultSet rs,Statement stet,Connection conn) {
			if(null != rs) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(null != stet) {
				try {
					stet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(null != conn) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
