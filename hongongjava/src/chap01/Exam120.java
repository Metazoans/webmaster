package chap01;

import java.util.Scanner;

public class Exam120 {

	public static void main(String[] args) {
		//확인문제 1
		System.out.println("------------문제1--------------");
		
		String name = "감자바";
		int age = 25;
		String tel1="010", tel2="123", tel3="4567";
		
		System.out.println("이름: " + name);
		System.out.print("나이: " + age + "\n");
		System.out.printf("전화: %s-%s-%s\n", tel1, tel2, tel3);
		
		//문제2
		System.out.println("------------문제2--------------");

		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 수 > ");
		String strNum1 = sc.nextLine();

		System.out.print("두 번째 수 > ");
		String strNum2 = sc.nextLine();
		
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		int result = num1 + num2;
		System.out.println("덧셈 결과: " + result);

		//문제3
		System.out.println("------------문제3--------------");
		
		System.out.print("이름 > ");
		String pname3 = sc.nextLine();
		
		String pnum3 = "";
		while(true) {
			System.out.print("주민번호 앞 6자리 > ");
			pnum3 = sc.nextLine();
			
			if(pnum3.length() == 6) break;
			else System.out.println("주민번호 입력 실패");
		}
		
		System.out.print("전화번호 > ");
		String ptel3 = sc.nextLine();
		
		System.out.println("이름: " + pname3);
		System.out.println("주민번호 앞 6자리: " + pnum3);
		System.out.println("전화번호: " + ptel3);
		
		//두수를 입력 받아서 큰수 - 작은 수
		System.out.print("첫 번째 수 입력 > ");
		double inNum1 = Double.parseDouble(sc.nextLine());
		System.out.print("두 번째 수 입력 > ");
		double inNum2 = Double.parseDouble(sc.nextLine());
		
		if(inNum1 > inNum2)
			System.out.printf("%f - %f = %f\n", inNum1, inNum2, (inNum1 - inNum2));
		else
			System.out.printf("%f - %f = %f\n", inNum2, inNum1, (inNum2 - inNum1));
		
		sc.close();
		
	}

}
