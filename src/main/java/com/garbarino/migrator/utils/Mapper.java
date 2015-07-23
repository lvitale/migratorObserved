package com.garbarino.migrator.utils;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.garbarino.migrator.type.ObservedType;
import com.garbarino.migrator.type.ResulSet;
import com.garbarino.migrator.type.ResultId;

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
	
public String parseTo(Object type) throws Exception{
		
		ObjectMapper mapper = new ObjectMapper();
	    String value = "";
		try {
	       
			value=mapper.writeValueAsString(type);
			
			
		}catch(Exception ex){
			
		}
		return value;
	}

public ResultId mapperToResultset(String json){
	ResultId rs = new ResultId();
	ObjectMapper mapper = new ObjectMapper();
	 
	try {
 
		// read from file, convert it to user class
		rs= mapper.readValue(json, ResultId.class);
 
	
 
	} catch (JsonGenerationException e) {
 
		e.printStackTrace();
 
	} catch (JsonMappingException e) {
 
		e.printStackTrace();
 
	} catch (IOException e) {
 
		e.printStackTrace();
 
	}
	return rs;
}
	 
}
