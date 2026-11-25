package jpa.com.demo.oneToOneUsingForeignKey;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import annotation.com.demo.oneToOneUsingForeignKey.Photo;
import annotation.com.demo.oneToOneUsingForeignKey.User;

public class OneToOneFKJpaExecutor {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Persisting the User and the Photo
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaDemo");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		User user = new User();
		user.setName("Mohan");
		Photo photo = new Photo();
		photo.setFileName("Image007.png");
		photo.setUser(user);
		user.setPhoto(photo);
		//This will save the user object also as we enabled cascade to "save-update" on photo
		em.persist(photo);
		tx.commit();
		em.close();

		//Retrieving the User and the Photo
		EntityManager emTwo = emf.createEntityManager();
		EntityTransaction txTwo = emTwo.getTransaction();
		txTwo.begin();

		Photo photograph = (Photo)emTwo.find(Photo.class, new Long(1));
		User newUser = photograph.getUser();
		System.out.println("********************************************");
		System.out.println("********************************************");
		System.out.println("User Id "+ newUser.getId());
		System.out.println("User Name "+ newUser.getName());
		System.out.println("Photo File Name "+ photograph.getFileName());
		System.out.println("********************************************");
		System.out.println("********************************************");

		txTwo.commit();
		emTwo.close();
		emf.close();

		System.out.println("-------Done------");
	}

}
