package annotation.com.demo.collections.Set;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.util.HibernateAnnotationUtil;

public class SetAnnotationExecutor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session session = HibernateAnnotationUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		Folder folder = new Folder();
		folder.setFolderName("Images");
		Set set = folder.getFiles();
		set.add("Himalaya.png");
		set.add("RaceCar.png");
		set.add("Children.png");
		session.save(folder);
		
		tx.commit();
		session.close();
		
		Session sessionTwo = HibernateAnnotationUtil.getSessionFactory().openSession();
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
			
		HibernateAnnotationUtil.shutdown();
		System.out.println("----------Done----------");
	}

}
