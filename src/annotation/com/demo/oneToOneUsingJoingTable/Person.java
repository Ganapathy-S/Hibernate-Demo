package annotation.com.demo.oneToOneUsingJoingTable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="annotation.com.demo.oneToOneUsingJoingTable.Person")
@Table(name="PERSON")
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PERSON_ID")
	private long id;

	@Column(name="NAME")
	private String name;

	@OneToOne(cascade=CascadeType.ALL,mappedBy="person")
	@JoinTable(name="PASSPORTS",joinColumns=@JoinColumn(name="PERSON_ID"),
			inverseJoinColumns=@JoinColumn(name="PASSPORT_ID"))
	private Passport passport;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}
}
