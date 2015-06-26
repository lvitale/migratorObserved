package com.garbarino.migrator.service;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.garbarino.migrator.utils.PropertiesUtil;


public class RestService {
	
	     public static RestService instance = new RestService();
	     private PropertiesUtil property = PropertiesUtil.getInstance();
	     
	     private RestService(){
	    	 
	    }
	     public static RestService getInstance(){
	    	 return instance;
	     }
		public void call(String json){
		 HttpResponse response;
		
	try{
		
		HttpClient httpclient= new DefaultHttpClient();
        HttpPost httppost= new HttpPost (getUlrService());
        StringEntity se=new StringEntity (json);
        httppost.setEntity(se);
        System.out.print(se);
        httppost.setHeader("Accept", "application/json");
        httppost.setHeader("Content-type", "application/json");
        httppost.setHeader(getTokenName(), getTokenValue());
        
        response=httpclient.execute(httppost);
        System.out.println(response);
		}catch(Exception ex){
			System.err.println(ex);
		}finally{
			
		}
		
	}
	
	private String getUlrService(){
		StringBuffer url = new StringBuffer();
		//url.append(property.getPropertie("genesis.service.observed.url"));
		//url.append(property.getPropertie("genesis.service.observed.report"));
		url.append("http://localhost:8080/services/observation/report/observed");
		return url.toString();
	}
	private String getTokenValue(){
		return "N+/PktM9hy9n9OOqRY4Nz6ffZdHwcQLLAiCxd5bF/pk=";
		//return property.getPropertie("genesis.service.nebserved.token.value");
	}
	private String getTokenName(){
		return "X-Tek-App-Token";
		//return property.getPropertie("genesis.service.observed.token.name");
	}
		
}
