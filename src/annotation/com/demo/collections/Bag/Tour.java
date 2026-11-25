package annotation.com.demo.collections.Bag;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionOfElements;

@Entity
@Table(name="TOURS")
public class Tour {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TOURIST_ID")
	private long id;

	@Column(name="TOURIST_NAME")
	private String touristName;

	@Column(name="NUMBER_OF_TRAVELS")
	private int numberOfTimesTravelled;


	@CollectionOfElements(targetElement=java.lang.String.class, fetch=FetchType.EAGER)
	@JoinTable(name="COUNTRIES",joinColumns=@JoinColumn(name="TOURIST_ID"))
	@org.hibernate.annotations.CollectionId(columns=@Column(name="BAG_TABLE_ID"),
			type=@org.hibernate.annotations.Type(type="string"),
			generator="sequence")
			@Column(name="COUNTRY")
			private Collection<String> travelledCountries = new ArrayList<String>();

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
