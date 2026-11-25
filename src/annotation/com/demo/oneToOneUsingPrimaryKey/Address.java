package annotation.com.demo.oneToOneUsingPrimaryKey;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="ADDRESS")
public class Address {
	
		@Id
		@GeneratedValue (strategy = GenerationType.AUTO)	
		@Column(name="ADDRESS_ID")
		private long id;
		
		@Column(name="STREET_NAME")
		private String street;
		@Column(name="ZIPCODE")
		private String zipCode;
		@Column(name="CITY_NAME")
		private String city;
		
		@OneToOne(fetch=FetchType.EAGER) //FetchType.EAGER sets the lazy loading to false
		@PrimaryKeyJoinColumn
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
