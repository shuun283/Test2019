package shuun.chapte9.listen;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 允许多个，按照定义顺序调用
 *
 */
public class ListenDemo2 implements ServletContextListener  {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("context2 start");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("context2 over!");
	}

}
