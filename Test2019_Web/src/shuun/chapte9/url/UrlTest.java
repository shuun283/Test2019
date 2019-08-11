package shuun.chapte9.url;

import java.io.IOException;
import java.net.URI;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * URL和URI的区别
 * Class URL represents a Uniform Resource Locator, 
 * a pointer to a "resource" on the World Wide Web. 
 * A resource can be something as simple as a file or a directory, 
 * or it can be a reference to a more complicated object, 
 * such as a query to a database or to a search engine. 
 * More information on the types of URLs and their formats can be found at: Types of URL 
 *
 *URI
 *[scheme:]scheme-specific-part[#fragment] 
 *
 *URL统一资源定位符，协议，主机，具体地址
 *URI是以某种统一的方式标识资源的简单字符串
 *名称空间:空间特定部分
 *[scheme:] scheme-specific-part
 *比如说Http：// www.baidu.com
 *       mailto:xxx@xxx.xx、
 *       news:aaaa
 *       
 * 第一个理解的地方
 * 资源的含义，文件时一个资源，所以可以创建IO流
 * 标识的含义，一个邮箱地址，相当于一个门牌号，是一个定位。
 *       
 * URI有绝对和相对之分，类比就是绝对路径和相对路径
 * 
 *注意标识和协议的一个区别
 *
 */
public class UrlTest extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		URL url = null;
		URI uri = null;
		// /Demo1/UrlTest
		System.out.println(req.getRequestURI());
		// http://localhost:8080/Demo1/UrlTest
		System.out.println(req.getRequestURL());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
