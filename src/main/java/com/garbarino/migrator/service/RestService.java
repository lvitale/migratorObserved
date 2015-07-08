package com.garbarino.migrator.service;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.garbarino.migrator.utils.PropertiesUtil;


public class RestService {
	
	     public static RestService instance = new RestService();
	     private PropertiesUtil property = PropertiesUtil.getInstance();
	     private static final int STATUS_FAIL = 500;
	     private static Integer key = 1;
	     Map<Integer,String> message = null;
	     
	     private RestService(){
	    	 message = new HashMap<Integer, String>();
	    }
	     public static RestService getInstance(){
	    	 return instance;
	     }
		public void call(String json){
		 HttpResponse response;
		
	try{
		
		HttpClient httpclient= new DefaultHttpClient();
		
        HttpPost httppost= new HttpPost (getUlrService());
        StringEntity se=new StringEntity (json,"UTF-8");
        se.setContentType("application/json;charset=UTF-8");
        
        httppost.setEntity(se);
        
        //System.out.println(se);
        httppost.setHeader("Accept", "application/json");
        httppost.setHeader("Content-type", "application/json;charset=UTF-8");
        httppost.setHeader(getTokenName(), getTokenValue());
        
        response=httpclient.execute(httppost);
       
       
        //System.out.println(response);
        //System.out.println(((response.getEntity().getContent())));
        //System.out.println("Response status" + response.getStatusLine().toString());
        
        //System.out.println(response.getStatusLine().getStatusCode());
       System.out.println("respuestas del servicio " + response );
       if(response.getStatusLine().getStatusCode() == 500){
    	   message.put(key, "false");
       }else{	   
		   String resp =  EntityUtils.toString(response.getEntity()); 		
		   Map datos = new ObjectMapper().readValue(resp, Map.class);
		   message.put(key, datos.get("status").toString());
       }
       key++;
       
           
       //EntityUtils.consume(response.getEntity());             
		}catch(Exception e){
			e.getMessage();
		}finally{
			
		}
	
		
	}
	public void grabarArchivo(){
		File file= new File("src/main/resources/archivo.out");
		FileWriter fw  = null;
		BufferedWriter bw = null;
		try{
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			Iterator it = message.keySet().iterator();
			while(it.hasNext()){
			  Integer key = (Integer) it.next();
			  bw.write(("numero registro: " + key + " -> mensage: " + message.get(key)));
			  bw.newLine();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
				try {
					if(bw != null)bw.close();
					if(fw != null)fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	private String getUlrService(){
		StringBuffer url = new StringBuffer();
		url.append(property.getPropertie("genesis.service.observed.url"));
		url.append(property.getPropertie("genesis.service.observed.report"));
		return url.toString();
	}
	private String getTokenValue(){
		return property.getPropertie("genesis.service.nebserved.token.value");
	}
	private String getTokenName(){
		return property.getPropertie("genesis.service.observed.token.name");
	}
		
}
