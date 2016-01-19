package com.xu.object;

import org.iq80.leveldb.*;

import static org.iq80.leveldb.impl.Iq80DBFactory.*;

import java.io.*;
import java.util.ArrayList;
import java.io.IOException;

public class LDBoperate {
	private  DB db;
	
	public LDBoperate(){
		
	}
	
	
	public void create() throws IOException{
			
		try{
			Options options = new Options();
			options.createIfMissing(true);
			db = factory.open(new File("f:/data/leveldb"), options);
				
		}catch(IOException ex){
				System.out.println("数据库创建失败");
		}
			
	}	
	
	public void destroy()throws IOException{
		try{
			db.close();
		}
		catch(IOException ex){
							
		}
	}	
	
	public void put(String key,String value){
		
		db.put(bytes(key), bytes(value));
		
	}
	
	//从数据库中搜索已登录的用户，存进ArrayList对象
	public ArrayList LogonGuest(Guest guest1) throws IOException
	{
		ArrayList a=new ArrayList();
		DBIterator iterator = db.iterator();
		try{
		for(iterator.seekToFirst();iterator.hasNext();iterator.next())
		{
			Guest guest=new Guest();
			guest.setName(asString(iterator.peekNext().getValue()));
			guest.setTime(asString(iterator.peekNext().getKey()));
			a.add(guest);
			
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		db.put(bytes(guest1.getTime()), bytes(guest1.getName()));
		return a;

		}
	
}
