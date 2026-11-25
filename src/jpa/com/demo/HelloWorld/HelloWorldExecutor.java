package jpa.com.demo.HelloWorld;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import annotation.com.demo.helloworld.Hello;

public class HelloWorldExecutor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Start EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaDemo");

		// First unit of work -- Persisting the Hello Object
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Hello hello = new Hello();
		hello.setName("Johnson");
		hello.setMessage("Welcome");
		em.persist(hello);
		tx.commit();
		em.close();

		// Second unit of work -- Retrieving all the hello Objects
		EntityManager newEm = emf.createEntityManager();
		EntityTransaction newTx = newEm.getTransaction();
		newTx.begin();
		List messages = newEm.createQuery("select h from Hello h").getResultList();
		for (Object hellos : messages) 
			System.out.println(((Hello)hellos).getMessage() + " " +((Hello)hellos).getName());

		newTx.commit();
		newEm.close();

		//Retrieving only a specific objcet  
		EntityManager emThree = emf.createEntityManager();
		EntityTransaction txThree = emThree.getTransaction();
		txThree.begin();		
		Hello h = emThree.find(Hello.class, new Long(1));
		System.out.println(h.getMessage() + " "+ h.getName());
		txThree.commit();
		emThree.close();

		/*//To remove an object
		EntityManager emFour = emf.createEntityManager();
		EntityTransaction txFour = emFour.getTransaction();
		txFour.begin();		
		hello = emFour.find(Hello.class, new Long(1));
		emFour.remove(hello);
		txFour.commit();
		emFour.close();*/
		
		emf.close();
		System.out.println("------Done-----");
	}
}
