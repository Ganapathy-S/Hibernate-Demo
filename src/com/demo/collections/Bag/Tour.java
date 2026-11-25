package com.demo.collections.Bag;

import java.util.ArrayList;
import java.util.Collection;

public class Tour {
	
	private long id;
	
	private String touristName;
	
	private int numberOfTimesTravelled;
	
	private Collection travelledCountries = new ArrayList();
	
	public String getTouristName() {
		return touristName;
	}
	public void setTouristName(String touristName) {
		this.touristName = touristName;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getNumberOfTimesTravelled() {
		return numberOfTimesTravelled;
	}
	public void setNumberOfTimesTravelled(int numberOfTimesTravelled) {
		this.numberOfTimesTravelled = numberOfTimesTravelled;
	}
	
	public Collection getTravelledCountries() {
		return travelledCountries;
	}
	public void setTravelledCountries(Collection travelledCountries) {
		this.travelledCountries = travelledCountries;
	}
}
