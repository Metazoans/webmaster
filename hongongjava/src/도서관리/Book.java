package 도서관리;

public class Book {
	//필드는 외부 접근 막기 - getter/setter
	private String btitle;
	private String bwriter;
	private int bprice;
	private String bno;
	
	public Book(){};
	public Book(String btitle, String bwriter, int bprice, String bno) {
		this.btitle = btitle;
		this.bwriter = bwriter;
		this.bprice = bprice;
		this.bno = bno;
	}
	
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBwriter() {
		return bwriter;
	}
	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}
	public int getBprice() {
		return bprice;
	}
	public void setBprice(int bprice) {
		this.bprice = bprice;
	}
	public String getBno() {
		return bno;
	}
	public void setBno(String bno) {
		this.bno = bno;
	}
	
	@Override
	public int hashCode() {
		return Integer.parseInt(btitle + bno);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Book) {
			Book b = (Book) obj;
			return (b.btitle.equals(btitle)) && (b.bno.equals(bno));
		}
		return false;
	}
	
	@Override
	public String toString() {
		return btitle + "\t: " + bwriter + "\t: " + bprice + "\t: " + bno;
	}
	
}
