package com.demo.oneToOneUsingForeignKey;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.util.HibernateUtil;

public class OneToOneFKExecutor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Persisting the User and the Photo
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		User user = new User();
		user.setName("Arjun");
		Photo photo = new Photo();
		photo.setFileName("Image001.jpg");
		photo.setUser(user);
		user.setPhoto(photo);
		//This will save the user object also as we enabled cascade to "save-update" on photo
		session.save(photo);
		tx.commit();
		session.close();
		
		
		//Retrieving the User and the Photo
		Session sessionTwo = HibernateUtil.getSessionFactory().openSession();
		Transaction txTwo = sessionTwo.beginTransaction();
		
		Photo photograph = (Photo)sessionTwo.load(Photo.class, new Long(1));
		System.out.println("********************************************");
		System.out.println("********************************************");
		System.out.println("User Id "+ photograph.getUser().getId());
		System.out.println("User Name "+ photograph.getUser().getName());
		System.out.println("Photo File Name "+ photograph.getFileName());
		System.out.println("********************************************");
		System.out.println("********************************************");
		
		txTwo.commit();
		sessionTwo.close();
		HibernateUtil.shutdown();
		
		
		System.out.println("--------Done-------");
	}

}
