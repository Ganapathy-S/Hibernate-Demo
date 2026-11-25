package com.demo.oneToOneUsingPrimaryKey;

public class Address {
	
		private long id;		
		private String street;
		private String zipCode;
		private String city;
		
		private User user;
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}		
		
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public String getStreet() {
			return street;
		}
		public void setStreet(String street) {
			this.street = street;
		}
		public String getZipCode() {
			return zipCode;
		}
		public void setZipCode(String zipCode) {
			this.zipCode = zipCode;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
}
