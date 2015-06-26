package com.garbarino.migrator.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.garbarino.migrator.entity.DatoNegativo;

public class DatoNegativoDao {
	ConnectionDao connection;
	
	public DatoNegativoDao(){
		connection = new ConnectionDao();
	}
	public List<DatoNegativo> findAll(Integer rows){
		List<DatoNegativo> listado = new ArrayList<DatoNegativo>();
		try{
		connection.connect();
		ResultSet rs=connection.executeQuery("SELECT * FROM DATOS_NEGATIVOS WHERE ROWNUM < "+ rows.toString() );
		while(rs.next()){
			DatoNegativo negativo = new DatoNegativo();
			
			negativo.setNombre(rs.getString("NOMBRE"));
			negativo.setApellido(rs.getString("APELLIDO"));
			negativo.setDocumento(rs.getString("DOCUMENTO"));
			
			negativo.setProvincia(rs.getString("PROVINCIA"));
			negativo.setCalle(rs.getString("CALLE"));
			negativo.setNumCalle(rs.getString("NUMERO_CALLE"));
			negativo.setPiso(rs.getString("PISO"));
			negativo.setLocalidad(rs.getString("LOCALIDAD"));
			negativo.setDepartamento(rs.getString("DEPARTAMENTO"));
			
			negativo.setTarjeta(rs.getString("TARJETA"));
			negativo.setNumTarjeta(rs.getString("NUMERO_TARJ"));
			
			negativo.setIp(rs.getString("IP"));
			negativo.setObservaciones(rs.getString("OBSERVACIONES"));
			negativo.setId(rs.getInt("ID"));
			
			listado.add(negativo);
			
		}
		connection.close();
		}catch(Exception ex){
			System.out.println(ex.getCause());
		}finally{
			
		}
		return listado;
	}
}
