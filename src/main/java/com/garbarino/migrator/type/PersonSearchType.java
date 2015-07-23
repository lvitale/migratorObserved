package com.garbarino.migrator.type;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.garbarino.migrator.enums.GenderType;
import com.garbarino.migrator.enums.IdType;

public class PersonSearchType 
{


    @NotNull private IdType docType = IdType.NOT_INFORMED;
    @NotNull private String docValue = "";
    @Nullable private String email = null;
    @Nullable private String firstName = null;
    @NotNull private GenderType gender = GenderType.MALE;
    @Nullable private String lastName = null;
    @Nullable private String observation = null;
    @Nullable private Integer partyId = null; 
    @Nullable private String phone = null;
    @Nullable private Integer cityId = null;
    
    
    public IdType getDocType() {
		return docType;
	}


	public void setDocType(IdType docType) {
		this.docType = docType;
	}


	public String getDocValue() {
		return docValue;
	}


	public void setDocValue(String docValue) {
		this.docValue = docValue;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public GenderType getGender() {
		return gender;
	}


	public void setGender(GenderType gender) {
		this.gender = gender;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getObservation() {
		return observation;
	}


	public void setObservation(String observation) {
		this.observation = observation;
	}


	


	public Integer getPartyId() {
		return partyId;
	}


	public void setPartyId(Integer partyId) {
		this.partyId = partyId;
	}





	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Integer getCityId() {
		return cityId;
	}


	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}





	private static final long serialVersionUID = 1449310910991872227L;

}
