package rin.calculate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletCalculate extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>welcome to understand the メカニズム of GetMethod</title></head>");
		out.print("<body><h1>↓↓↓the information is 下記通り↓↓↓<h1><hr>");
		out.print("Scheme:"+request.getScheme());
		out.print("Host_addr:"+request.getRemoteAddr());
		out.print("Host_host:"+request.getRemoteHost());
		out.print("URL:"+request.getRequestURI());
		out.print("Method:"+request.getMethod());
		out.print("Querystring:"+request.getQueryString());
		out.print("</body></html>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
//		 name="submit"
//		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String welcomeName = "林の";
		String exp = request.getParameter("expression");
		
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>welcome"+welcomeName+"四則演算</title></head>");
		out.print("<body>");
		out.print("<form name=\"calculateForm\" action=\"/docalculate\" method=\"get\">");
		out.print(exp+"="+RunCalculate.doExcute(exp));
		out.print("<input type=\"submit\" name=\"submit\" value=\"計算\">");
		out.print("</form>");
		out.print("</body></html>");
	}
}
