package annotation.com.demo.collectionOfComponents;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
@Entity
@Table(name="RECRUITMENTS")
public class Recruitment {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="RCRMT_ID")
	private long id;
	
	@Column(name="RCRMT_NAME")
	private String recruitmentName;
	
	@org.hibernate.annotations.CollectionOfElements
	@JoinTable(name="SELECTED_LIST",joinColumns=@JoinColumn(name="RCRMT_ID"))
	@AttributeOverrides({
	@AttributeOverride(name="name", column = @Column(name="NAME")),
	@AttributeOverride(name="age", column = @Column(name="AGE")),
	@AttributeOverride(name="qualification", column=@Column(name="QUALIFICATION")),
	@AttributeOverride(name="experience", column=@Column(name="EXPERIECE"))
	})
	private Set<Candidate> selectedCandidates = new HashSet<Candidate>();
	
	@org.hibernate.annotations.CollectionOfElements
	@JoinTable(name="REJECTED_LIST",joinColumns=@JoinColumn(name="RCRMT_ID"))
	@AttributeOverrides({
	@AttributeOverride(name="name", column = @Column(name="NAME")),
	@AttributeOverride(name="age", column = @Column(name="AGE")),
	@AttributeOverride(name="qualification", column=@Column(name="QUALIFICATION")),
	@AttributeOverride(name="experience", column=@Column(name="EXPERIECE"))
	})
	private Set<Candidate> rejectedCandidates = new HashSet<Candidate>();
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRecruitmentName() {
		return recruitmentName;
	}

	public void setRecruitmentName(String recruitmentName) {
		this.recruitmentName = recruitmentName;
	}

	public Set<Candidate> getSelectedCandidates() {
		return selectedCandidates;
	}

	public void setSelectedCandidates(Set<Candidate> selectedCandidates) {
		this.selectedCandidates = selectedCandidates;
	}

	public Set<Candidate> getRejectedCandidates() {
		return rejectedCandidates;
	}

	public void setRejectedCandidates(Set<Candidate> rejectedCandidates) {
		this.rejectedCandidates = rejectedCandidates;
	}
}
