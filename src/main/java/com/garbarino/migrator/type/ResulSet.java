package com.garbarino.migrator.type;

import java.util.ArrayList;
import java.util.List;

import com.garbarino.migrator.enums.State;

public class ResulSet {

	private Integer id;
	private String message;
	private String response;
	private State state;
	private List<ResulSet> observeds= new ArrayList<ResulSet>();
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public void add(ResulSet rs){
		observeds.add(rs);
	}
	
	
	
}
