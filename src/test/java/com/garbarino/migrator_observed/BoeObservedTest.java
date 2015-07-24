package com.garbarino.migrator_observed;

import com.garbarino.migrator.manager.BoeManager;

public class BoeObservedTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			BoeManager manager = new BoeManager();
			manager.verifyObserved(20);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}

}
