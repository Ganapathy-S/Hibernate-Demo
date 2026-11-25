package com.demo.oneToManyUnidirectional;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.util.HibernateUtil;

public class OneToManyUniExecutor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
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
		
		session.save(user);
		session.save(account1);
		session.save(account2);
		session.save(account3);
		tx.commit();
		session.close();
		
		HibernateUtil.shutdown();
		System.out.println("-----Done-----");
	}

}
