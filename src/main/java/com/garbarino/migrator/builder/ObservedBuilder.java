package com.garbarino.migrator.builder;

import com.garbarino.migrator.dto.CartDTO;
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

public class ObservedBuilder {

	CartDTO dto ;
	ObservedType type = new ObservedType();
	
	public ObservedBuilder(CartDTO dto){
		this.dto = dto;
	}
	
	public void buildIp(){
		IpSearchType ipSearch = null;
		String ip = dto.getPersonEcommerce().getIp();
		
		if(ip != null){
		ipSearch = new IpSearchType();
		ipSearch.setIp(ip);
		type.setIp(ipSearch);
		}
		
	}
	public void buildCard(){
		CardSearchType card = null;
		String tarjeta = dto.getDecidir().getTarjeta();
		String numTarjeta = dto.getDecidir().getNroTarjeta();
		String documento=null;
		
		if(dto.getDecidir().getNroDoc()!=null){
			 documento = dto.getDecidir().getNroDoc().toString();
		}
		Integer brand = null;
		try{
		 brand = callServiceCardId();
		}catch(Exception ex){
			System.err.println(ex);
		}
		if(brand != null && numTarjeta != null && documento != null ){
		String tarj = numTarjeta.trim();	
		card = new CardSearchType();		
		card.setCardbrand(brand);
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
		card.setDocType(IdType.DNI);
		card.setDocValue(documento.trim());	
		type.setCard(card);
		}
	}
	
	public void buildPerson(){
		PersonSearchType person = null;
		String documento =null;
		if(dto.getPersonEcommerce().getDocumento()!=null){
			documento = dto.getPersonEcommerce().getDocumento().toString();
		}
		if(documento !=  null){
		person = new PersonSearchType();
		
		person.setFirstName(dto.getPersonEcommerce().getNombre());
		person.setLastName(dto.getPersonEcommerce().getApellido());
		person.setDocValue(documento.trim());
		person.setDocType(IdType.DNI);
		person.setGender(GenderType.NONE);
		type.setPerson(person);
		}
	}
	public void buildAddress(){
		AddressSerchType addressSerch = null;
		String numCalle = dto.getPersonEcommerce().getAltura();
		String localidad = dto.getPersonEcommerce().getLocalidad();
		String calle = dto.getPersonEcommerce().getCalle();
		String piso = dto.getPersonEcommerce().getPiso();
		String departamento = dto.getPersonEcommerce().getDepartamento();
		
		if(numCalle != null && calle != null && localidad != null){
		addressSerch = new AddressSerchType();
		addressSerch.setCity(localidad);
		addressSerch.setNumber(numCalle);
		addressSerch.setStreetName(calle);
		addressSerch.setBuildingFloor((piso != null) ? piso : "0");
		addressSerch.setBuildingRoom((departamento != null) ? departamento : "0");
		type.setAddress(addressSerch);
		}
	}
		public ObservedType getResult(){
			return type;
		}
		
		private Integer callServiceCityId() throws Exception{
			String json= Mapper.getInstance().parseTo(populateCityId());
			RestService.getInstance().setServiceName(ServiceName.CITY_ID_SEARCH);
			return RestService.getInstance().callServ(json);
			
		}
		private Integer callServiceCardId() throws Exception{
			String json= Mapper.getInstance().parseTo(populateCardId());
			if(!json.equals("null")){
			RestService.getInstance().setServiceName(ServiceName.CARD_ID_SEARCH);
			return RestService.getInstance().callServ(json);
			}
			return null;
		}
		
		private SearchCity populateCityId(){
			SearchCity searchCity = null;
			String localidad = dto.getPersonEcommerce().getLocalidad();
			if(localidad != null){
				searchCity = new SearchCity();
				searchCity.setSubdivision(localidad);
			}
			return searchCity;
			
		}
		private SearchCard populateCardId(){
			SearchCard searchCard = null;
			String tarjeta = dto.getDecidir().getTarjeta();
			if(tarjeta != null){
				searchCard = new SearchCard();
				searchCard.setDescription(tarjeta);
			}
			return searchCard;
		}
		
	
}
