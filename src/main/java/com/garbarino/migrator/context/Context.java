package com.garbarino.migrator.context;

import com.garbarino.migrator.enums.ContextGenesis;
import com.garbarino.migrator.enums.SchemaBoe;
import com.garbarino.migrator.utils.PropertiesUtil;

public class Context {

	private static Context instance= new Context();
	
	private SchemaBoe boe = SchemaBoe.DESARROLLO_ESQUEMA_BOE;
	private ContextGenesis genesis= ContextGenesis.lOCAL_GENESIS;
	
	private Context(){
		
	}
	
	public static Context getInstance(){
		return instance;
	}

	public void setContext(SchemaBoe boeIn){
		
		boe = boeIn;
		
	}

	public ContextGenesis getGenesis() {
		return genesis;
	}

	public void setGenesis(ContextGenesis genesis) {
		this.genesis = genesis;
		
	}
	
	public void changeContext(){
		// BOE
		PropertiesUtil prop= PropertiesUtil.getInstance();
		
		if(SchemaBoe.DESARROLLO_ESQUEMA_BOE.equals(boe)){
			prop.changeFile("profile-migrator-desa.properties");
			return;
		}
		if(SchemaBoe.TEST_ESQUEMA_BOE.equals(boe)){
			prop.changeFile("profile-migrator-test.properties");
			return;
		}
		if(SchemaBoe.PRODUCCION_ESQUEMA_BOE.equals(boe)){
			prop.changeFile("profile-migrator-prod.properties");
			return;
		}
		
		
	}
	
	
	
	
}
