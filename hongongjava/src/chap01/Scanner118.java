package chap01;

import java.util.Scanner;

public class Scanner118 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String strin;
		
		//문자열
		System.out.print("문자열 입력 > ");
		strin = sc.nextLine();
		System.out.println("입력 받은 문자열 : " + strin);
		
		if(strin == "q") {
			System.out.println("q 입력 됨");
		} else {
			System.out.println("같지 않음");
		}
		
		if(strin.equals("q")) {
			System.out.println("q 입력 됨");
		} else {
			System.out.println("같지 않음");
		}
		
		//숫자
		System.out.print("숫자 입력 > ");
		int valInt = sc.nextInt();
		System.out.println("입력 숫자 : " + valInt);
		strin = sc.nextLine();	//숫자 입력 후 남은 공백을 없애는 작업
		
		System.out.print("숫자 입력 > ");
		valInt = Integer.parseInt(sc.nextLine());
		System.out.println("입력 받은 숫자 + 100 : " + (valInt + 100));
		
		sc.close();
		
		//String 변수에 바로 데이터를 입력하면 같은 데이터는 같은 주소를 가지게 됨(new String으로 생성시 주소 변경)
		String s1 = new String("abc");
		String s2 = new String("abc");
		if(s1 == s2) {
			System.out.println("s1 == s2");
		} else {
			System.out.println("s1 != s2");
		}
		
		
		
		
	}//end main

}//end class
