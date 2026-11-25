package jpa.com.demo.JPAwithSpring;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BOOKS")
public class Books {

	@Id
	@GeneratedValue
	@Column(name="BOOK_ID")
	private long id;
	
	@Column(name="BOOK_NAME")
	private String bookName;
	
	@Column(name="BOOKD_PRICE")
	private int bookPrice;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
}
