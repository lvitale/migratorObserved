package com.garbarino.migrator.type;

import java.io.Serializable;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.garbarino.migrator.enums.Brand;
import com.garbarino.migrator.enums.IdType;

public class CardSearchType
    implements Serializable
{

    //~ Fields ...................................................................................................................

    @NotNull private String binNumber = "";
    @NotNull private Brand cardbrand = Brand.NARANJA;
    @NotNull private IdType docType = IdType.NOT_INFORMED;
    @NotNull private String docValue = "";
    @NotNull private String lastNumber = "";
    @Nullable private String observation = null;

    private static final long serialVersionUID = 1449310910991872227L;

	public String getBinNumber() {
		return binNumber;
	}

	public void setBinNumber(String binNumber) {
		this.binNumber = binNumber;
	}

	public Brand getCardbrand() {
		return cardbrand;
	}

	public void setCardbrand(Brand cardbrand) {
		this.cardbrand = cardbrand;
	}

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

	public String getLastNumber() {
		return lastNumber;
	}

	public void setLastNumber(String lastNumber) {
		this.lastNumber = lastNumber;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

    
}
