package com.fxy.employee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fxy.employee.dao.ApplicationDao;

/**
 * Servlet implementation class ApplicationRegistServlet
 */
@WebServlet("/ApplicationRegistServlet")
public class ApplicationRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicationRegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String verifyCode = request.getParameter("verifyCode");
		
		String sessionValidateCode = (String)request.getSession().getAttribute("SESSION_VALIDATECODE");
		if(!verifyCode.equals(sessionValidateCode)) {
			out.print("<script text='text/javascript'>");
			out.print("alert('请输入正确的验证码');");
			out.print("window.location='register.html';");
			out.print("</script>");
		}else {
			ApplicationDao dao = new ApplicationDao();
			boolean flag = dao.isExistEmail(email);
			if(flag) {
				out.print("<script type='text/javascript'>");
				out.print("alert('邮箱已被注册，请重新注册！');");
				out.print("window.location = 'register.html';");
				out.print("</script>");
			}else {
				dao.save(email, password);
				response.sendRedirect("login.html");
			}
		}
	}
}
