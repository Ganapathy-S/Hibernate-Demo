package com.demo.collections.Map;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.demo.util.HibernateUtil;

public class MapExecutor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Persisting the Exam object
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		Exam exam = new Exam();
		exam.setExamName("Priliminary Exam");
		Map<String,Date> timeTable = exam.getTimeTable();
		timeTable.put("English", new Date("08/02/2010"));
		timeTable.put("French", new Date("09/02/2010"));
		timeTable.put("Maths", new Date("10/02/2010"));
		timeTable.put("Science", new Date("11/02/2009"));
		timeTable.put("Computer", new Date("12/02/2009"));
		
		session.save(exam);
		tx.commit();
		
		//Retrieving the Exam object
		Session sessionTwo = HibernateUtil.getSessionFactory().openSession();
		Transaction txTwo = sessionTwo.beginTransaction();
		
		Exam exams = (Exam) sessionTwo.load(Exam.class, new Long(1));
		System.out.println("****************************************");
		System.out.println("****************************************");
		System.out.println("Exam Name is "+ exams.getExamName());
		System.out.println("************Exam Time Table ************");
		Set examSubjects = exams.getTimeTable().keySet(); 
		for(Object subject: examSubjects)
			System.out.println("Exam Subject Name is "+ subject + " and the Date is " + exams.getTimeTable().get(subject));
		System.out.println("****************************************");
		System.out.println("****************************************");
		txTwo.commit();
		sessionTwo.close();
		
		HibernateUtil.shutdown();
		System.out.println("-------Done------");
	}

}
