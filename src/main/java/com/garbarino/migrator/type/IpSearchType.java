package com.garbarino.migrator.type;

import java.io.Serializable;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class IpSearchType implements Serializable
{

    //~ Fields ...................................................................................................................

    @NotNull private String ip = "";
    @Nullable private String observation = null;

    

    public String getIp() {
		return ip;
	}



	public void setIp(String ip) {
		this.ip = ip;
	}



	public String getObservation() {
		return observation;
	}



	public void setObservation(String observation) {
		this.observation = observation;
	}



	private static final long serialVersionUID = 1449310910991872227L;

}
