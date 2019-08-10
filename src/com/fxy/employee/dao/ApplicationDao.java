package com.fxy.employee.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.fxy.employee.util.DBUtil;


/**��֤�����Ƿ�ע������������䵽���ݿ⣻
 * @author ������
 *
 */
public class ApplicationDao {
	
	public boolean isExistEmail(String email) {
		DBUtil.getDriver();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from tb_applicant where applicant_email = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if(rs.next())
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, ps, conn);
		}
		return false;
	}
	public void save(String email,String password) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		String sql = "insert into tb_applicant(applicant_email,applicant_pwd,applicant_registdate) values(?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ps.setTimestamp(3, new Timestamp(new Date().getTime()));
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(null,ps, conn);
		}
	}
	//�жϵ�¼�Ƿ�ɹ�
	public int login(String email,String passwd) {
		int applicant_id = 0;
		DBUtil.getDriver();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps =null;
		ResultSet rs = null;
		String sql = "select applicant_id from tb_applicant where applicant_email =? and applicant_pwd =?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, passwd);
			rs = ps.executeQuery();
			if(rs.next()) {
				applicant_id = rs.getInt("applicant_id");
			}
		}catch(SQLException e){
			e.printStackTrace();
		 }finally {
			 DBUtil.close(rs, ps, conn);
		}
		return applicant_id;
	}
	//�ж��Ƿ���д���������������ݿ��ѯbasicinfo_id���жϼ����Ƿ���ڡ�
	public int isExitResume(int applicant_id) {
		int resumeID = 0;
		DBUtil.getDriver();
		Connection  conn = DBUtil.getConnection();
		PreparedStatement ps =null;
		ResultSet rs = null;
		
		String sql = "select basicinfo_id from tb_resume_basicinfo where applicant_id=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, applicant_id);
			rs = ps.executeQuery();
			if(rs.next()) {
				resumeID = rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, ps, conn);
		}
		return resumeID;
	}
}
