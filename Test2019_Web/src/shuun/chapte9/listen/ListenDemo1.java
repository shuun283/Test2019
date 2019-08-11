package shuun.chapte9.listen;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ListenDemo1 implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("context start");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("context over!");
	}
}
