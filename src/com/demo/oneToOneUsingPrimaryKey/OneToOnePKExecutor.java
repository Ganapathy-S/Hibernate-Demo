package com.demo.oneToOneUsingPrimaryKey;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.demo.util.HibernateUtil;

/**
 * 
 * @author Augustine
 * This class explains the one-to-one association using primary key.
 * Here the primary key of the User table is also the primary key of the 
 * Address table.
 */

public class OneToOnePKExecutor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session session =HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		User user = new User();
		user.setName("Jacob");
		Address address = new Address();		
		address.setStreet("M.G. Street");
		address.setZipCode("600001");
		address.setCity("Chennai");
		
		user.setAddress(address);
		address.setUser(user);
		//This will save the address object also as we enabled cascade to "save-update"
		session.save(user);
		tx.commit();
		session.close();
		
		Session sessionTwo =HibernateUtil.getSessionFactory().openSession();
		Transaction txTwo = sessionTwo.beginTransaction();
		User firstUser = (User) sessionTwo.load(User.class, new Long(1));
		System.out.println("********************************************");
		System.out.println("********************************************");
		System.out.println("User name "+ firstUser.getName());
		System.out.println("********** User Address ********************");
		Address userAddress = user.getAddress();
		System.out.println("User Street Name "+ userAddress.getStreet());
		System.out.println("User ZipCode "+ userAddress.getZipCode());
		System.out.println("User City "+ userAddress.getCity());
		System.out.println("********************************************");
		System.out.println("********************************************");
		
		txTwo.commit();
		sessionTwo.close();
		HibernateUtil.shutdown();
		
		System.out.println("---------Done--------");
	}

}
