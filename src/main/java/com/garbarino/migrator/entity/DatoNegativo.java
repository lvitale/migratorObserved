package com.garbarino.migrator.entity;

import java.text.Collator;
import java.util.Date;

import com.garbarino.migrator.enums.GenderType;
import com.garbarino.migrator.enums.IdType;
import com.garbarino.migrator.enums.ServiceName;
import com.garbarino.migrator.service.RestService;
import com.garbarino.migrator.type.AddressSerchType;
import com.garbarino.migrator.type.CardSearchType;
import com.garbarino.migrator.type.IpSearchType;
import com.garbarino.migrator.type.ObservedType;
import com.garbarino.migrator.type.PersonSearchType;
import com.garbarino.migrator.type.SearchCard;
import com.garbarino.migrator.type.SearchCity;
import com.garbarino.migrator.utils.Mapper;


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
	private String cityId;
	
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
	
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public ObservedType populateObserved() throws Exception{
		ObservedType observed = new ObservedType();
		if(populateAddress() != null) observed.setAddress(populateAddress());
		if(populateCard() != null)observed.setCard(populateCard());
		if(populateIp() != null)observed.setIp(populateIp());
		if(populatePerson() != null)observed.setPerson(populatePerson());
		//invocamos al servicio para traer el id de la ciudad - si esta informado
				
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
	private CardSearchType populateCard() throws Exception{
		CardSearchType card = null;
		
		Integer brand = callServiceCardId();
		if(brand != null && numTarjeta != null && documento != null ){
		String tarj = numTarjeta.trim();
		if(tarj.length() > 3){
			card = new CardSearchType();		
			card.setCardbrand(brand);;

			if(tarj.length() == 4) {
				card.setLastNumber(tarj);
			}else{
				if(tarj.length() > 10){
					card.setBinNumber(tarj.substring(0, 6));
					card.setLastNumber(tarj.substring(tarj.length()-4, tarj.length()));
				}else{
					card.setLastNumber(tarj.substring(tarj.length()-4, tarj.length()));
				}
			}

			card.setFirstName(nombre);
			card.setLastName(apellido);
			card.setDocType(IdType.DNI);
			card.setDocValue(documento.trim());
			card.setObservation(observaciones);
		}
		}
		return card;
	}
	
	private PersonSearchType populatePerson() throws Exception{
		PersonSearchType person = null;
		if(documento !=  null){
		person = new PersonSearchType();
		
		person.setFirstName(nombre);
		person.setLastName(apellido);
		person.setDocValue(documento.trim().replace(".", ""));
		person.setDocType(IdType.DNI);
		person.setGender(GenderType.NONE);
		person.setObservation(observaciones);
		Collator comparador = Collator.getInstance();
		 
		// Ejemplo del metodo equals
		 
		// Para no distinguir entre mayusculas, minusculas y letras con acentos.
		comparador.setStrength(Collator.PRIMARY);
		 
		// Se hace la comparación (Son iguales)
		if(localidad != null){
			if (comparador.equals(localidad, "CIUDAD AUTÓNOMA DE BUENOS AIRES")) {
				person.setCityId(11);
			}else{      
				person.setCityId(callServiceCityId());		
			}
		}
		}
		return person;
	}
	private AddressSerchType populateAddress(){
		AddressSerchType addressSerch = null;
		if(numCalle != null && calle != null && localidad != null){
		addressSerch = new AddressSerchType();
		addressSerch.setState((provincia != null) ? provincia : "NOT_INFORMED");
		addressSerch.setCity(localidad);
		addressSerch.setNumber(numCalle);
		addressSerch.setBuildingFloor((piso != null) ? piso : "0");
		addressSerch.setBuildingRoom((departamento != null) ? departamento : "0");
		addressSerch.setObservation(observaciones);
		addressSerch.setStreetName(calle);
		}
		return addressSerch;
	}
	private SearchCity populateCityId(){
		SearchCity searchCity = null;
		if(localidad != null){
			searchCity = new SearchCity();
			searchCity.setSubdivision(localidad);
		}
		return searchCity;
		
	}
	private SearchCard populateCardId(){
		SearchCard searchCard = null;
		if(tarjeta != null){
			searchCard = new SearchCard();
			searchCard.setDescription(tarjeta);
		}
		return searchCard;
	}
	private Integer callServiceCityId() throws Exception{
		String json= Mapper.getInstance().parseTo(populateCityId());
		RestService.getInstance().setServiceName(ServiceName.CITY_ID_SEARCH);
		return RestService.getInstance().callServ(json);
		
	}
	private Integer callServiceCardId() throws Exception{
		if(!(populateCardId().getDescription().equals("AMERICAN") || populateCardId().getDescription().equals("AMEX"))){
		String json= Mapper.getInstance().parseTo(populateCardId());
		if(!json.equals("null")){			
				RestService.getInstance().setServiceName(ServiceName.CARD_ID_SEARCH);
				return RestService.getInstance().callServ(json);
		}
		return null;
		}
		return 13;
	}
	
}
