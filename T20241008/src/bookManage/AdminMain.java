package bookManage;

import java.util.List;
import java.util.Scanner;

public class AdminMain {
static Scanner sc = new Scanner(System.in);
	
	static int start = 0;
	static int end = 5;
	
	public static int adminMain(Member m) {
		//사용자 메뉴
		String selNo = "";
		int run = 5;
		while(run == 5) {
			System.out.println("\n\n");
			System.out.println("===================================================================");
			System.out.println("===========================  관리자 메뉴  ===========================");
			System.out.println("===================================================================");
			System.out.println("                 로그아웃(o)               프로그램 종료(q)             ");
			System.out.println("===================================================================");
			System.out.println("-------------------------------------------------------------------");
			System.out.println("  1.사용자목록   2.도서목록   3.도서검색   4.도서관리    ");
			System.out.println("-------------------------------------------------------------------");
			System.out.print("선택 >> ");
			selNo = sc.nextLine();
			
			switch(selNo) {
			case "1":
				run = prtMember(m, run);
				break;
			case "2":
				run = BookMain.prtBook(m, run);
				break;
			case "3":
				run = BookMain.srchCase(m, run);
				break;
			case "4":
				run = bookManage(m, run);
				break;
			
			//공통 메뉴
			case "o": return 0;
			case "q": return -1;
			}
		}
		
		return run;
	} //end userMain
	
	//유저 목록 출력
	public static int prtMember(Member m, int back) {
		MemberDAO mdao = new MemberDAO();
		List<Member> l = null;
		
		int run = 51;
		while(run == 51) {
			l = mdao.allMember();
			System.out.println("\n\n");
			System.out.println("===================================================================");
			System.out.println("===========================  사용자 목록  ===========================");
			System.out.println("===================================================================");
			System.out.println("           로그아웃(o)         메인메뉴(h)         프로그램 종료(q)       ");
			System.out.println("===================================================================");
			System.out.println("-------------------------------------------------------------------");
			System.out.println("회원번호\t아이디\t회원권한\t대출권한\t제한기간");
			System.out.println("-------------------------------------------------------------------");
			
			//유저 목록 출력 5개
			for(int i = start; i < end; i++) {
				String rental = l.get(i).getRental() ? "O" : "X";
				String date = l.get(i).getRentalDate() == null ? " " : l.get(i).getRentalDate();
				System.out.printf("%d\t%s\t%s\t%s\t%s\n", l.get(i).getMemberNo(), l.get(i).getId(), l.get(i).getMemberType(), rental, date);
				if((i+1) == l.size()) break;
			}
			
			//유저 목록 하단 메뉴
			System.out.println();
			System.out.println("-------------------------------------------------------------------");
			System.out.printf(" 이전페이지(-) [%d/%d] 다음페이지(+)   선택(번호) 갱신(u) 삭제(d) 뒤로가기(b) \n", (start / 5 + 1), (int)Math.ceil(l.size()/5.0)); //나눈값을 올림
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
				if(end < l.size()) {
					start += 5;
					end = start + 5;
				}
				break;
			case "u": //사용자 갱신
				System.out.println("[사용자 권한 변경]");
				System.out.print("변경할 회원 번호 입력 >> ");
				String uno = sc.nextLine();
				System.out.print("선택(1.회원권한 2.대출권한 3.모든권한) >> ");
				String selUdt = sc.nextLine();
				
				switch(selUdt) {
				case "1":
					mdao.userAuth("member_type", mdao.searchMember(uno));
					break;
				case "2":
					mdao.userAuth("rental", mdao.searchMember(uno));
					break;
				case "3":
					mdao.userAuth("member_type", mdao.searchMember(uno));
					mdao.userAuth("rental", mdao.searchMember(uno));
					break;
				}
				break;
			case "d": //사용자 삭제
				System.out.println("[사용자 삭제]");
				System.out.print("삭제할 회원 번호 입력 >> ");
				String dno = sc.nextLine();
				
				BookDAO bdao = new BookDAO();
				if(bdao.rentalList(mdao.searchMember(dno)).size() != 0) {
					System.out.println("대출한 책이 남아있습니다.");
					break;
				}
				
				int result = mdao.deleteMember(mdao.searchMember(dno));
				if(result == 1) {
					start = 0;
					end = 5;
					System.out.println("삭제 성공");
				}
				else System.out.println("삭제 실패");
				break;

			//공통 메뉴
			case "o": return 0;
			case "h": return 5;
			case "q": return -1;
			case "b": return back;
			}
			
			try { //유서 선택
				if(Integer.parseInt(select) > 0) {
					run = userDetail(mdao.searchMember(select), run);
				}
			} catch (Exception e) {}
		}
		
		return run;
	} // end prtMember
	//유저 상세 정보
	public static int userDetail(Member srch, int back) {
		int run = 52;
		while(run == 52) {
			MemberDAO mdao = new MemberDAO();
			srch = mdao.searchMember("" + srch.getMemberNo());
			System.out.println("\n\n");
			System.out.println("===================================================================");
			System.out.println("===========================  사용자 정보  ===========================");
			System.out.println("===================================================================");
			System.out.println("           로그아웃(o)         메인메뉴(h)         프로그램 종료(q)       ");
			System.out.println("===================================================================");

			System.out.println();
			System.out.println("아이디\t: " + srch.getMemberNo());
			System.out.println("비밀번호\t: " + srch.getPassword());
			System.out.println("주소\t: " + srch.getAddr());
			System.out.println("전화번호\t: " + srch.getTel());
			System.out.println("회원권한\t: " + srch.getMemberType());
			String rental = "";
			if(srch.getRental()) rental += "대출 가능";
			else rental += "대출 불가(" + srch.getRentalDate() + ")";
			System.out.println("대출권한\t: " + rental);
			
			System.out.println();
			System.out.println("-------------------------------------------------------------------");
			System.out.println("회원권한변경(a)\t대출권한변경(r)\t회원삭제(d)\t뒤로가기(b)");
			System.out.println("-------------------------------------------------------------------");
			
			System.out.print("선택 >> ");
			String select = sc.nextLine();
			
			int result;
			switch(select) {
			case "a":
				result = mdao.userAuth("member_type", srch);
				if(result == 1) System.out.println("갱신 성공");
				else System.out.println("갱신 실패");
				break;
			case "r":
				result = mdao.userAuth("rental", srch);
				if(result == 1) System.out.println("갱신 성공");
				else System.out.println("갱신 실패");
				break;
			case "d":
				result = mdao.deleteMember(srch);
				if(result == 1) {
					System.out.println("삭제 성공");
					return back;
				}
				else System.out.println("삭제 실패");
				break;
				
			//공통 메뉴
			case "o": return 0;
			case "h": return 5;
			case "q": return -1;
			case "b": return back;
			}
		}
		
		return run;
	} // end userDetail
	
	//도서 관리
	public static int bookManage(Member m, int back) {
		BookDAO bdao = new BookDAO();
		List<Book> b = null;
		Book book = null;
		int result;
		
		start = 0;
		end = 5;
		
		int run = 53;
		while(run == 53) {
			b = bdao.allBook();
			System.out.println("\n\n");
			System.out.println("===================================================================");
			System.out.println("============================  도서 관리  ============================");
			System.out.println("===================================================================");
			System.out.println("           로그아웃(o)         메인메뉴(h)         프로그램 종료(q)       ");
			System.out.println("===================================================================");
			System.out.println("-------------------------------------------------------------------");
			System.out.println(" 1.도서선택  2.도서추가  3.도서갱신  4.도서삭제  5.뒤로가기 ");
			System.out.println("-------------------------------------------------------------------");
			System.out.println("번호\t제목\t\t\t작가\t    대여상태\t대여 기간");
			System.out.println("-------------------------------------------------------------------");
			
			//도서 목록 출력 5개
			for(int i = start; i < end; i++) {
				String rState = (b.get(i).getRentalDate() == null) ? "대여 가능" : "대여 불가";
				String date = b.get(i).getRentalDate() == null ? " " : b.get(i).getRentalDate();
				System.out.printf("%d\t%s\t\t\t%s\t    %s\t%s\n", b.get(i).getBookNo(), b.get(i).getTitle(), b.get(i).getWriter(), rState, date);
				if((i+1) == b.size()) break;
			}
			
			//도서 목록 하단 메뉴
			System.out.println();
			System.out.println("-------------------------------------------------------------------");
			System.out.printf("          이전페이지(-)     [%d/%d]     다음페이지(+)          \n", (start / 5 + 1), (int)Math.ceil(b.size()/5.0));
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
			case "1":
				System.out.print("도서 번호 선택 >> ");
				String srchBook = sc.nextLine();
				try {
					if(Integer.parseInt(srchBook) > 0) {
						//select가 0이상의 숫자면 해당 번호의 책 검색
						run = BookMain.bookDetail(bdao.searchBook("book_no", srchBook), m, run);
					}
				} catch (Exception e) {}
				break;
			case "2": //도서 추가
				book = new Book();
				System.out.println("[도서 추가]");
				System.out.print("제목 입력   >> ");
				book.setTitle(sc.nextLine());
				System.out.print("작가 입력   >> ");
				book.setWriter(sc.nextLine());
				System.out.print("장르 입력   >> ");
				book.setBookType(sc.nextLine());
				System.out.print("소개글 입력  >> ");
				book.setIntro(sc.nextLine());
				
				result = bdao.insertBook(book);
				if(result == 1) System.out.println("성공");
				else System.out.println("실패");
				break;
			case "3": //도서 갱신
				book = new Book();
				System.out.println("[도서 갱신]");
				System.out.print("갱신 도서 선택(번호) >> ");
				String uno = sc.nextLine();
				System.out.print("제목 입력   >> ");
				book.setTitle(sc.nextLine());
				System.out.print("작가 입력   >> ");
				book.setWriter(sc.nextLine());
				System.out.print("장르 입력   >> ");
				book.setBookType(sc.nextLine());
				System.out.print("소개글 입력  >> ");
				book.setIntro(sc.nextLine());
				
				result = bdao.updateBook(uno, book);
				
				if(result == 1) System.out.println("성공");
				else System.out.println("실패");
				break;
			case "4": //도서 삭제
				System.out.println("[도서 삭제]");
				System.out.print("삭제 도서 선택(번호) >> ");
				String dno = sc.nextLine();
				
				result = bdao.deleteBook(dno);
				
				if(result == 1) {
					start = 0;
					end = 5;
					System.out.println("성공");
				}
				else System.out.println("실패");
				break;
				
			//공통 메뉴
			case "o": return 0;
			case "h": return 5;
			case "q": return -1;
			case "b": return back;
			}
			
		}
		
		return run;
	}
	
}
