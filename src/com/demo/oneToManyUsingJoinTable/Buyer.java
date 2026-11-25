package com.demo.oneToManyUsingJoinTable;

import java.util.HashSet;
import java.util.Set;

public class Buyer {
	
	private long id;
	
	private String buyerName;
	
	Set<Property> properties = new HashSet<Property>();
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public Set<Property> getProperties() {
		return properties;
	}

	public void setProperties(Set<Property> properties) {
		this.properties = properties;
	}
	
	public void buyProperty(Property property){
		properties.add(property);
		property.setBuyer(this);
	}
}
