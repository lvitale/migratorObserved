package com.garbarino.migrator.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.garbarino.migrator.entity.RegistroDecidir;

public class RegistroDecidirDao {

	ConnectionDao connection;
	
	public RegistroDecidirDao(){
		connection = new ConnectionDao();
	}
	public List<RegistroDecidir> find(Long cart,Integer company,Integer branch,Integer rows){
		List<RegistroDecidir> listado = new ArrayList<RegistroDecidir>();
		try{
		connection.connect();
		
		ResultSet rs=connection.executeQuery(getQuery(cart, company, branch, rows));
		
		while(rs.next()){
			RegistroDecidir decidir = new RegistroDecidir();
			
			decidir.setIdOper(rs.getLong("ID_OPERACION"));
			decidir.setSucursal(rs.getInt("SUCURSAL"));
			decidir.setEmpresa(rs.getInt("EMPRESA"));
			decidir.setFechaOriginal(rs.getDate("FECHA_ORIGINAL"));
			
			decidir.setMonto(rs.getString("MONTO"));
			decidir.setCuotas(rs.getInt("CUOTAS"));
			decidir.setDiasPagoDiferido(rs.getInt("DIAS_PAGO_DIF"));
			decidir.setEstado(rs.getString("ESTADO"));
			decidir.setRegistraContracargo(rs.getString("REGISTRA_CONTRACARGO"));
			decidir.setNroTarjeta(rs.getString("NRO_TARJETA"));
			decidir.setTitular(rs.getString("TITULAR"));
			decidir.setTipoDoc(rs.getString("TIPO_DOC"));
			
			decidir.setMotivo(rs.getString("MOTIVO"));
			decidir.setOrigen(rs.getString("ORIGEN"));
			
			decidir.setEmail(rs.getString("EMAIL"));
			
			decidir.setCostoEnvio(rs.getString("COSTO_ENVIO"));
			decidir.setCostoTotal(rs.getString("COSTO_TOTAL"));
			decidir.setObservaciones(rs.getString("OBSERVACIONES"));
			
			decidir.setScore(rs.getString("SCORE"));
			decidir.setIp(rs.getString("IP"));
			decidir.setNroDoc(rs.getLong("NRO_DOC"));
			listado.add(decidir);
			
		
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
			sql.append(" FROM REGISTROS_DECIDIR ");
			sql.append(" WHERE ");
			sql.append(" ROWNUM < "+ rows );
			sql.append(" AND ");
			sql.append(" ID_OPERACION = "+ cart );
			sql.append(" AND ");
			sql.append(" EMPRESA = "+ company );
			sql.append(" AND ");
			sql.append(" SUCURSAL = "+ branch );
			
			
			return sql.toString();
			
		}
}
