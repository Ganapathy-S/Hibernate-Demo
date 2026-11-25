package com.demo.collections.Set;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.util.HibernateUtil;

public class SetExecutor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		Folder folder = new Folder();
		folder.setFolderName("Documents");
		Set set = folder.getFiles();
		set.add("DesingDocs");
		set.add("EstimationDocs");
		set.add("ApprovalDocs");
		session.save(folder);
		
		tx.commit();
		session.close();
		
		Session sessionTwo = HibernateUtil.getSessionFactory().openSession();
		Transaction txTwo = sessionTwo.beginTransaction();
		
		Folder folders = (Folder) sessionTwo.load(Folder.class, new Long(1));
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
		sessionTwo.close();
			
		HibernateUtil.shutdown();
		System.out.println("----------Done----------");
	}

}
