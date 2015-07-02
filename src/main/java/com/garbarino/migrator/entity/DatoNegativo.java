package com.garbarino.migrator.entity;

import java.util.Date;

import com.garbarino.migrator.enums.Brand;
import com.garbarino.migrator.enums.GenderType;
import com.garbarino.migrator.enums.IdType;
import com.garbarino.migrator.type.AddressSerchType;
import com.garbarino.migrator.type.CardSearchType;
import com.garbarino.migrator.type.IpSearchType;
import com.garbarino.migrator.type.ObservedType;
import com.garbarino.migrator.type.PersonSearchType;


public class DatoNegativo {

	private int id;
	private String nombre;
	private String apellido;
	private String documento;
	private String provincia;
	private String localidad;
	private String calle;
	private String numCalle;
	private String piso;
	private String departamento;
	private String tarjeta;
	private String numTarjeta;
	private String ip;
	private String observaciones;
	private Long operacion;
	private Date fecha;
	private String username;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumCalle() {
		return numCalle;
	}
	public void setNumCalle(String numCalle) {
		this.numCalle = numCalle;
	}
	public String getPiso() {
		return piso;
	}
	public void setPiso(String piso) {
		this.piso = piso;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}
	public String getNumTarjeta() {
		return numTarjeta;
	}
	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public Long getOperacion() {
		return operacion;
	}
	public void setOperacion(Long operacion) {
		this.operacion = operacion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public ObservedType populateObserved(){
		ObservedType observed = new ObservedType();
		if(populateAddress() != null) observed.setAddress(populateAddress());
		if(populateCard() != null)observed.setCard(populateCard());
		if(populateIp() != null)observed.setIp(populateIp());
		if(populatePerson() != null)observed.setPerson(populatePerson());
		observed.setObservation(observaciones);
		return observed;
	}
	private IpSearchType populateIp(){
		IpSearchType ipSearch = null;
		if(ip != null){
		ipSearch = new IpSearchType();
		ipSearch.setIp(ip);
		ipSearch.setObservation(observaciones);
		}
		return ipSearch;
	}
	private CardSearchType populateCard(){
		CardSearchType card = null;
		Brand brand = Brand.NONE.getCard(tarjeta);
		if(brand != null && numTarjeta != null ){
		card = new CardSearchType();		
		card.setCardbrand(brand);
		card.setLastNumber(numTarjeta);
		card.setDocType(IdType.DNI);
		card.setDocValue(documento);	
		card.setObservation(observaciones);
		}
		return card;
	}
	private PersonSearchType populatePerson(){
		PersonSearchType person = null;
		if(documento !=  null){
		person = new PersonSearchType();
		
		person.setFirstName(nombre);
		person.setLastName(apellido);
		person.setDocValue(documento);
		person.setDocType(IdType.DNI);
		person.setGender(GenderType.NONE);
		person.setObservation(observaciones);
		}
		return person;
	}
	private AddressSerchType populateAddress(){
		AddressSerchType addressSerch = null;
		if(numCalle != null && calle != null){
		addressSerch = new AddressSerchType();
		addressSerch.setCity(localidad);
		addressSerch.setNumber(numCalle);
		addressSerch.setObservation(observaciones);
		addressSerch.setStreetName(calle);
		}
		return addressSerch;
	}
	
}
