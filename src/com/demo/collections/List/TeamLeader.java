package com.demo.collections.List;

import java.util.ArrayList;
import java.util.List;

public class TeamLeader {
	
	private long id;
	
	private String leaderName;
	
	List teamMembers = new ArrayList();

	public String getLeaderName() {
		return leaderName;
	}

	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}

	public List getTeamMembers() {
		return teamMembers;
	}

	public void setTeamMembers(List teamMembers) {
		this.teamMembers = teamMembers;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


}
