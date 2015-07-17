package com.garbarino.migrator.manager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.garbarino.migrator.dao.DatoNegativoDao;
import com.garbarino.migrator.entity.DatoNegativo;
import com.garbarino.migrator.enums.ServiceName;
import com.garbarino.migrator.service.RestService;
import com.garbarino.migrator.type.ObservedType;
import com.garbarino.migrator.type.ResulSet;
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
			// grabo las respuestas
			saveFile(RestService.getInstance().getResults());
	}
	
	private void callService(DatoNegativo negativo){
		try{
			 RestService.getInstance().setId(negativo.getId());
			 RestService.getInstance().setServiceName(ServiceName.OBSERVED_REPORT);
			 RestService.getInstance().call(Mapper.getInstance().parse(negativo.populateObserved()));
			 verifyOperation(negativo.populateObserved(),RestService.getInstance().getResult());
			 
		}catch(Exception ex){
				
			}
		}
	private void verifyOperation(ObservedType type,ResulSet rs){
		try{
			// REPORT 
			if(type.getAddress()!=null){
				String json= Mapper.getInstance().parseTo(type.getAddress());
				callService(ServiceName.ADDRESS_CHECK,json,rs);
				callService(ServiceName.ADDRESS_REPORT,json,rs);
			}if(type.getCard()!=null){
				String json= Mapper.getInstance().parseTo(type.getCard());
				callService(ServiceName.CARD_CHECK,json,rs);
				callService(ServiceName.CARD_REPORT,json,rs);
			}if(type.getIp()!=null){
				String json= Mapper.getInstance().parseTo(type.getIp());
				callService(ServiceName.IP_CHECK,json,rs);
				callService(ServiceName.IP_REṔORT,json,rs);
			}if(type.getPerson()!=null){
				String json= Mapper.getInstance().parseTo(type.getPerson());
				callService(ServiceName.PERSON_CHECK,json,rs);
				callService(ServiceName.PERSON_REPORT,json,rs);
				
			}
			
		}catch(Exception ex){
			
		}
	}
	
	private void callService(ServiceName service,String json,ResulSet rs){
		RestService.getInstance().setServiceName(service);
		RestService.getInstance().call(json);
		rs.add(RestService.getInstance().getResult());
	}
	/** save file **/
	public void saveFile(List<ResulSet> results){
		File file= new File(RestService.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "result.temp");
		FileWriter fw  = null;
		BufferedWriter bw = null;
		try{
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			
			for(ResulSet rs: results){
			  
			  bw.write(Mapper.getInstance().parseTo(rs));
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
}
