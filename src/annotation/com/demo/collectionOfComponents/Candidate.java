package annotation.com.demo.collectionOfComponents;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Candidate {

	@Column(name="NAME",nullable=false)
	private String name;

	@Column(name="AGE",nullable=false)
	private int age;

	@Column(name="qualification",nullable=false)
	private String qualification;

	@Column(name="experience",nullable=false)
	private String experience;
	
	@org.hibernate.annotations.Parent
	private Recruitment recruitment;

	public Recruitment getRecruitment() {
		return recruitment;
	}

	public void setRecruitment(Recruitment recruitment) {
		this.recruitment = recruitment;
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

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}
}
