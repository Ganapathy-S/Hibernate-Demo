package com.demo.collections.List;

import java.util.List;
import org.hibernate.Transaction;
import org.hibernate.Session;
import com.demo.util.HibernateUtil;

@SuppressWarnings(value="unchecked")
public class ListExecutor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Persisting the TeamLeadre object
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		TeamLeader teamLeader = new TeamLeader();
		teamLeader.setLeaderName("Rajan");
		List teamMembers = teamLeader.getTeamMembers(); 
		teamMembers.add("Deva");
		teamMembers.add("Sunder");
		teamMembers.add("Kumar");
		teamMembers.add("Mohan");
		teamMembers.add("Senthil");
		teamMembers.add("Mohan");
		teamMembers.add("Senthil");
		session.save(teamLeader);
		tx.commit();
		session.close();
		
		//Retreiving the TeamLeader object
		Session sessionTwo = HibernateUtil.getSessionFactory().openSession();
		Transaction txTwo = sessionTwo.beginTransaction();
		
		TeamLeader leader = (TeamLeader) sessionTwo.load(TeamLeader.class, new Long(1));
		System.out.println("**********************************************************");
		System.out.println("**********************************************************");
		System.out.println("Team leader name is "+ leader.getLeaderName());
		System.out.println("**********************************************************");
		System.out.println("**********************************************************");
		List members = leader.getTeamMembers();
		for(Object member: members)
			System.out.println("Member name is "+ member);
		
		System.out.println("**********************************************************");
		System.out.println("**********************************************************");
		
		txTwo.commit();
		sessionTwo.close();
		HibernateUtil.shutdown();
		System.out.println("------Done-----");
	}
}
