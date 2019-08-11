package shuun.chapte9.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo2 extends HttpServlet implements SingleThreadModel{

	private static final long serialVersionUID = 2885093270846992329L;

	int i = 1;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		i++;
		try {
			Thread.sleep(1000*4);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		response.getWriter().write("i : " + i);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
