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
				System.out.println("���ݿⴴ��ʧ��");
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
	
	//�����ݿ��������ѵ�¼���û������ArrayList����
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
