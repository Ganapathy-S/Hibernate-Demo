package annotation.com.demo.components;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.util.HibernateAnnotationUtil;

public class ComponentAnnotationExecutor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session session =HibernateAnnotationUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		Address homeAddress = new Address();
		homeAddress.setCity("Chennai");
		homeAddress.setStreet("MG Street");
		homeAddress.setZipCode("600505");

		Address billingAddress = new Address();
		billingAddress.setCity("Hydrabad");
		billingAddress.setStreet("Indira Street");
		billingAddress.setZipCode("800808");

		Customers customer = new Customers();
		customer.setName("Augustine");
		customer.setHomeAddress(homeAddress);
		customer.setBillingAddress(billingAddress);
		session.save(customer);

		tx.commit();
		session.close();
		HibernateAnnotationUtil.shutdown();

		System.out.println("--------Done-------");

	}

}
