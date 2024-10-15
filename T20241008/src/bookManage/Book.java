package bookManage;

//책 정보 books

public class Book {
	//책 필드
	private int bookNo;			//책번호
	private String title;		//제목
	private String writer;		//작가
	private String bookType;	//분류
	private String intro;		//책설명
	private int rentalUser;		//대출중인 사용자
	private String rentalDate;	//대출 기간
	
	//생성자
	Book() {};
	Book(int bookNo, String title, String writer, String bookType, String intro) {
		this.bookNo = bookNo;
		this.title = title;
		this.writer = writer;
		this.bookType = bookType;
		this.intro = intro;
	}
	Book(int bookNo, String title, String writer, String bookType, String intro, int rentalUser, String rentalDate) {
		this(bookNo, title, writer, bookType, intro);
		this.rentalUser = rentalUser;
		this.rentalDate = rentalDate;
	}
	
	//메소드
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getBookType() {
		return bookType;
	}
	public void setBookType(String book_type) {
		this.bookType = book_type;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public int getRentalUser() {
		return rentalUser;
	}
	public void setRentalUser(int rentalUser) {
		this.rentalUser = rentalUser;
	}
	public String getRentalDate() {
		return rentalDate;
	}
	public void setRentalDate(String rentalDate) {
		this.rentalDate = rentalDate;
	}
	
	
}
