package com.garbarino.migrator.builder;

import com.garbarino.migrator.dto.CartDTO;
import com.garbarino.migrator.type.ObservedType;

public class ObservedDirector {

	public ObservedType construct(CartDTO cart){
		ObservedBuilder builder = new ObservedBuilder(cart);
		builder.buildAddress();
		builder.buildCard();
		builder.buildIp();
		builder.buildPerson();
		return builder.getResult();
	}
	
	
}
