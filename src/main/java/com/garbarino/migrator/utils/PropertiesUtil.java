package com.garbarino.migrator.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertiesUtil {

	public static PropertiesUtil instance = new PropertiesUtil();
	public java.util.Properties prop =new java.util.Properties();
	
    private PropertiesUtil(){
    	try{
    		Properties prop = new Properties();
    		//InputStream in = getClass().getResourceAsStream("profile-migrator-desa.properties");
    		//InputStream in =getClass().getClassLoader().getResourceAsStream("src/main/resources/profile-migrator-desa.properties");
    		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
    		InputStream in = classloader.getResourceAsStream("profile-migrator-desa.properties");
    		
    		prop.load(in);
    		in.close();
		} catch (IOException ex) {
			System.out.println(ex.getCause());
		}
    	
   }
    
	public static PropertiesUtil getInstance(){
   	 return instance;
    }
    
    public String getPropertie(String key){
    	String value = prop.getProperty(key);
    	return value;
    }
	
}
