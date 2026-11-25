package com.demo.collectionOfComponents;

import java.util.HashSet;
import java.util.Set;

public class Recruitment {

	private long id;
	
	private String recruitmentName;
	
	private Set<Candidate> selectedCandidates = new HashSet<Candidate>();
	
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
