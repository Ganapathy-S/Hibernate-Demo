package annotation.com.demo.collections.Map;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.util.HibernateAnnotationUtil;

public class MapAnnotationExecutor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Persisting the Exam object
		Session session = HibernateAnnotationUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		Exam exam = new Exam();
		exam.setExamName("Secondary Exam");
		Map<String,Date> timeTable = exam.getTimeTable();
		timeTable.put("Hindi", new Date("12/03/2010"));
		timeTable.put("French", new Date("13/03/2010"));
		timeTable.put("Urdu", new Date("14/03/2010"));
		timeTable.put("History", new Date("15/03/2009"));
		timeTable.put("Science", new Date("16/03/2009"));
		
		session.save(exam);
		tx.commit();
		
		//Retrieving the Exam object
		Session sessionTwo = HibernateAnnotationUtil.getSessionFactory().openSession();
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
		
		HibernateAnnotationUtil.shutdown();
		System.out.println("-------Done------");
	}

}
