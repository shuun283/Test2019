package shuun.chapte9.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextDemo4  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String data = "<h1><font color='red'>abcdefghigk</font></h1>";
		// 这个和PrintWriter的区别在于一个是字节的一个是字符的
		resp.getOutputStream().write(data.getBytes());
		ServletContext context = this.getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/ServletContextDemo5");
		//forward方法和之前的300的重定向的区别
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

}
