package com.garbarino.migrator.type;

import java.io.Serializable;
import java.util.List;

import org.jetbrains.annotations.Nullable;


public class ObservedType implements Serializable
{

    //~ Fields ...................................................................................................................

    @Nullable private AddressSerchType address = null;
    @Nullable private List<PersonSearchType> authorized = null;
    @Nullable private CardSearchType card = null;
    @Nullable private IpSearchType ip = null;
    @Nullable private String observation = null;
    @Nullable private PersonSearchType person = null;
   

    
    public AddressSerchType getAddress() {
		return address;
	}


	public void setAddress(AddressSerchType address) {
		this.address = address;
	}


	public List<PersonSearchType> getAuthorized() {
		return authorized;
	}


	public void setAuthorized(List<PersonSearchType> authorized) {
		this.authorized = authorized;
	}


	public CardSearchType getCard() {
		return card;
	}


	public void setCard(CardSearchType card) {
		this.card = card;
	}


	public IpSearchType getIp() {
		return ip;
	}


	public void setIp(IpSearchType ip) {
		this.ip = ip;
	}


	public String getObservation() {
		return observation;
	}


	public void setObservation(String observation) {
		this.observation = observation;
	}


	public PersonSearchType getPerson() {
		return person;
	}


	public void setPerson(PersonSearchType person) {
		this.person = person;
	}


	
	private static final long serialVersionUID = 1449310910991872227L;

}
