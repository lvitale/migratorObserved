package com.garbarino.migrator.service;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;

import com.garbarino.migrator.enums.ServiceName;
import com.garbarino.migrator.enums.State;
import com.garbarino.migrator.type.ResulSet;
import com.garbarino.migrator.type.ResultId;
import com.garbarino.migrator.utils.Mapper;
import com.garbarino.migrator.utils.PropertiesUtil;


public class RestService {
	
	     public static RestService instance = new RestService();
	     private PropertiesUtil property = PropertiesUtil.getInstance();
	     private static final int STATUS_FAIL = 500;
	     private static Integer key = 1;
	     Map<Integer,String> message = null;
	     private List<ResulSet> results= new ArrayList<ResulSet>();
	     ResulSet result =null; 
	     private Integer id=0;
	     private ServiceName serviceName = ServiceName.OBSERVED_REPORT;
	     
	     
	     private RestService(){
	    	 message = new HashMap<Integer, String>();
	     }
	     // Pattern singleton
	     public static RestService getInstance(){
	    	 return instance;
	     }
	    
		public void call(String json){
		 HttpResponse response;
		 result = new ResulSet();
		 result.setId(getId());
		 
		 try{
		
			 HttpClient httpclient= new DefaultHttpClient();
		
			 HttpPost httppost= new HttpPost (getUlrService());
			 StringEntity se=new StringEntity (json,"UTF-8");
			 se.setContentType("application/json;charset=UTF-8");
        
			 httppost.setEntity(se);
        
			 httppost.setHeader("Accept", "application/json");
			 httppost.setHeader("Content-type", "application/json;charset=UTF-8");
			 httppost.setHeader(getTokenName(), getTokenValue());
        
			 response=httpclient.execute(httppost);
       
			 result.setResponse(response.getEntity().getContent().toString());
			 String resp =  EntityUtils.toString(response.getEntity()); 		
			 Map datos = new ObjectMapper().readValue(resp, Map.class);
		
			 // Se establecio correctamente la comunicacion con el servicio
			 if(response.getStatusLine().getStatusCode() == 200 && "OK".equals(datos.get("status"))){
				 result.setState(State.OK);
			 }else{	   
				 result.setState(State.ERROR);
			 }
       
		 }catch(Exception e){
			System.err.append(e.getMessage());
			result.setMessage(e.getMessage());
			result.setState(State.ERROR);
		 }finally{
			
		}
		 results.add(result);
	}
	public Integer callServ(String json){
		HttpResponse response;
		ResultId res = null;
		
		try{
			
			 HttpClient httpclient= new DefaultHttpClient();
		
			 HttpPost httppost= new HttpPost (getUlrService());
			 StringEntity se=new StringEntity (json,"UTF-8");
			 se.setContentType("application/json;charset=UTF-8");
       
			 httppost.setEntity(se);
       
			 httppost.setHeader("Accept", "application/json");
			 httppost.setHeader("Content-type", "application/json;charset=UTF-8");
			 httppost.setHeader(getTokenName(), getTokenValue());
       
			 response=httpclient.execute(httppost);
			 String resp =  EntityUtils.toString(response.getEntity());
			 res = Mapper.getInstance().mapperToResultset(resp);
			 
		}catch(Exception e){
			System.err.append(e.getMessage());
		}
		return res.getId();
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
	
	public void clean(){
		results = new ArrayList<ResulSet>();
	}
	
	private String getUlrService(){
		StringBuffer url = new StringBuffer();
		url.append(property.getPropertie("genesis.service.observed.url"));
		if(ServiceName.OBSERVED_REPORT.equals(serviceName)){
			url.append(property.getPropertie("genesis.service.observed.report"));
		}if(ServiceName.CARD_REPORT.equals(serviceName)){
			url.append(property.getPropertie("genesis.service.card.report"));
		}if(ServiceName.IP_REṔORT.equals(serviceName)){
			url.append(property.getPropertie("genesis.service.ip.report"));
		}if(ServiceName.PERSON_REPORT.equals(serviceName)){
			url.append(property.getPropertie("genesis.service.person.report"));
		}if(ServiceName.ADDRESS_REPORT.equals(serviceName)){
			url.append(property.getPropertie("genesis.service.address.report"));
		}
		if(ServiceName.CITY_ID_SEARCH.equals(serviceName)){
			url.append(property.getPropertie("genesis.service.cityId.search"));
		}
		if(ServiceName.CARD_ID_SEARCH.equals(serviceName)){
			url.append(property.getPropertie("genesis.service.cardId.search"));
		}
		if(ServiceName.OBSERVED_CHECK.equals(serviceName)){
			url.append(property.getPropertie("genesis.service.observed.check"));
		}if(ServiceName.CARD_CHECK.equals(serviceName)){
			url.append(property.getPropertie("genesis.service.card.check"));
		}if(ServiceName.IP_CHECK.equals(serviceName)){
			url.append(property.getPropertie("genesis.service.ip.check"));
		}if(ServiceName.PERSON_CHECK.equals(serviceName)){
			url.append(property.getPropertie("genesis.service.person.check"));
		}if(ServiceName.ADDRESS_CHECK.equals(serviceName)){
			url.append(property.getPropertie("genesis.service.address.check"));
		}
		return url.toString();
	}
	private String getTokenValue(){
		return property.getPropertie("genesis.service.nebserved.token.value");
	}
	private String getTokenName(){
		return property.getPropertie("genesis.service.observed.token.name");
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ServiceName getServiceName() {
		return serviceName;
	}
	public void setServiceName(ServiceName serviceName) {
		this.serviceName = serviceName;
	}
	public ResulSet getResult() {
		return result;
	}
	public void setResult(ResulSet result) {
		this.result = result;
	}
	public List<ResulSet> getResults() {
		return results;
	}
	public void setResults(List<ResulSet> results) {
		this.results = results;
	}
		
}
