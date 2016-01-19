package com.xu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;





import com.xu.listener.JavawebServletContextListener;
import com.xu.object.*;

@Controller  
public class DisplayController {
	 
	@RequestMapping(value="display.do",method=RequestMethod.POST)    
	    public ModelAndView information_jsp(HttpServletRequest request) throws IOException{ 
			if(this.checkParams(request.getParameter("username"))){ 	
				Guest guest=new Guest();   
				guest.setName(request.getParameter("username"));
				guest.setTime();

				LDBoperate ldboperate=JavawebServletContextListener.getLdbInstance();
				
				Map<String ,Object> model=new HashMap<String,Object>();		
				ArrayList<Guest> L=ldboperate.LogonGuest(guest);
				model.put("AllGuest",L);
				model.put("CurrentGuest",guest);
				model.put("num",L.size());
				return new ModelAndView("display",model);
					
			}
			return (new ModelAndView("login")).addObject("welcome","Please write your name!");
	    }  
	 

		private boolean checkParams(String param){
			
				if(param==""||param==null||param.isEmpty()){
					return false;
				}
			
			return true;
		}

}
