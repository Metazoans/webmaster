package chap06;

import java.util.Scanner;

public class BookMain {
	public static void main(String[] args) {
		//도서관리 main
		//메뉴 1 . 도서 수 입력 2.도서 입력 3.도서목록 조회 4. 도서분석 5.종료
		//도서수만큼 배열 생성 -> 도서 객체 저장
		//메뉴 항목 선택 1 => 도서 수 입력
		//			  2 => 도서 객체 생성 배열에 저장
		//			  3 => 도서 목록 출력
		//			  4 => 도서 평균 가격, 최대가격 출력
		//			  5 => 종료
		
		//객체 생성
		Scanner sc = new Scanner(System.in);
		Book[] bArr = null;
		
		//메뉴 반복
		boolean run = true;
		while(run) {
			System.out.println("----------------------------------------------------------");
			System.out.println("1.도서 수 입력 2.도서 입력 3.도서목록 조회 4.도서분석 5.종료");
			System.out.println("----------------------------------------------------------");
			System.out.print("메뉴 선택 > ");
			int selNo = Integer.parseInt(sc.nextLine());
			
			switch(selNo) {
			case 1: //도서 수 입력
				System.out.print("도서 수 입력 > ");
				int bNum = Integer.parseInt(sc.nextLine());
				if(bNum > 0) {
					bArr = new Book[bNum];
				}
				else {
					System.out.println("잘못된 값 입력됨");
				}
				break;
			case 2: //도서 객체 생성, 배열에 저장 for문 으로 전부 집어넣기
				//향상된 for문을 이용하면 배열의 내용을 건드리는 것이 아니라 가져온 값만 건드려서 입력이 불가능(인덱스 개념이 없음)
				/*
				for(int i = 0; i < bArr.length; i++) {
					bArr[i] = new Book();
					
					System.out.println((i + 1) + "번째 도서 입력");
					System.out.print("도서 제목 입력 > ");
					String bName = sc.nextLine();
					System.out.print("도서 번호 입력 > ");
					int bNo = Integer.parseInt(sc.nextLine());
					System.out.print("도서 가격 입력 > ");
					int bPrice = Integer.parseInt(sc.nextLine());

					bArr[i].setBookName(bName);
					bArr[i].setBookNo(bNo);
					bArr[i].setBookPrice(bPrice);
				}
				*/
				for(int i = 0; i < bArr.length; i++) {
					System.out.println((i + 1) + "번째 도서 입력");
					System.out.print("도서 제목 입력 > ");
					String bName = sc.nextLine();
					System.out.print("도서 번호 입력 > ");
					int bNo = Integer.parseInt(sc.nextLine());
					System.out.print("도서 가격 입력 > ");
					int bPrice = Integer.parseInt(sc.nextLine());
					
					bArr[i] = new Book(bName, bNo, bPrice);
				}
				break;
			case 3: //도서 목록 출력
				for(Book b : bArr) {
					System.out.printf("%s\t%d\t%d\n", b.getBookName(), b.getBookNo(), b.getBookPrice());
				}
				break;
			case 4: //도서 평균 가격, 최대 가격 출력
				int sum = 0;
				int max = Integer.MIN_VALUE;
				int min = Integer.MAX_VALUE;
				String title = null;
				for(Book b : bArr) {
					sum += b.getBookPrice();
					if(max < b.getBookPrice()) {
						max = b.getBookPrice();
						title = b.getBookName();
					}
					if(min > b.getBookPrice()) min = b.getBookPrice();
				}
				
				System.out.printf("평균 : %f, 최대 가격 : %d, 최소 가격 : %d\n", ((double)sum / bArr.length), max, min);
				System.out.println("가장 비싼 책 : " + title);
				break;
			case 5: //종료
				run = false;
				break;
			}
		}
		System.out.println("프로그램 종료");
		
		
		sc.close();
	}
}
