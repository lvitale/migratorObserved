package com.garbarino.migrator.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertiesUtil {

	public static PropertiesUtil instance = new PropertiesUtil();
	public java.util.Properties prop =new java.util.Properties();
	
    private PropertiesUtil(){
    	//changeFile("profile-migrator-desa.properties");
    	
   }
    
	public static PropertiesUtil getInstance(){
   	 return instance;
    }
    
    public String getPropertie(String key){
    	String value = prop.getProperty(key);
    	return value;
    }
    
    public void changeFile(String name){
    	try{
    		prop = new Properties();
    		InputStream in =getClass().getClassLoader().getResourceAsStream(name);
    		prop.load(in);
    		in.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
    	
    }
	
}
