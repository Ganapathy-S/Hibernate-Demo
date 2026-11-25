package annotation.com.demo.oneToOneUsingForeignKey;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.util.HibernateAnnotationUtil;

public class OneToOneFKAnnotationExecutor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Persisting the User and the Photo
		Session session = HibernateAnnotationUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		User user = new User();
		user.setName("Mohan");
		Photo photo = new Photo();
		photo.setFileName("Image007.png");
		photo.setUser(user);
		user.setPhoto(photo);
		//This will save the user object also as we enabled cascade to "save-update" on photo
		session.save(photo);
		tx.commit();
		session.close();

		//Retrieving the User and the Photo
		Session sessionTwo = HibernateAnnotationUtil.getSessionFactory().openSession();
		Transaction txTwo = sessionTwo.beginTransaction();

		Photo photograph = (Photo)sessionTwo.load(Photo.class, new Long(1));
		User newUser = photograph.getUser();
		System.out.println("********************************************");
		System.out.println("********************************************");
		System.out.println("User Id "+ newUser.getId());
		System.out.println("User Name "+ newUser.getName());
		System.out.println("Photo File Name "+ photograph.getFileName());
		System.out.println("********************************************");
		System.out.println("********************************************");

		txTwo.commit();
		sessionTwo.close();
		HibernateAnnotationUtil.shutdown();

		System.out.println("-------Done------");
	}
}
