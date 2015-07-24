package com.garbarino.migrator.type;

import org.jetbrains.annotations.Nullable;



public  class Address
{
       
        @Nullable private String name = null;
        @Nullable private String streetName = null;
        @Nullable private String streetBetween1 = null;
        @Nullable private String streetBetween2 = null;
        @Nullable private String streetNumber = null;
        @Nullable private String buildingFloor = null;
        @Nullable private String buildingRoom = null;
        @Nullable private String extensionLine = null;
        @Nullable private String observations = null;
        @Nullable private String phone = null;
        private int cityId = 0;
        @Nullable private String zipCode = null;
        private boolean normalized = false;
        @Nullable private Double latitude = null;
        @Nullable private Double longitude = null;
        @Nullable private String notes = null;
		
        public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getStreetName() {
			return streetName;
		}
		public void setStreetName(String streetName) {
			this.streetName = streetName;
		}
		public String getStreetBetween1() {
			return streetBetween1;
		}
		public void setStreetBetween1(String streetBetween1) {
			this.streetBetween1 = streetBetween1;
		}
		public String getStreetBetween2() {
			return streetBetween2;
		}
		public void setStreetBetween2(String streetBetween2) {
			this.streetBetween2 = streetBetween2;
		}
		public String getStreetNumber() {
			return streetNumber;
		}
		public void setStreetNumber(String streetNumber) {
			this.streetNumber = streetNumber;
		}
		public String getBuildingFloor() {
			return buildingFloor;
		}
		public void setBuildingFloor(String buildingFloor) {
			this.buildingFloor = buildingFloor;
		}
		public String getBuildingRoom() {
			return buildingRoom;
		}
		public void setBuildingRoom(String buildingRoom) {
			this.buildingRoom = buildingRoom;
		}
		public String getExtensionLine() {
			return extensionLine;
		}
		public void setExtensionLine(String extensionLine) {
			this.extensionLine = extensionLine;
		}
		public String getObservations() {
			return observations;
		}
		public void setObservations(String observations) {
			this.observations = observations;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public int getCityId() {
			return cityId;
		}
		public void setCityId(int cityId) {
			this.cityId = cityId;
		}
		public String getZipCode() {
			return zipCode;
		}
		public void setZipCode(String zipCode) {
			this.zipCode = zipCode;
		}
		public boolean isNormalized() {
			return normalized;
		}
		public void setNormalized(boolean normalized) {
			this.normalized = normalized;
		}
		public Double getLatitude() {
			return latitude;
		}
		public void setLatitude(Double latitude) {
			this.latitude = latitude;
		}
		public Double getLongitude() {
			return longitude;
		}
		public void setLongitude(Double longitude) {
			this.longitude = longitude;
		}
		public String getNotes() {
			return notes;
		}
		public void setNotes(String notes) {
			this.notes = notes;
		}
       
        

        
       
    
}
