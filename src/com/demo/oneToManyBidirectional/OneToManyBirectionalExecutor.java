package com.demo.oneToManyBidirectional;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.demo.util.HibernateUtil;

public class OneToManyBirectionalExecutor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Persisting the User and Account
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		User user = new User();
		user.setName("Suresh Raina");
		
		Account account1 = new Account();
		account1.setAccountType("Savings Account");
		user.addAccounts(account1);
		
		Account account2 = new Account();
		account2.setAccountType("Salary Account");
		user.addAccounts(account2);
		
		session.save(user);
		tx.commit();
		session.close(); 
		
		//Retrieving the User and Account
		Session sessionTwo = HibernateUtil.getSessionFactory().openSession();
		Transaction txTwo = sessionTwo.beginTransaction();
		User users = (User) sessionTwo.load(User.class, new Long(1));
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
		sessionTwo.close();
		
		HibernateUtil.shutdown();
		System.out.println("-------Done------");

	}

}
