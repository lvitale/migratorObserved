package com.garbarino.migrator.type;

import java.io.Serializable;

import org.jetbrains.annotations.Nullable;

public class SearchCard implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4918086266756400977L;
	@Nullable private String description = null;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	


}
