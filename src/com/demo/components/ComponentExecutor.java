package com.demo.components;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.demo.util.HibernateUtil;

public class ComponentExecutor {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session session =HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		Address homeAddress = new Address();
		homeAddress.setCity("Chennai");
		homeAddress.setStreet("Gandhi Street");
		homeAddress.setZipCode("600001");

		Address billingAddress = new Address();
		billingAddress.setCity("Bangalore");
		billingAddress.setStreet("Nehru");
		billingAddress.setZipCode("400001");

		Customers customer = new Customers();
		customer.setName("Augustine");
		customer.setHomeAddress(homeAddress);
		customer.setBillingAddress(billingAddress);
		session.save(customer);

		tx.commit();
		session.close();
		HibernateUtil.shutdown();

		System.out.println("--------Done-------");
	}

}
