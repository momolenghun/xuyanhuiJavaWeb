package com.xu.listener;

import java.io.IOException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import com.xu.object.LDBoperate;

public class JavawebServletContextListener implements ServletContextListener {

	private static  LDBoperate abc;
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		try {
			abc.destroy();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
   
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		 abc=new LDBoperate();
		try {
			abc.create();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static LDBoperate getLdbInstance(){
		return abc;
	}

}
