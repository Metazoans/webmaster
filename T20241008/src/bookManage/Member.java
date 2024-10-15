package bookManage;

//사용자 정보

public class Member {
	//필드
	private int memberNo;		//사용자 번호
	private String id;			//아이디
	private String password;	//비밀번호
	private String addr;		//주소
	private String tel;			//전화번호
	private String memberType;	//사용자 유형(user, admin)
	private boolean rental;		//대여 권한(true, false)
	private String rentalDate;	//대여 제한 기간
	
	//생성자
	Member() {};
	Member(int memberNo, String id, String password, String addr, String tel) {
		this.memberNo = memberNo;
		this.id = id;
		this.password = password;
		this.addr = addr;
		this.tel = tel;
	}
	Member(int memberNo, String id, String password, String addr, String tel, String memberType, boolean rental, String rentalDate) {
		this(memberNo, id, password, addr, tel);
		this.memberType = memberType;
		this.rental = rental;
		this.rentalDate = rentalDate;
	}
	
	//메소드
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	public boolean getRental() {
		return rental;
	}
	public void setRental(boolean rental) {
		this.rental = rental;
	}
	public String getRentalDate() {
		return rentalDate;
	}
	public void setRentalDate(String rentalDate) {
		this.rentalDate = rentalDate;
	}
	
}
