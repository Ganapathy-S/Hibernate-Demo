package jpa.com.demo.JPAwithSpring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JpaTemplateExecutor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("jpa/com/demo/JPAwithSpring/SpringForJPA.xml");
		BookDao bookDao = (BookDao) factory.getBean("bookTemplateDao");
		
		String [] bookNames = {"Discovery", "Adventures", "Windows"};
		int [] bookPrices = {1000,1200,1500};
		Books book = null;
		
		for(int i=0; i<bookNames.length;i++){
			book = new Books();
			book.setBookName(bookNames[i]);
			book.setBookPrice(bookPrices[i]);
			bookDao.saveBook(book);
		}
		
		//Retrieving book by id
		System.out.println("**********Retrieving book by Id**************");
		book = bookDao.findBook(new Long(2)); 
		System.out.println("The book at the Id 2 is "+ book.getBookName());
		
		//Retrieving book by name
		System.out.println("**************Retrieving book by name ****************");
		List bookList = bookDao.showBooksByName("Windows");
		for(Object obj: bookList){
			System.out.println("Retrieved book name is "+ ((Books)obj).getBookName());
			System.out.println("The book price is "+ ((Books)obj).getBookPrice());
		}
		
		//Retrieving all the books
		System.out.println("**********Retrieving all the books********************");
		bookList = bookDao.showAllBooks();
		for(Object obj : bookList){
			System.out.println("Retrieved book name is "+ ((Books)obj).getBookName());
			System.out.println("The book price is "+ ((Books)obj).getBookPrice());
		}
		
		System.out.println("-------Done------");
	}
}
