package annotation.com.demo.oneToOneUsingPrimaryKey;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.demo.util.HibernateAnnotationUtil;

public class OneToOnePKAnnotationExecutor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session session =HibernateAnnotationUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		User user = new User();
		user.setName("Miru");
		Address address = new Address();		
		address.setStreet("M.G. Road");
		address.setZipCode("402581");
		address.setCity("Bangalore");
		
		user.setAddress(address);
		address.setUser(user);
		//This will save the address object also as we enabled cascade to "save-update"
		session.save(user);
		tx.commit();
		session.close();
		
		Session sessionTwo =HibernateAnnotationUtil.getSessionFactory().openSession();
		Transaction txTwo = sessionTwo.beginTransaction();
		User firstUser = (User) sessionTwo.load(User.class, new Long(1));
		Address userAddress = firstUser.getAddress();
		System.out.println("********************************************");
		System.out.println("********************************************");
		System.out.println("User name "+ firstUser.getName());
		System.out.println("********** User Address ********************");
		System.out.println("User Street Name "+ userAddress.getStreet());
		System.out.println("User ZipCode "+ userAddress.getZipCode());
		System.out.println("User City "+ userAddress.getCity());
		System.out.println("********************************************");
		System.out.println("********************************************");
		
		txTwo.commit();
		sessionTwo.close();
		HibernateAnnotationUtil.shutdown();
		
		System.out.println("---------Done--------");

	}

}
