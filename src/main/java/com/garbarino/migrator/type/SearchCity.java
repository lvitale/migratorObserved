package com.garbarino.migrator.type;

import java.io.Serializable;

import org.jetbrains.annotations.Nullable;

public class SearchCity implements Serializable{

	@Nullable private Integer city = null;
    @Nullable private String subdivision = null;
    @Nullable private String name = null;
    
	

	public Integer getCity() {
		return city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}

	public String getSubdivision() {
		return subdivision;
	}

	public void setSubdivision(String subdivision) {
		this.subdivision = subdivision;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -5902972419659364981L;

}
