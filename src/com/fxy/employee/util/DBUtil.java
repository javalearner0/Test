package com.fxy.employee.util;

import java.sql.*;

/** ���ݿ����ӻ�ȡ���ͷŹ�����
 * @author ������
 *
 */
public class DBUtil {
		//ʵ������ֵ���ݿ����
		static String user = "root";
		static String passwd = "123456";
		static String url = "jdbc:mysql://localhost:3306/employee?useSSL=false&serverTimezone=UTC";
		static String driver = "com.mysql.cj.jdbc.Driver";
		
		//���ݿ����������ÿ�θ��౻ʵ��������̬�����ᱻ����һ��
		public static void getDriver() {
			try {
				Class.forName(driver);
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		//��ȡ���ݿ������
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
		
		//�ر����ݿ����Ӷ���
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
