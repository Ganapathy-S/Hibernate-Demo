package annotation.com.demo.components;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author aparthin
 *
 */
@Embeddable
public class Address {
	
	@Column(name="STREET",nullable=false)
	private String street;
	
	@Column(name="ZIPCODE",nullable=false)
	private String zipCode;
	
	@Column(name="CITY",nullable=false)
	private String city;
	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}
	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}
	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}	
}
