package shuun.chapte9.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo3  extends HttpServlet {
	private static final long serialVersionUID = 2885093270846992329L;

	//private ServletConfig config;
	
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		super.init();
//	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();
		ServletConfig config = this.getServletConfig();
		String paramVal = config.getInitParameter("name");
		writer.print(paramVal);
		
		writer.print("<hr/>");
		
		Enumeration<String> e = config.getInitParameterNames();
		while(e.hasMoreElements()) {
			String name = e.nextElement();
			String value = config.getInitParameter(name);
			writer.print(name + " : " + value + "<hr/>");
		}

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
