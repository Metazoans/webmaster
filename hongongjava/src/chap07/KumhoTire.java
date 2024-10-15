package chap07;

public class KumhoTire extends Tire {
	//필드
	
	//생성자
	public KumhoTire(String location, int maxRotation) {
		super(location, maxRotation);
	}
	
	//메소드
	@Override
	public boolean roll() {
		++accRotation;
		if(accRotation < maxRotation) {
			System.out.println(location + " Kumho Tire 수명 : " + (maxRotation - accRotation) + "회");
			return true;
		}
		else {
			System.out.println("***" + location + " Kumho Tire 펑크 ***");
			return false;
		}
	}
}
