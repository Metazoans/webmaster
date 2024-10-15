package chap04;

import java.util.Scanner;

public class Exam182 {

	public static void main(String[] args) {
		//4번
		for(int x = 1; x <= 10; x++) {
			for(int y = 1; y <= 10; y++) {
				int result = (4 * x) + (5 * y);
				if(result == 60) {
					System.out.printf("(%d, %d) ", x, y);
				}
			}
		}
		System.out.println();
		
		//5번
		System.out.println("\n------------------------------------------");
		System.out.println("[5-1]");
		for(int i = 1; i <= 4; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		//for문 하나로 작성
		System.out.println("\n------------------------------------------");
		System.out.println("[5-2]");
		
		String star1 = "";
		for(int i = 1; i <= 4; i++) {
			star1 += "*";
			System.out.println(star1);
		}

		//6번
		System.out.println("\n------------------------------------------");
		System.out.println("[6-1]");
		for(int i = 1; i <= 4; i++) {
			int blank = 4 - i;
			for(int j = 1; j <= blank; j++) {
				System.out.print(" ");
			}
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("\n------------------------------------------");
		System.out.println("[6-2]");
		for(int i = 1; i <= 4; i++) {
			int blank = 4 - i;
			for(int j = 1; j <= 4; j++) {
				if(blank-- > 0) System.out.print(" ");
				else System.out.print("*");
			}
			System.out.println();
		}
		
		//for문 하나로 작성
		System.out.println("\n------------------------------------------");
		System.out.println("[6-3]");
		String star2 = "";
		for(int i = 1; i <= 4; i++) {
			star2 += "*";
			System.out.printf("%4s\n", star2);
		}
		
		//7번
		System.out.println("\n------------------------------------------");
		System.out.println("[7번]");
		
		boolean run = true;
		int balance = 0;
		Scanner sc = new Scanner(System.in);

		
		while(run) {
			System.out.println("-------------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-------------------------------------");
			
			System.out.print("선택> ");
			int selNo = Integer.parseInt(sc.nextLine());
			
			switch(selNo) {
			case 1: 
				System.out.print("예금액>");
				int depo = Integer.parseInt(sc.nextLine());
				
				if(depo < 0) {
					System.out.println("잘못된 금액 입력");
					break;
				}
				
				balance += depo;
				break;
			case 2:
				System.out.print("출금액>");
				int withd = Integer.parseInt(sc.nextLine());
				
				if(withd < 0) {
					System.out.println("잘못된 금액 입력");
					break;
				}
				if(balance < withd) {
					System.out.println("잔액 부족");
					System.out.println("출금가능액 : " + balance);
					break;
				}
				
				balance -=  withd;
				break;
			case 3:
				System.out.print("잔고>" + balance + "\n");
				break;
			case 4:
				System.out.println("\n프로그램 종료");
				run = false;
				break;
			default:
				System.out.println("잘못된 선택입니다");
			}

			System.out.println();
		}
		
		sc.close();
		
	}//end main

}//end class
