package com.garbarino.migrator.manager;

import java.util.ArrayList;
import java.util.List;

import com.garbarino.migrator.dao.DatoNegativoDao;
import com.garbarino.migrator.entity.DatoNegativo;
import com.garbarino.migrator.service.RestService;
import com.garbarino.migrator.utils.Mapper;

public class MigratorManager {

    
    private final int rowsNum;
    
	public MigratorManager(int rows){
		rowsNum=rows;
	}
	public void migrate(){
		
			List<DatoNegativo> listado = new ArrayList<DatoNegativo>();
			listado.addAll(new DatoNegativoDao().findAll(rowsNum));
			
		
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
	public void callArchivo(){
		RestService.getInstance().grabarArchivo();
	}
}
