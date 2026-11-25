package annotation.com.demo.hibernateWithSpring;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FRIENDS")
public class Friend {
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private long id;
	
	@Column(name="FRIEND_NAME")
	private String name;
	
	@Column(name="AGE")
	private int age;
	
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
