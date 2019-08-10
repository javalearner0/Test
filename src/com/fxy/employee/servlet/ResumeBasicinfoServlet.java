package com.fxy.employee.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fxy.employee.bean.ResumeBasicinfo;
import com.fxy.employee.dao.ResumeDao;

@WebServlet("/ResumeBasicinfoServlet")
public class ResumeBasicinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ResumeBasicinfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String type = request.getParameter("type");
		if("add".equals(type)) {
			ResumeBasicinfo basicinfo = this.requestDataObj(request);
			ResumeDao dao = new ResumeDao();
			int basicinfo_id = dao.add(basicinfo, 6);
			response.sendRedirect("applicant/resume.html");
		}
	}
	private ResumeBasicinfo requestDataObj(HttpServletRequest request) {
		ResumeBasicinfo basicinfo = null;
		String realName = request.getParameter("realName");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		String currentLoc = request.getParameter("currentLoc");
		String residentLoc = request.getParameter("residentLoc");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		String jobIntension = request.getParameter("jobIntension");
		String jobExperience = request.getParameter("jobExperience");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthdayDate = null;
		try {
			birthdayDate = sdf.parse("birthday");
			
		}catch(ParseException e){
			birthdayDate = null;
		}
		basicinfo = new ResumeBasicinfo(realName,gender,birthdayDate,currentLoc,residentLoc,telephone,email,jobIntension,jobExperience);
		return basicinfo;
	}
}
