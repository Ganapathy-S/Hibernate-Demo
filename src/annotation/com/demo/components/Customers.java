package annotation.com.demo.components;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author aparthin
 *
 */
@Entity
@Table(name="CUSTOMERS")
public class Customers {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CUSTOMER_ID")
	private long id;
	
	@Column(name="NAME")
	private String name;	
	
	@Embedded
	@AttributeOverrides({
	@AttributeOverride(name="street", column = @Column(name="HOME_STREET")),
	@AttributeOverride(name="zipCode", column = @Column(name="HOME_ZIPCODE")),
	@AttributeOverride(name="city", column=@Column(name="HOME_CITY"))
	})
	private Address homeAddress;
	@Embedded
	@AttributeOverrides({
	@AttributeOverride(name="street", column = @Column(name="BILLING_STREET")),
	@AttributeOverride(name="zipCode", column = @Column(name="BILLING_ZIPCODE")),
	@AttributeOverride(name="city", column=@Column(name="BILLING_CITY"))
	})
	private Address billingAddress;
	
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the homeAddress
	 */
	public Address getHomeAddress() {
		return homeAddress;
	}
	/**
	 * @param homeAddress the homeAddress to set
	 */
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	/**
	 * @return the billingAddress
	 */
	public Address getBillingAddress() {
		return billingAddress;
	}
	/**
	 * @param billingAddress the billingAddress to set
	 */
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}	
}
