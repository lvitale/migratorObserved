package com.garbarino.migrator.type;

import java.io.Serializable;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;



public class AddressSerchType implements Serializable
{

    @Nullable private Address addresses = null;
    @NotNull private String city = "";
    @NotNull private String number = "";
    @Nullable private String observation = null;
    @NotNull private String streetName = "";
    
    
    public Address getAddresses() {
		return addresses;
	}


	public void setAddresses(Address addresses) {
		this.addresses = addresses;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getObservation() {
		return observation;
	}


	public void setObservation(String observation) {
		this.observation = observation;
	}


	public String getStreetName() {
		return streetName;
	}


	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}


	private static final long serialVersionUID = 1449310910991872227L;

}
