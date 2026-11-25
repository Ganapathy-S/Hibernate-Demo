package jpa.com.demo.JPAwithSpring;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation=Propagation.REQUIRES_NEW)
public class BookJpaTemplateDaoImpl implements BookDao {
	
	JpaTemplate jpaTempate;

	public void setJpaTempate(JpaTemplate jpaTempate) {
		this.jpaTempate = jpaTempate;
	}
	
	public void saveBook(Books book){
		jpaTempate.persist(book);
	}
	
	public Books findBook(long id){
		return jpaTempate.find(Books.class,id);
	}
	
	public List showBooksByName(String bookName){
		EntityManager em = jpaTempate.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("select b from Books b where b.bookName = ?1");
		query.setParameter(1, bookName);
		return query.getResultList();	
	}
	
	public List showAllBooks(){
		return jpaTempate.find("select b from Books b");
	}
}
