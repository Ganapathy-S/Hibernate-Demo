package jpa.com.demo.JPAwithSpring;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation=Propagation.REQUIRES_NEW)
public class BookJpaDaoSupportDaoImpl extends JpaDaoSupport implements BookDao{
	
	public void saveBook(Books book){
		getJpaTemplate().persist(book);
	}
	
	public Books findBook(long id){
		return getJpaTemplate().find(Books.class,id);
	}
	
	public List showBooksByName(String bookName){
		EntityManager em = getJpaTemplate().getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("select b from Books b where b.bookName = ?1");
		query.setParameter(1, bookName);
		return query.getResultList();		
	}
	
	public List showAllBooks(){
		return getJpaTemplate().find("select b from Books b");
	}
}
