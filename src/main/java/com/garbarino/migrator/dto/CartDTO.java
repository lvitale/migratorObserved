package com.garbarino.migrator.dto;

import com.garbarino.migrator.entity.RegistroDecidir;
import com.garbarino.migrator.entity.RegistroEcommerce;
import com.garbarino.migrator.entity.RegistroVerificado;

public class CartDTO {
	
	private RegistroDecidir decidir;
	private RegistroVerificado verificado;
	private RegistroEcommerce personEcommerce;
	
	public RegistroDecidir getDecidir() {
		return decidir;
	}
	public void setDecidir(RegistroDecidir decidir) {
		this.decidir = decidir;
	}
	public RegistroVerificado getVerificado() {
		return verificado;
	}
	public void setVerificado(RegistroVerificado verificado) {
		this.verificado = verificado;
	}
	public RegistroEcommerce getPersonEcommerce() {
		return personEcommerce;
	}
	public void setPersonEcommerce(RegistroEcommerce personEcommerce) {
		this.personEcommerce = personEcommerce;
	}
	
}
