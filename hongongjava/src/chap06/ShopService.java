package chap06;

public class ShopService {
	//싱글톤 기법 사용
	//필드 -> 자신의 객체 저장
	private static ShopService st = new ShopService();
	
	//생성자 -> 외부 접근을 막아야 함
	private ShopService() {};
	
	//메소드 -> 외부로 객체 전달
	static ShopService getInstance() {
		return st;
	}
}
