package com.demo.collectionOfComponents;

import java.util.Set;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.demo.util.HibernateUtil;

public class CollectionComponentExecutor {

	public static void main(String[] args) {
		//Persisting Recruitment
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		Recruitment rcrmt = new Recruitment();
		rcrmt.setRecruitmentName("Railway Recruitment Board");
		String [] names = {"Somu","Rajesh","Govindh","Menaka"};
		int [] age = {26,28,25,29};
		String [] qualification = {"B.E","M.C.A","BSc","M.C.A"};
		int [] experience = {3,4,3,4};
		Candidate [] candidate = new Candidate[4];
		
		for(int i=0; i<4; i++){
			candidate[i] = new Candidate();
			candidate[i].setName(names[i]);
			candidate[i].setAge(age[i]);
			candidate[i].setQualification(qualification[i]);
			candidate[i].setExperience(experience[i]+" years");
			candidate[i].setRecruitment(rcrmt);
		}
	
		Set selectedCandidates = rcrmt.getSelectedCandidates();
		selectedCandidates.add(candidate[0]);
		selectedCandidates.add(candidate[1]);
		
		Set rejectedCandidates = rcrmt.getRejectedCandidates();
		rejectedCandidates.add(candidate[2]);
		rejectedCandidates.add(candidate[3]);
		
		session.save(rcrmt);
		tx.commit();
		session.close();
			
		//Retreiving the Recruitment
		Session sessionTwo = HibernateUtil.getSessionFactory().openSession();
		Transaction txTwo = sessionTwo.beginTransaction();
		Recruitment  rcrmts = (Recruitment) sessionTwo.load(Recruitment.class, new Long(1));
		System.out.println("*************************************************************");
		System.out.println("*************************************************************");
		System.out.println("Recruitment name is "+ rcrmts.getRecruitmentName());
		Set selectedCandids = rcrmts.getSelectedCandidates();
		System.out.println("************Selected Candidates******************************");
		for(Object candid : selectedCandids){
			System.out.println("Candidate Name " + ((Candidate)candid).getName());
			System.out.println("Candidate Age " + ((Candidate)candid).getAge());
			System.out.println("Candidate Qualification " + ((Candidate)candid).getQualification());
			System.out.println("Candidate Experience " + ((Candidate)candid).getExperience());
		}
		Set rejectedCandids = rcrmts.getSelectedCandidates();
		System.out.println("************Rejected Candidates******************************");
		for(Object candid : rejectedCandids){
			System.out.println("Candidate Name " + ((Candidate)candid).getName());
			System.out.println("Candidate Age " + ((Candidate)candid).getAge());
			System.out.println("Candidate Qualification " + ((Candidate)candid).getQualification());
			System.out.println("Candidate Experience " + ((Candidate)candid).getExperience());
		}
		System.out.println("*************************************************************");
		System.out.println("*************************************************************");
		txTwo.commit();
		sessionTwo.close();
		
		HibernateUtil.shutdown();
		System.out.println("-----Done----");
	}
}
