package annotation.com.demo.collections.Bag;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.util.HibernateAnnotationUtil;

public class BagAnnotationExecutor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session session = HibernateAnnotationUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Tour tour = new Tour();
		tour.setTouristName("Richardson");
		tour.setNumberOfTimesTravelled(3);
		Collection countires = tour.getTravelledCountries();
		countires.add("Malaysia");
		countires.add("Malaysia");
		countires.add("Hong Kong");
		
		session.save(tour);	
		tx.commit();
		session.close();
		
		Session sessionTwo = HibernateAnnotationUtil.getSessionFactory().openSession();
		Transaction txTwo = sessionTwo.beginTransaction();
		Tour tours = (Tour) sessionTwo.load(Tour.class, new Long(1));
		System.out.println("*****************************************");
		System.out.println("*****************************************");
		System.out.println("Tourist name is  "+ tours.getTouristName() );
		System.out.println("Number of times Travelled = "+ tours.getNumberOfTimesTravelled());
		System.out.println("*****************************************");
		System.out.println("*****************************************");
		Collection countries = tours.getTravelledCountries();
		for(Object country: countires)
			System.out.println("Name of the country is "+ country);
		txTwo.commit();
		sessionTwo.close();
				
		HibernateAnnotationUtil.shutdown();
		System.out.println("---------Done-------");
	}

}
