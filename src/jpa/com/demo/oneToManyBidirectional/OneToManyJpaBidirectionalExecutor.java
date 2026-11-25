package jpa.com.demo.oneToManyBidirectional;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import annotation.com.demo.oneToManyBidirectional.Account;
import annotation.com.demo.oneToManyBidirectional.User;


public class OneToManyJpaBidirectionalExecutor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Persisting the User and Account
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaDemo");
		EntityManager emOne = emf.createEntityManager();
		EntityTransaction txOne = emOne.getTransaction();
		txOne.begin();
		User user = new User();
		user.setName("Suresh Raina");
		
		Account account1 = new Account();
		account1.setAccountType("Savings Account");
		user.addAccounts(account1);
		
		Account account2 = new Account();
		account2.setAccountType("Salary Account");
		user.addAccounts(account2);
		
		emOne.persist(user);
		txOne.commit();
		emOne.close();
		
		//Retrieving the User and Account
		EntityManager emTwo = emf.createEntityManager();
		EntityTransaction txTwo = emTwo.getTransaction();
		txTwo.begin();
		User users = (User) emTwo.find(User.class, new Long(1));
		System.out.println("*********************************************");
		System.out.println("*********************************************");
		System.out.println("User name is "+ users.getName());
		Set accounts = user.getAccounts();
		System.out.println("Number of accounts the use holds "+ accounts.size());
		for(Object account : accounts)
			System.out.println("Account Type is "+ ((Account)account).getAccountType());
	
		System.out.println("*********************************************");
		System.out.println("*********************************************");
		txTwo.commit();
		emTwo.close();
		
		emf.close();
		System.out.println("-------Done------");
	}
}
