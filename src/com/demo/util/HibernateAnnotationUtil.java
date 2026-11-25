package com.demo.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * 
 * @author Augustine
 * This class is meant for persisting using Annotations. It is not required to use a seperate configuration file
 * for annotation. But here we use it to avoid the hibernate mapping using XML files (*.hbm.xml).
 *
 */
public class HibernateAnnotationUtil {

	private static SessionFactory sessionFactory;
	static {
		try {
			AnnotationConfiguration cfg = new AnnotationConfiguration();
			cfg.addAnnotatedClass(annotation.com.demo.helloworld.Hello.class);
			cfg.addAnnotatedClass(annotation.com.demo.oneToOneUsingPrimaryKey.User.class);
			cfg.addAnnotatedClass(annotation.com.demo.oneToOneUsingPrimaryKey.Address.class);
			cfg.addAnnotatedClass(annotation.com.demo.oneToOneUsingForeignKey.User.class);
			cfg.addAnnotatedClass(annotation.com.demo.oneToOneUsingForeignKey.Photo.class);
			cfg.addAnnotatedClass(annotation.com.demo.oneToOneUsingJoingTable.Person.class);
			cfg.addAnnotatedClass(annotation.com.demo.oneToOneUsingJoingTable.Passport.class);
			cfg.addAnnotatedClass(annotation.com.demo.collections.Set.Folder.class);
			cfg.addAnnotatedClass(annotation.com.demo.collections.List.TeamLeader.class);
			cfg.addAnnotatedClass(annotation.com.demo.collections.Bag.Tour.class);
			cfg.addAnnotatedClass(annotation.com.demo.collections.Map.Exam.class);
			cfg.addAnnotatedClass(annotation.com.demo.components.Customers.class);
			cfg.addAnnotatedClass(annotation.com.demo.components.Address.class);
			cfg.addAnnotatedClass(annotation.com.demo.collectionOfComponents.Recruitment.class);
			cfg.addAnnotatedClass(annotation.com.demo.collectionOfComponents.Candidate.class);
			cfg.addAnnotatedClass(annotation.com.demo.oneToManyUnidirectional.Account.class);
			cfg.addAnnotatedClass(annotation.com.demo.oneToManyUnidirectional.User.class);
			cfg.addAnnotatedClass(annotation.com.demo.oneToManyBidirectional.Account.class);
			cfg.addAnnotatedClass(annotation.com.demo.oneToManyBidirectional.User.class);
			cfg.addAnnotatedClass(annotation.com.demo.oneToManyUsingJoingTable.Buyer.class);
			cfg.addAnnotatedClass(annotation.com.demo.oneToManyUsingJoingTable.Property.class);
			cfg.addAnnotatedClass(annotation.com.demo.manyToManyUnidirectional.Student.class);
			cfg.addAnnotatedClass(annotation.com.demo.manyToManyUnidirectional.Course.class);
			cfg.addAnnotatedClass(annotation.com.demo.manyToManyBidirectioinal.Student.class);
			cfg.addAnnotatedClass(annotation.com.demo.manyToManyBidirectioinal.Course.class);

			sessionFactory=cfg.configure("annotation.hibernate.cfg.xml").buildSessionFactory();
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}

}
