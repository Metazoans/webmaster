package chap06;

public class Book {
	//도서 객체 생성 class
	//책제목, 도서번호, 도서 가격
	//외부 필드 접근 막고 getter,setter
	
	//필드
	private String bookName;
	private int bookNo;
	private int bookPrice;
	
	//생성자
	Book(){}
	Book(String bookName, int bookNo, int bookPrice) {
		this.bookName = bookName;
		this.bookNo = bookNo;
		this.bookPrice = bookPrice;
	}
	
	
	//메소드
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		if(bookNo < 0) { 
			this.bookNo = -1;
			return;
		}
		this.bookNo = bookNo;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		if(bookPrice < 0) {
			this.bookPrice = -1;
			return;
		}
		this.bookPrice = bookPrice;
	}
}
