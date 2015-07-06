package com.garbarino.migrator.enums;

import org.jetbrains.annotations.NotNull;


public enum Brand
    
{
    NARANJA("Tarjeta Naranja", "NAR"),
    SHOPPING("Tarjeta Shopping", "SHOP"),
    VISA("Visa", "VISA"),
    MASTERCARD("MasterCard", "MAST"),
    PROPIO("CreditoPropio", "PROP"),
    AMEX("Amex", "AMEX"),
    NATIVA("Nativa", "NAT"),
    DINERS("Diners", "DIN"),
    NATIVA_MAS("Nativa Mastercard", "NATM"),
    CABAL("Cabal", "CAB"),
    AMERICAN("American","AMER"),
    MERCADO_PAGO("Mercado Pago","MERP"),
    BANELCO("Banelco","BANE"),
    NONE("Not informed","NI");

    //~ Fields ...................................................................................................................

    @NotNull private final String label;
    @NotNull private final String id;

    //~ Constructors .............................................................................................................

    Brand(@NotNull String label, @NotNull String id) {
        this.label = label;
        this.id = id;
    }
    
    public Brand getCard(String key){
    	if(key!=null){
    		
    		for(Brand item : Brand.values()){
    			String aux[] = key.split(" ");
    			if(item.toString().equalsIgnoreCase(aux[0])){
    				return item;
    			}
    		}
    		// hay dos tipos de tarjeta master en la base
    		if("MASTER".equals(key)){
    			return Brand.MASTERCARD;
    		}
    		if("TARJETA NARANJA".equals(key)){
    			return Brand.NARANJA;
    		}
    		
    	}
    	return null;
    }

    
}
