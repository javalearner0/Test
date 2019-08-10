package com.fxy.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.fxy.employee.bean.ResumeBasicinfo;
import com.fxy.employee.util.DBUtil;

public class ResumeDao {
	public int add(ResumeBasicinfo basicinfo,int applicant_id) {
		int basicinfo_id = 0;
		DBUtil.getDriver();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "insert into tb_resume_basicinfo (realname,gender,birthday,current_loc,resident_loc,telephone,email,job_intension,job_experience,head_shot,applicant_id) values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.setString(1, basicinfo.getRealName());
			ps.setString(2, basicinfo.getGender());
			ps.setTimestamp(3, basicinfo.getBirthday() == null ? null:new Timestamp(basicinfo.getBirthday().getTime()));
			ps.setString(4, basicinfo.getCurrentLoc());
			ps.setString(5, basicinfo.getResidentLoc());
			ps.setString(6, basicinfo.getTelephone());
			ps.setString(7, basicinfo.getEmail());
			ps.setString(8, basicinfo.getJobIntension());
			ps.setString(9, basicinfo.getJobExperience());
			ps.setString(10, basicinfo.getHeadshot());
			ps.setInt(11, applicant_id);
			ps.executeUpdate();
			String sql1 = "select basicinfo_id from tb_resume_basicinfo where applicant_id=?";
			ps = conn.prepareStatement(sql1);
			ps.setInt(1, applicant_id);
			rs = ps.executeQuery();
			if(rs.next()) {
				basicinfo_id = rs.getInt(1);
				conn.commit();
			}
		}catch(SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, ps, conn);
		}
		return basicinfo_id;
	}
	public void updateHeadShot(int basicinfo_id,String newFileName) {
		String sql = "update tb_resume_basicinfo set head_shot = ? where basicinfo_id = ?";
		DBUtil.getDriver();
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps  = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, newFileName);
			ps.setInt(2, basicinfo_id);
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null, ps, conn);
		}
	}
}
