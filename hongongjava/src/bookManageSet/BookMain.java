package bookManageSet;

import java.util.Scanner;

public class BookMain {
	public static void main(String[] args) {
		//1.도서등록 2.도서검색 3.도서전체 조회 4.도서삭제 5.도서 정보 변경 6. 종료
		Scanner sc = new Scanner(System.in);
		
		BookDao bdao = new BookDao();
		bdao.startConn();
		
		String btitle, bwriter, bno;
		int bprice;
		
		boolean run = true;
		while(run) {
			prtMenu(0);
			String menuNum = sc.nextLine();
			
			switch(menuNum) {
			case "1":	//등록
				prtMenu(1);
				
				System.out.print("제목 > ");
				btitle = sc.nextLine();
				System.out.print("작가 > ");
				bwriter = sc.nextLine();
				System.out.print("가격 > ");
				bprice = Integer.parseInt(sc.nextLine());
				System.out.print("번호 > ");
				bno = sc.nextLine();
				
				bdao.bookInsert(btitle, bwriter, bprice, bno);
				break;
			case "2":	//조건 검색
				prtMenu(2);
				
				System.out.print("제목 > ");
				btitle = sc.nextLine();
				
				bdao.bookSelect(btitle);
				break;
			case "3":	//전체 검색
				prtMenu(3);
				
				bdao.allSelect();
				
				break;
			case "4":	//삭제
				prtMenu(4);
				
				System.out.print("번호 > ");
				bno = sc.nextLine();
				
				bdao.bookDelete(bno);
				
				break;
			case "5":	//갱신
				prtMenu(5);
				
				System.out.print("제목 > ");
				btitle = sc.nextLine();
				System.out.print("가격 > ");
				bprice = Integer.parseInt(sc.nextLine());
				System.out.print("번호 > ");
				bno = sc.nextLine();
				
				bdao.bookUpdate(btitle, bprice, bno);
				
				break;
			case "6":	//종료
				prtMenu(6);
				run = false;
				break;
			default:
				System.out.println("잘못된 선택입니다.");
			}
			
		}
		bdao.endConn();
		
	} // end main
	static void prtMenu(int n) {
		switch(n) {
		case 0:
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("1.도서등록 | 2.도서검색 | 3.도서전체 조회 | 4.도서삭제 | 5.도서 정보 변경 | 6. 종료");
			System.out.println("---------------------------------------------------------------------------");
			System.out.print("메뉴 선택 > ");
			break;
		case 1:
			System.out.println("-------------");
			System.out.println("도서등록");
			System.out.println("-------------");
			break;
		case 2:
			System.out.println("-------------");
			System.out.println("도서검색");
			System.out.println("-------------");
			break;
		case 3:
			System.out.println("-------------");
			System.out.println("도서전체 조회");
			System.out.println("-------------");
			break;
		case 4:
			System.out.println("-------------");
			System.out.println("도서삭제");
			System.out.println("-------------");
			break;
		case 5:
			System.out.println("-------------");
			System.out.println("도서 정보 변경");
			System.out.println("-------------");
			break;
		case 6:
			System.out.println("-------------");
			System.out.println("프로그램 종료");
			System.out.println("-------------");
			break;
		}
	}
	
	
} // end class
