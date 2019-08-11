package shuun.chapte9.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionDemo2 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
//		HttpSession session = req.getSession();
//		session.setAttribute("name", "zxb");
//		String sessionId = session.getId();
//		System.out.println(sessionId);
		// req.getContextPath()获取到的时根目录
		//String url = resp.encodeRedirectURL(req.getContextPath() + "/sessionDemo1");
		String url1 = resp.encodeURL(req.getContextPath() + "/sessionDemo1");
		String url2 = resp.encodeURL(req.getContextPath() + "/sessionDemo3");
		PrintWriter out = resp.getWriter();

		out.write("<a href='" + url1 + "'> 购买</a>");
		out.write("<a href='" + url2 + "'> 结算</a>");
		// System.out.println(url);
		//resp.sendRedirect(url);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
}
