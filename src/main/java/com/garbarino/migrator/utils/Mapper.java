package com.garbarino.migrator.utils;

import org.codehaus.jackson.map.ObjectMapper;

import com.garbarino.migrator.type.ObservedType;

public class Mapper{

	public static Mapper instance = new Mapper();
	public java.util.Properties prop =new java.util.Properties();
	
    private Mapper(){
    	
    	
   }
    
	public static Mapper getInstance(){
   	 return instance;
    }
	public String parse(ObservedType type) throws Exception{
		
		ObjectMapper mapper = new ObjectMapper();
	    String value = "";
		try {
	       
			value=mapper.writeValueAsString(type);
			
		}catch(Exception ex){
			
		}
		return value;
	}
	 
}
