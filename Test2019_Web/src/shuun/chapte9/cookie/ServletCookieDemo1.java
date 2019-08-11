package shuun.chapte9.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie信息和站点相关，浏览器保存的Cookie的内存大小的数量有限。
 * 默认的cookie生命周期会话级别的，maxAge方法以秒为单位的，
 * 将最大的实现设置为0，则命令浏览器删除cookie。
 * 
 * Cookie中保存的数据会通过response返回给浏览器，下次访问会带回给服务器
 * Cookie(String name, String value) 构造方法，cookie名称和值
 * getName()
 * getValue()
 * setValue(String newValue)
 * setMaxAge(int expiry) 设置有效期，默认有效期是一次会话，但是可以设置有效事件
 * getMaxAge() 获取有效期
 * getPath() 获取cookie的有效路径
 * setDomain()
 * 
 * URLEncoder.encode(""),URLDecoder.decode(, charset)
 *  *
 */
public class ServletCookieDemo1 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			out.println("您上次访问的时间是：");
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				if (cookie.getName().equals("lastAccessTime")) {
					Long lastAccessTime = Long.parseLong(cookie.getValue());
					Date date = new Date(lastAccessTime);
					out.write(date.toLocaleString());
				}
			}
		} else {
			out.write("这是你第一次访问本站！");
		}
		
		Cookie cookie = new Cookie("lastAccessTime", System.currentTimeMillis() + "");
		cookie.setMaxAge(24*60*60);
		resp.addCookie(cookie);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
