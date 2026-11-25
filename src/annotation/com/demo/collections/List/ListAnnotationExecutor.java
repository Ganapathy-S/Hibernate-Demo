package annotation.com.demo.collections.List;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.util.HibernateAnnotationUtil;

public class ListAnnotationExecutor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Persisting the TeamLeadre object
		Session session = HibernateAnnotationUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		TeamLeader teamLeader = new TeamLeader();
		teamLeader.setLeaderName("Mohan Raj");
		List teamMembers = teamLeader.getTeamMembers(); 
		teamMembers.add("Devi");
		teamMembers.add("Sundari");
		teamMembers.add("Kumari");
		teamMembers.add("Mohini");
		teamMembers.add("Senthil");
		teamMembers.add("Mohan Kumar");
		teamMembers.add("Senthil");
		session.save(teamLeader);
		tx.commit();
		session.close();
		
		//Retreiving the TeamLeader object
		Session sessionTwo = HibernateAnnotationUtil.getSessionFactory().openSession();
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
		HibernateAnnotationUtil.shutdown();
		System.out.println("------Done-----");
	}

}
