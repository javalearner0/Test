package com.fxy.employee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fxy.employee.bean.Applicant;
import com.fxy.employee.dao.ApplicationDao;

@WebServlet("/ApplicantLoginServlet")
public class ApplicantLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ApplicantLoginServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");//��ȡ��¼���������email��
		String passwd = request.getParameter("password");//��ȡ��¼���������password��
		
		ApplicationDao dao = new ApplicationDao();
		int applicant_id = dao.login(email, passwd);
		if(applicant_id != 0) {
			Applicant applicant = new Applicant(applicant_id,email,passwd);
			request.getSession().setAttribute("SESSION_APPLICANT", applicant);
			//�ж������Email�Ƿ���ȷ��
			int resumeID = dao.isExitResume(applicant_id);
			if(resumeID != 0) {
				request.getSession().setAttribute("SESSION_RESUMEID", resumeID);
				//�ж��Ƿ��м�����
				response.sendRedirect("index.jsp");
			}else {
				response.sendRedirect("applicant/resumeGuide.html");
			}
		}else {
			//�û�����email����alert��ʾ����
			out.print("<script type='text/javascript'>");
			out.print("alert('�û������������');");
			out.print("window.location='login.html';");
			out.print("</script>");
		}
	}

}
