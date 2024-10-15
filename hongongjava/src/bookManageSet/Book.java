package bookManageSet;

public class Book {
	//필드는 외부 접근 막기 - getter/setter
	private String btitle;
	private String bwriter;
	private int bprice;
	private String bno;
	
	
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
	public String toString() {
		return btitle + " : " + bwriter + " : " + bprice + " : " + bno;
	}
	
}
