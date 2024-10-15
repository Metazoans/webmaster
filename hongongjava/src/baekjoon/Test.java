package baekjoon;

import java.util.List;
import java.util.Scanner;

import 도서관리.Book;
import 도서관리.BookDao;

public class Test {
	static int num = 10;

	public static void main(String[] args) {
		// 짧은 테스트용
		Scanner sc = new Scanner(System.in);
		
		String s = "h";
		int num;
		
		try {
			if(Integer.parseInt(s) > 0) {
				num = Integer.parseInt(s);
				System.out.println(num);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("null");
		
		sc.close();
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
}
