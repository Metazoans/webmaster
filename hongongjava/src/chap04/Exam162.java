package chap04;

public class Exam162 {

	public static void main(String[] args) {
		//(Math.random() * num1) + num2
		//-> (0*num1)+num2 <= 랜덤 숫자 < (1*num1)+num2 => num2 <= NUM <= (num1+num2)-1
		
		//주사위 두개를 던져서 합이 5가 되면 종료 - game over 출력
		// 5가 아니면 (1,3) 주사위 눈 표시
		//몇번만에 나왔는지 체크
		
		int dice1, dice2;
		int cnt = 0;
		
		while(true) {
			dice1 = (int)(Math.random() * 6) + 1;
			dice2 = (int)(Math.random() * 6) + 1;
			cnt++;
			
			System.out.printf("(%d, %d) ", dice1, dice2);

			if(dice1 + dice2 == 5) break;
		}
		System.out.println("\n몇번 ? " + cnt);
		System.out.println("game over");
		
		
		//주사위 눈이 1이면 1등 ~ 6이면 6등이라고 출력
		int dice = (int)(Math.random() * 6) + 1;
		System.out.println(dice + "등");
		
		System.out.print("if문 : ");
		if(dice == 1) System.out.println("1등");
		else if(dice == 2) System.out.println("2등");
		else if(dice == 3) System.out.println("3등");
		else if(dice == 4) System.out.println("4등");
		else if(dice == 5) System.out.println("5등");
		else if(dice == 6) System.out.println("6등");
		else System.out.println("오류");
		
		System.out.print("switch문 : ");
		switch(dice) {
		case 1: System.out.println("1등"); break;
		case 2: System.out.println("2등"); break;
		case 3: System.out.println("3등"); break;
		case 4: System.out.println("4등"); break;
		case 5: System.out.println("5등"); break;
		case 6: System.out.println("6등"); break;
		default: System.out.println("오류");
		}
		
		
		//50에서 100까지 수를 발생
		//90이상이면 A, 80이상이면 B ... 60이상 D, 나머지 F
		//switch문으로 작성
		int num = (int)(Math.random() * 51) + 50;
		
		System.out.print(num + "점 : ");
		switch(num / 10) {
		case 10:
		case 9 : System.out.println("A"); break;
		case 8 : System.out.println("B"); break;
		case 7 : System.out.println("C"); break;
		case 6 : System.out.println("D"); break;
		default: System.out.println("F");
		}
		
		
	}

}
