package jpa.com.demo.Set;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import annotation.com.demo.collections.Set.Folder;

public class SetJPAExecutor {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaDemo");

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Folder folder = new Folder();
		folder.setFolderName("Images");
		Set set = folder.getFiles();
		set.add("Himalaya.png");
		set.add("RaceCar.png");
		set.add("Children.png");
		em.persist(folder);
		
		tx.commit();
		em.close();
		
		EntityManager emTwo = emf.createEntityManager();
		EntityTransaction txTwo = emTwo.getTransaction();
		txTwo.begin();
		
		Folder folders = (Folder) emTwo.find(Folder.class, new Long(1));
		System.out.println("**********************************************");
		System.out.println("**********************************************");
		System.out.println("Folder name is "+ folders.getFolderName());
		System.out.println("**********************************************");
		System.out.println("**********************************************");
		Set files = folders.getFiles();
		for(Object file: files)
			System.out.println("File name is "+ file);
		System.out.println("**********************************************");
		System.out.println("**********************************************");
		txTwo.commit();
		emTwo.close();
			
		emf.close();
		System.out.println("----------Done----------");
	}

}
