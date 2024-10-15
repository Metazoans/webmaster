package bookManage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookMain {
	static Scanner sc = new Scanner(System.in);
	
	static int start = 0;
	static int end = 5;
	
	//도서 목록 출력
	public static int prtBook(Member m, int back) {
		BookDAO bdao = new BookDAO();
		
		List<Book> b = null;
		
		int run = 1;
		while(run == 1) {
			b = bdao.allBook();
			
			System.out.println("\n\n");
			System.out.println("===================================================================");
			System.out.println("============================  도서 목록  ============================");
			if(m != null) System.out.println("           로그아웃(o)         메인메뉴(h)         프로그램 종료(q)       ");
			else System.out.println("                 메인메뉴(h)               프로그램 종료(q)             ");
			System.out.println("===================================================================");
			System.out.println("-------------------------------------------------------------------");
			System.out.println("번호\t제목\t\t\t작가\t    대여상태\t대여 기간");
			System.out.println("-------------------------------------------------------------------");
			
			//도서 목록 출력 5개
			for(int i = start; i <= end; i++) {
				String rState = (b.get(i).getRentalDate() == null) ? "대여 가능" : "대여 불가";
				String date = b.get(i).getRentalDate() == null ? " " : b.get(i).getRentalDate();
				System.out.printf("%d\t%s\t\t\t%s\t    %s\t%s\n", b.get(i).getBookNo(), b.get(i).getTitle(), b.get(i).getWriter(), rState, date);
				if((i+1) == b.size()) break;
			}
			
			//도서 목록 하단 메뉴
			System.out.println();
			System.out.println("-------------------------------------------------------------------");
			System.out.printf("  이전페이지(-)  [%d/%d]  다음페이지(+)     대출(r)  선택(번호)  뒤로가기(b)  \n", (start / 5 + 1), (int)Math.ceil(b.size()/5.0));
			System.out.println("-------------------------------------------------------------------");
			System.out.print("선택 >> ");
			String select = sc.nextLine();
			
			switch(select) {
			case "-":
				if(start >= 5) {
					start -= 5;
					end = start + 5;
				}
				break;
			case "+":
				if(end < b.size()) {
					start += 5;
					end = start + 5;
				}
				break;
			case "r":
				System.out.print("번호 입력 >> ");
				int bno = Integer.parseInt(sc.nextLine());
				int result = UserMain.rtBook(bno, m);
				
				if(result == 1)  System.out.println("도서 대출 완료");
				break;
				
			//공통 메뉴
			case "o":
				if(m != null) return 0;
				break;
			case "h":
				if(m == null) return 0;
				if(m.getMemberType().equals("user")) return 4;
				else if(m.getMemberType().equals("admin")) return 5;
			case "q": return -1;
			case "b": return back;
			}

			try {
				if(Integer.parseInt(select) > 0) {
					//select가 0이상의 숫자면 해당 번호의 책 검색
					run = bookDetail(bdao.searchBook("book_no", select), m, run);
				}
			} catch (Exception e) {}
		}
		return run;
	}
	
	//도서 검색
	public static int srchCase(Member m, int back) {
		BookDAO bdao = new BookDAO();
		
		int run = 2;
		while(run == 2) {
			Book result = null;
			List<Book> blist = new ArrayList<>();
			
			System.out.println("\n\n");
			System.out.println("===================================================================");
			System.out.println("============================  도서 검색  ============================");
			if(m != null) System.out.println("           로그아웃(o)         메인메뉴(h)         프로그램 종료(q)       ");
			else System.out.println("                 메인메뉴(h)               프로그램 종료(q)             ");
			System.out.println("===================================================================");
			System.out.println("-------------------------------------------------------------------");
			System.out.println("   1.도서 번호 검색    2.제목 검색    3.작가 검색    4.분류 검색    5.취소   ");
			System.out.println("-------------------------------------------------------------------");
			System.out.print("검색 방법 선택 >> ");
			String n = sc.nextLine();
			
			switch(n) {
			//공통 메뉴
			case "o":
				if(m != null) return 0;
				break;
			case "h":
				if(m == null) return 0;
				if(m.getMemberType().equals("user")) return 4;
				else if(m.getMemberType().equals("admin")) return 5;
			case "q": return -1;
			case "5": return back;
			}
			
			System.out.print("검색 내용 입력 >> ");
			String srch = sc.nextLine();
			if(srch.equals("5")) return back;
			
			switch(n) {
			case "1":
				result = bdao.searchBook("book_no", srch);
				break;
			case "2":
				blist = bdao.searchList("title", srch);
				break;
			case "3":
				blist = bdao.searchList("writer", srch);
				break;
			case "4":
				blist = bdao.searchList("book_type", srch);
				break;
			default:
				System.out.println("검색 오류");
			}
			if(result != null) run = bookDetail(result, m, run);
			if(blist.size() != 0) run = prtBookList(blist, m, run);
		}
		
		return run;
	}
	
	//도서 검색 리스트 출력
	//도서 목록 출력
	public static int prtBookList(List<Book> b, Member m, int back) {
		BookDAO bdao = new BookDAO();
		
		int run = 21;
		while(run == 21) {
			System.out.println("\n\n");
			System.out.println("===================================================================");
			System.out.println("============================  도서 목록  ============================");
			if(m != null) System.out.println("           로그아웃(o)         메인메뉴(h)         프로그램 종료(q)       ");
			else System.out.println("                 메인메뉴(h)               프로그램 종료(q)             ");
			System.out.println("===================================================================");
			System.out.println("-------------------------------------------------------------------");
			System.out.println("번호\t제목\t\t\t작가\t    대여상태\t대여 기간");
			System.out.println("-------------------------------------------------------------------");
			
			//도서 목록 출력 5개
			for(int i = start; i <= end; i++) {
				String rState = (b.get(i).getRentalDate() == null) ? "대여 가능" : "대여 불가";
				String date = b.get(i).getRentalDate() == null ? " " : b.get(i).getRentalDate();
				System.out.printf("%d\t%s\t\t\t%s\t    %s\t%s\n", b.get(i).getBookNo(), b.get(i).getTitle(), b.get(i).getWriter(), rState, date);
				if((i+1) == b.size()) break;
			}
			
			//도서 목록 하단 메뉴
			System.out.println();
			System.out.println("-------------------------------------------------------------------");
			System.out.printf("  이전페이지(-)  [%d/%d]  다음페이지(+)     대출(r)  선택(번호)  뒤로가기(b)  \n", (start / 5 + 1), (int)Math.ceil(b.size()/5.0));
			System.out.println("-------------------------------------------------------------------");
			System.out.print("선택 >> ");
			String select = sc.nextLine();
			
			switch(select) {
			case "-":
				if(start >= 5) {
					start -= 5;
					end = start + 5;
				}
				break;
			case "+":
				if(end < b.size()) {
					start += 5;
					end = start + 5;
				}
				break;
			case "r":
				System.out.print("번호 입력 >> ");
				int bno = Integer.parseInt(sc.nextLine());
				int result = UserMain.rtBook(bno, m);
				
				if(result == 1)  System.out.println("도서 대출 완료");
				break;
				
			//공통 메뉴
			case "o":
				if(m != null) return 0;
				break;
			case "h":
				if(m == null) return 0;
				if(m.getMemberType().equals("user")) return 4;
				else if(m.getMemberType().equals("admin")) return 5;
			case "q": return -1;
			case "b": return back;
			}

			try {
				if(Integer.parseInt(select) > 0) {
					//select가 0이상의 숫자면 해당 번호의 책 검색
					run = bookDetail(bdao.searchBook("book_no", select), m, run);
				}
			} catch (Exception e) {}
		}
		return run;
	}
	
	//도서 상세 내용 출력
	public static int bookDetail(Book b, Member m, int back) {
		int run = 3;
		while(run == 3) {
			System.out.println("\n\n");
			System.out.println("===================================================================");
			System.out.println("============================  도서 정보  ============================");
			if(m != null) System.out.println("           로그아웃(o)         메인메뉴(h)         프로그램 종료(q)       ");
			else System.out.println("                 메인메뉴(h)               프로그램 종료(q)             ");
			System.out.println("===================================================================");
			
			System.out.println();
			System.out.println("번호\t: " + b.getBookNo());
			System.out.println("제목\t: " + b.getTitle());
			System.out.println("작가\t: " + b.getWriter());
			System.out.println("분류\t: " + b.getBookType());
			System.out.println("소개글\t: " + b.getIntro());
			String rental = (b.getRentalDate() != null) ? b.getRentalUser() + " 대출중" : "대출 가능";
			System.out.println("대출 상태\t: " + rental);
			if(b.getRentalDate() != null) {
				System.out.println("대여 기간\t: " + b.getRentalDate());
			}
			
			System.out.println();
			System.out.println("-------------------------------------------------------------------");
			System.out.println("도서대출(r)\t도서검색(s)\t도서목록(l)\t뒤로가기(b)");
			System.out.println("-------------------------------------------------------------------");
			
			System.out.print("선택 >> ");
			String select = sc.nextLine();
			
			switch(select) {
			case "r":
				UserMain.rtBook(b.getBookNo(), m);
				break;
			case "s":
				run = srchCase(m, run);
				break;
			case "l":
				run = prtBook(m, run);
				break;
				
			//공통 메뉴
			case "o":
				if(m != null) return 0;
				break;
			case "h":
				if(m == null) return 0;
				if(m.getMemberType().equals("user")) return 4;
				else if(m.getMemberType().equals("admin")) return 5;
			case "q": return -1;
			case "b": return back;
			}
		}
		
		return run;
	} // end bookDetail
	
	
	
}
