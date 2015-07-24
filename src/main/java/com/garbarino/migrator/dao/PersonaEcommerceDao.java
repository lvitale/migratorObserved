package com.garbarino.migrator.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.garbarino.migrator.entity.RegistroEcommerce;

public class PersonaEcommerceDao {

ConnectionDao connection;
	
	public PersonaEcommerceDao(){
		connection = new ConnectionDao();
	}
	public List<RegistroEcommerce> find(Long cart,Integer company,Integer branch,Integer rows){
		List<RegistroEcommerce> listado = new ArrayList<RegistroEcommerce>();
		try{
		connection.connect();
		
		ResultSet rs=connection.executeQuery(getQuery(cart, company, branch, rows));
		
		while(rs.next()){
			RegistroEcommerce registro = new RegistroEcommerce();
			
			registro.setIdCarrito(rs.getLong("ID_CARRITO"));
			registro.setNombre(rs.getString("NOMBRE"));
			registro.setApellido(rs.getString("APELLIDO"));
			registro.setDocumento(rs.getLong("DOCUMENTO"));
			
			registro.setCalle(rs.getString("CALLE"));
			registro.setAltura(rs.getString("ALTURA"));
			registro.setPiso(rs.getString("PISO"));
			registro.setDepartamento(rs.getString("DEPARTAMENTO"));
			registro.setLocalidad(rs.getString("LOCALIDAD"));
			registro.setPartido(rs.getString("PARTIDO"));
			registro.setProvincia(rs.getString("PROVINCIA"));
			registro.setPais(rs.getString("PAIS"));
			
			registro.setCodPostal(rs.getString("CP"));
			registro.setTelefono(rs.getString("TELEFONO"));
			registro.setCelular(rs.getString("CELULAR"));
			
			registro.setMail(rs.getString("MAIL"));
			
			registro.setEmpresa(rs.getString("EMPRESA"));
			registro.setIp(rs.getString("IP"));
			registro.setBloqueado(rs.getString("BLOQUEADO"));
			
			registro.setFechaCarrito(rs.getDate("FECHA_CARRITO"));
			registro.setFechaRegistro(rs.getDate("FECHA_REGISTRO"));
			
			registro.setParty(rs.getLong("PARTY"));
			listado.add(registro);
			
		
		}
		connection.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}finally{
			
		}
		return listado;
       }
	
		private String getQuery(Long cart,Integer company,Integer branch,Integer rows){
			StringBuffer sql = new StringBuffer();
			sql.append(" SELECT * ");
			sql.append(" FROM PERSONAS_ECOMMERCE ");
			sql.append(" WHERE ");
			sql.append(" ROWNUM < "+ rows );
			sql.append(" AND ");
			sql.append(" ID_CARRITO = "+ cart );
			sql.append(" AND ");
			sql.append(" COD_EMPRESA = "+ company );
			sql.append(" AND ");
			sql.append(" SUCURSAL = "+ branch );
			
			
			return sql.toString();
			
		}
		
}
