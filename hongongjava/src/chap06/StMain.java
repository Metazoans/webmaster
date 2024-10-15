package chap06;

public class StMain {

	public static void main(String[] args) {
		// 싱글톤 사용시 객체 생성 불가 -> 메소드 호출해서 객체를 받아와야 함
		
		Singleton st1 = Singleton.getInstance();
		Singleton st2 = Singleton.getInstance();
		
		if(st1 == st2) System.out.println("같은 객체");
		else System.out.println("다른 객체");
		
		st2.name = "거시기";
		System.out.println(st1.name);
		st1.name = "아무개";
		System.out.println(st2.name);
		
		
		
	}

}
