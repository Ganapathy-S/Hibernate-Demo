package jpa.com.demo.manyToManyUnidirectional;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import annotation.com.demo.manyToManyUnidirectional.Course;
import annotation.com.demo.manyToManyUnidirectional.Student;

public class ManyToManyJpaUniDirectionalExecutor {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaDemo");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
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

		em.persist(student1);
		em.persist(student2);
		tx.commit();
		em.close();		

		emf.close();
		System.out.println("-------Done-------");
	}
}
