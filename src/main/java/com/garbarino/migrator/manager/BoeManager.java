package com.garbarino.migrator.manager;

import java.util.ArrayList;
import java.util.List;

import com.garbarino.migrator.builder.ObservedDirector;
import com.garbarino.migrator.dao.PersonaEcommerceDao;
import com.garbarino.migrator.dao.RegistroDecidirDao;
import com.garbarino.migrator.dao.RegistroVerificadoDao;
import com.garbarino.migrator.dto.CartDTO;
import com.garbarino.migrator.entity.RegistroDecidir;
import com.garbarino.migrator.entity.RegistroEcommerce;
import com.garbarino.migrator.entity.RegistroVerificado;
import com.garbarino.migrator.enums.ServiceName;
import com.garbarino.migrator.service.RestService;
import com.garbarino.migrator.utils.Mapper;

public class BoeManager {

	private Integer company=1;
	private Integer status =308;
	
	
	public Integer getCompany() {
		return company;
	}
	public void setCompany(Integer company) {
		this.company = company;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public void verifyObserved(int rows){
		for(RegistroVerificado verificado : getListVerificado(rows)){	
			callService(getDataCart(verificado));
		}
	}
		private void callService(CartDTO dto){
			try{
				 RestService.getInstance().setServiceName(ServiceName.OBSERVED_CHECK);
				 ObservedDirector director = new ObservedDirector();
				 director.construct(dto);
				 RestService.getInstance().call(Mapper.getInstance().parse(director.construct(dto)));
				 
			}catch(Exception ex){
					System.err.println(ex);
				}
		}
	     
		private CartDTO getDataCart(RegistroVerificado verificado){
			CartDTO cartdto = new CartDTO();
			cartdto.setVerificado(verificado);
			cartdto.setPersonEcommerce(getPersonEcommerce(verificado.getIdOperacion(),verificado.getCodEmpresa(),verificado.getSucursal(),2));
			cartdto.setDecidir(getDecidir(verificado.getIdOperacion(),verificado.getCodEmpresa(),verificado.getSucursal(),2));
			return cartdto;
		}
		
		List<RegistroVerificado> getListVerificado(Integer row){
			List<RegistroVerificado> listado = new ArrayList<RegistroVerificado>();
			listado.addAll(new RegistroVerificadoDao().find(company,status,row));
			return listado;
		}
		private RegistroEcommerce getPersonEcommerce(long cart,Integer company,Integer branch,Integer rows){
			List<RegistroEcommerce> listado = new PersonaEcommerceDao().find(cart, company,branch, rows);
			RegistroEcommerce register = new RegistroEcommerce();
			
			if(listado!=null && listado.size() >0 ){
				register = listado.get(0);
			}
			return register;
		}
		private RegistroDecidir getDecidir(long cart,Integer company,Integer branch,Integer rows){
			List<RegistroDecidir> listado = new RegistroDecidirDao().find(cart, company, branch, rows);
			RegistroDecidir register = new RegistroDecidir();
			
			if(listado!=null && listado.size() >0 ){
				register = listado.get(0);
			}
			return register;
		}
		
		
	
}
