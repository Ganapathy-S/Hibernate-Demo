package annotation.com.demo.manyToManyUnidirectional;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.util.HibernateAnnotationUtil;

public class ManyToManyAnnotationUniDirectionalExecutor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session session = HibernateAnnotationUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Student student1 = new Student();
		student1.setStudentName("Suman");

		Student student2 = new Student();
		student2.setStudentName("Monica");

		Course course1 = new Course();
		course1.setCourseName("French");

		Course course2 = new Course();
		course2.setCourseName("Maths");

		student1.addCourse(course1);
		student1.addCourse(course2);
		student2.addCourse(course1);
		student2.addCourse(course2);

		session.save(student1);
		session.save(student2);
		tx.commit();
		session.close();		

		HibernateAnnotationUtil.shutdown();
		System.out.println("-------Done-------");
	}

}
