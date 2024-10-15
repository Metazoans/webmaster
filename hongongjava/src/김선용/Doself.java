package 김선용;

import java.util.Scanner;

public class Doself {

	public static void main(String[] args) {
		//1번 윤년 계산
		System.out.println("[1번] (-1 입력시 종료)");
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("##년도 입력 : ");
			int year = Integer.parseInt(sc.nextLine());

			//강제 종료
			if(year == -1) {
				break;
			}
			
			if((year % 4 == 0) && (year % 100 != 0)) {
				System.out.println(year + "년은 윤년입니다.");
			}
			else if(year % 400 == 0) {
				System.out.println(year + "년은 윤년입니다.");
			}
			else {
				System.out.println(year + "년은 평년입니다.");			
			}
			
		}
		
		//2번 동전 교환
		System.out.println("\n[2번]");
		System.out.print("##교환할 금액 : ");
		int money = Integer.parseInt(sc.nextLine());
		
		int chMoney = 0;
		int m500, m100, m50, m10;
		m500 = m100 = m50 = m10 = 0;
		
		m500 = money / 500;
		chMoney += m500 * 500;
		money %= 500;
		
		m100 = money / 100;
		chMoney += m100 * 100;
		money %= 100;
		
		m50 = money / 50;
		chMoney += m50 * 50;
		money %= 50;
		
		m10 = money / 10;
		chMoney += m10 * 10;
		money %= 10;
		
		System.out.println("500원\t짜리 : " + m500 + "개");
		System.out.println("100원\t짜리 : " + m100 + "개");
		System.out.println("50원\t짜리 : " + m50 + "개");
		System.out.println("10원\t짜리 : " + m10 + "개");
		System.out.println("교환\t금액 : " + chMoney + "원");
		System.out.println("남은\t금액 : " + money + "원");
		
		
		//3번 숫자 추측
		System.out.println("\n[3번] (-1 입력시 종료)");
		int ranNum = (int)(Math.random() * 100) + 1;
		int limit = 10;
		
		while(true) {
			System.out.print("숫자 입력 : ");
			int input = Integer.parseInt(sc.nextLine());
			
			//강제 종료
			if(input == -1) {
				break;
			}
			
			if(ranNum == input) {
				System.out.println("축하합니다!!");
				break;
			}
			else if(ranNum > input) {
				System.out.println("up하세요!!");
			}
			else if(ranNum < input) {
				System.out.println("down하세요!!");
			}
			
			//시도 횟수 제한
			if(--limit == 0) {
				System.out.println("실패했습니다.\n 정답은 : " + ranNum);
				break;
			}
		}
		
		//4번 구구단
		System.out.println("\n[4번]");
		for(int i = 0; i <= 9; i++) {
			for(int j = 2; j <= 9; j++) {
				if(i == 0) {
					System.out.print("  " + j + "단\t");
				}
				else
					System.out.printf("%dx%d=%2d\t", j, i, (j * i));
			}
			System.out.println();
		}
		
		//5번 섭씨 화씨
		System.out.println("\n[5번]");
		boolean run = true;
		
		while(run) {
			//메뉴
			System.out.println("-----------------------------");
			System.out.println("1. 화씨 => 섭씨");
			System.out.println("2. 섭씨 => 화씨");
			System.out.println("3. 종료");
			System.out.println("-----------------------------");
			
			//입력
			System.out.print("▶ 번호 선택 : ");
			int selNum = Integer.parseInt(sc.nextLine());
			int temp;
			double result;
			
			switch(selNum) {
			case 1:
				System.out.print("▶ 화씨 온도 입력 : ");
				temp = Integer.parseInt(sc.nextLine());
				result = 5.0 / 9 * (temp - 32);
				System.out.printf("  섭씨 온도 = %9.6f\n", result);
				break;
			case 2:
				System.out.print("▶ 섭씨 온도 입력 : ");
				temp = Integer.parseInt(sc.nextLine());
				result = 9.0 / 5 * temp + 32;
				System.out.printf("  섭씨 온도 = %9.6f\n", result);
				break;
			case 3:
				System.out.println("program end");
				run = false;
				break;
			default:
				System.out.println("잘못된 선택입니다.");
			}
		}
		
		//6번 가위바위보
		System.out.println("\n[6번]");
		
		while(true) {
			int comp = (int)(Math.random() * 3);
			System.out.print("## 가위(0) 바위(1) 보(2) : ");
			int people = Integer.parseInt(sc.nextLine());
			if(people > 2 || people < 0) {
				System.out.println("game over");
				break;
			}
			
			if(people == comp) {
				System.out.printf("사람 %d, 컴 %d 비겼음\n", people, comp);
			}
			else if (people == (comp + 1) % 3) {
				System.out.printf("사람 %d, 컴 %d 사람 승리\n", people, comp);
			}
			else {
				System.out.printf("사람 %d, 컴 %d 컴 승리\n", people, comp);
			}
		}

		//7번 369게임
		System.out.println("\n[7번]");

		for(int i = 1; i <= 50; i++) {
			String heart = "";
			if((i % 10 != 0) && (i % 10 % 3 == 0)) heart += "♥";
			if((i / 10 != 0) && (i / 10 % 3 == 0)) heart += "♥";
			if(heart.equals("")) heart += i;

			System.out.print(heart + "\t");
			
			if(i % 10 == 0) System.out.println();
		}
		
		
		//7-1 숫자 입력받기
		/*
		System.out.println("\n[7-1]");

		int num = Integer.parseInt(sc.nextLine());
		
		for(int i = 1; i <= num; i++) {
			String heart = "";
			int chNum = i;
			
			while(chNum != 0) {
				if((chNum % 10 != 0) && (chNum % 10 % 3 == 0)) heart += "♥";
				chNum /= 10;
			}
			
			if(heart.equals("")) heart += i;

			System.out.print(heart + "\t");
			
			if(i % 10 == 0) System.out.println();
		}
		*/
		
		sc.close();
		
	}//end main

}//end class
