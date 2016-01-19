package com.xu.object;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Guest {
	private String name;
	private String time;
	
	public Guest(){
	
	}
	public Guest(String name,String time)
	{
		this.name=name;
		this.time=time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public void setTime(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		this.time=dateFormat.format( new Date());
	
	}	
}
  

		
