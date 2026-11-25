package jpa.com.demo.oneToManyUnidirectional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import annotation.com.demo.oneToManyUnidirectional.Account;
import annotation.com.demo.oneToManyUnidirectional.User;

public class OneToManyUniJpaExecutor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaDemo");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		User user = new User();
		user.setName("Jacob Robinson");
		Account account1 = new Account();
		account1.setAccountType("Savings Account");
		account1.setUser(user);
		Account account2 = new Account();
		account2.setAccountType("Salary Account");
		account2.setUser(user);
		Account account3 = new Account();
		account3.setAccountType("Credit Account");
		account3.setUser(user);
		
		em.persist(user);
		em.persist(account1);
		em.persist(account2);
		em.persist(account3);
		tx.commit();
		em.close();
		
		emf.close();
		System.out.println("-----Done-----");
	}
}
