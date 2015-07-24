package com.garbarino.migrator.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.garbarino.migrator.entity.RegistroVerificado;

public class RegistroVerificadoDao {

ConnectionDao connection;
	
	public RegistroVerificadoDao(){
		connection = new ConnectionDao();
	}
	public List<RegistroVerificado> find(Integer company,Integer status,Integer rows){
		List<RegistroVerificado> listado = new ArrayList<RegistroVerificado>();
		try{
		connection.connect();
		
		ResultSet rs=connection.executeQuery(getQuery(company, status, rows));
		
		while(rs.next()){
			RegistroVerificado verificado = new RegistroVerificado();
			
			verificado.setIdOperacion(rs.getLong("ID_OPERACION"));
			verificado.setSucursal(rs.getInt("SUCURSAL"));
			verificado.setEstado(rs.getString("ESTADO"));
			verificado.setCodEmpresa(rs.getInt("COD_EMPRESA"));
			
			listado.add(verificado);
			
		
		}
		connection.close();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}finally{
			
		}
		return listado;
       }
	
		private String getQuery(Integer company,Integer status,Integer rows){
			StringBuffer sql = new StringBuffer();
			sql.append(" SELECT * ");
			sql.append(" FROM REGISTROS_VERIFICADOS ");
			sql.append(" WHERE ");
			sql.append(" ROWNUM < "+ rows.toString() );
			sql.append(" AND ");
			sql.append(" COD_EMPRESA = "+ company.toString() );
			sql.append(" AND ");
			sql.append(" COD_ESTADO = "+ status  );
			
			return sql.toString();
			
		}
}
