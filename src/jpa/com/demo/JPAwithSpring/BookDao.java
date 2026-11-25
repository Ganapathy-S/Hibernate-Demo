package jpa.com.demo.JPAwithSpring;

import java.util.List;

public interface BookDao {
	
	public void saveBook(Books book);
	public Books findBook(long id);
	public List showBooksByName(String bookName);
	public List showAllBooks();
	
}
