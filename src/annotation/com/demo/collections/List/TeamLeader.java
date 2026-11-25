package annotation.com.demo.collections.List;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="TEAM_LEADER")
public class TeamLeader {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="LEADER_ID")
	private long id;

	@Column(name="LEADER_NAME")
	@Fetch(FetchMode.SELECT)
	private String leaderName;

	@org.hibernate.annotations.CollectionOfElements(
			targetElement=java.lang.String.class, fetch=FetchType.EAGER) //targetElement is optional if we use generics in the collections
			@JoinTable(name="MEMBERS",joinColumns=@JoinColumn(name="LEADER_ID"))
			@org.hibernate.annotations.IndexColumn(name="ORDER_ID")
			@Column(name="MEMBER_NAME")
			List<String> teamMembers = new ArrayList<String>();

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
