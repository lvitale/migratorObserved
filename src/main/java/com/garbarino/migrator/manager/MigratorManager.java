package com.garbarino.migrator.manager;

import java.util.ArrayList;
import java.util.List;

import com.garbarino.migrator.dao.DatoNegativoDao;
import com.garbarino.migrator.entity.DatoNegativo;
import com.garbarino.migrator.service.RestService;
import com.garbarino.migrator.utils.Mapper;

public class MigratorManager {

//	RestService service = RestService.getInstance();
//	Mapper mapper = Mapper.getInstance();
	
	public void migrate(int rows){
		
		List<DatoNegativo> listado = new ArrayList<DatoNegativo>();
		listado.addAll(new DatoNegativoDao().findAll(rows));
		
		for(DatoNegativo negativo : listado){
			callService(negativo);
		}
	}
	
	private void callService(DatoNegativo negativo){
		try{
			 RestService.getInstance().call(Mapper.getInstance().parse(negativo.populateObserved()));
		}catch(Exception ex){
				
			}
		}
	
}
