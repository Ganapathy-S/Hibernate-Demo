package com.demo.collections.Bag;

import java.util.Collection;

import org.hibernate.Transaction;
import org.hibernate.Session;

import com.demo.util.HibernateUtil;

public class BagExecutor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Tour tour = new Tour();
		tour.setTouristName("John Trovolto");
		tour.setNumberOfTimesTravelled(3);
		Collection countires = tour.getTravelledCountries();
		countires.add("USA");
		countires.add("Singapore");
		countires.add("USA");
		
		session.save(tour);	
		tx.commit();
		session.close();
		
		Session sessionTwo = HibernateUtil.getSessionFactory().openSession();
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
				
		HibernateUtil.shutdown();
		System.out.println("---------Done-------");
	}

}
