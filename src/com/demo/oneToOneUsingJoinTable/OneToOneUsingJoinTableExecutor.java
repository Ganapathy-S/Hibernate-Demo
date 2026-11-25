package com.demo.oneToOneUsingJoinTable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.util.HibernateUtil;
public class OneToOneUsingJoinTableExecutor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Persisting Person and Passport
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		Person person = new Person();
		person.setName("Anand");

		Passport passport = new Passport();
		passport.setPassportNumber("A12586");

		//bidirectional
		person.setPassport(passport);
		passport.setPerson(person);		
		
		//This will persis person, and passport as we enabled casecade on person
		session.save(person);
		
		tx.commit();
		session.close();
		
		//Retrieving Person and Passport
		Session sessionTwo =HibernateUtil.getSessionFactory().openSession();
		Transaction txTwo = sessionTwo.beginTransaction();
		Person validPerson = (Person) sessionTwo.load(Person.class, new Long(1));
		Passport validPassport = validPerson.getPassport();
		System.out.println("********************************************");
		System.out.println("********************************************");
		System.out.println("Person name is "+ validPerson.getName());
		System.out.println("Passport Number is "+ validPassport.getPassportNumber());
		System.out.println("********************************************");
		System.out.println("********************************************");
		txTwo.commit();
		sessionTwo.close();		
		
		HibernateUtil.shutdown();
		
		System.out.println("------Done------");
	}
}
