package com.garbarino.migrator.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.garbarino.migrator.utils.PropertiesUtil;

public class ConnectionDao {

	private Connection cn;
	private PropertiesUtil propertie = PropertiesUtil.getInstance();

	public void connect()throws Exception{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		cn = DriverManager.getConnection(getUrl(),getUser(),getPassword());
	}

	 public ResultSet executeQuery(String sql)throws Exception{
		 Statement stmt=cn.createStatement();  
		 ResultSet rs=stmt.executeQuery(sql);  
		 return rs;
	 }
	 
	 public void close()throws Exception{
		 cn.close();
	 }
	 private String getUrl(){
		  //return "jdbc:oracle:thin:@Srvorad2.garba.com.ar:1626:gartrde";
		 return propertie.getPropertie("dataSource.url");
	 }
	 private String getUser(){
		 //return "pickup";
		 return propertie.getPropertie("dataSource.username");
	 }
	 private String getPassword(){
		 //return "pickup_0000_desa";
		 return propertie.getPropertie("dataSource.password");
	 }
	  
	
}
