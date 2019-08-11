package shuun.chapte9.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Session的实现需要借助Cookie
 * Cookie中保存的时Session Id
 * @author bing5
 *
 */
public class SessionDemo1 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		HttpSession session = req.getSession();
		session.setAttribute("name", "zxb");
		Cookie cookie = new Cookie("JSESSIONID", session.getId());
		cookie.setMaxAge(3600);
		resp.addCookie(cookie);
		
		//String sessionId = session.getId();
//		if (session.isNew()) {
//			resp.getWriter().print("session创建成功，session的id是："+sessionId);
//		} else {
//			resp.getWriter().print("服务器已经存在该session了，session的id是："+sessionId);
//		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
}
