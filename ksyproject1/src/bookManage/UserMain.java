package bookManage;

import java.util.List;
import java.util.Scanner;

public class UserMain {
	static Scanner sc = new Scanner(System.in);
	
	static int start = 0;
	static int end = 4;
	
	public static int userMain(Member m) {
		MemberDAO mdao = new MemberDAO();
		//사용자 메뉴
		String selNo = "";
		int run = 4;
		while(run == 4) {
			m = mdao.searchMember("" + m.getMemberNo());
			System.out.println("\n\n");
			System.out.println("===================================================================");
			System.out.println("===========================  사용자 메뉴  ===========================");
			System.out.println("===================================================================");
			System.out.println("                 로그아웃(o)               프로그램 종료(q)             ");
			System.out.println("===================================================================");
			System.out.println("-------------------------------------------------------------------");
			System.out.println("  1.도서목록   2.도서검색   3.대출목록   4.마이페이지  ");
			System.out.println("-------------------------------------------------------------------");
			System.out.print("선택 >> ");
			selNo = sc.nextLine();
			
			switch(selNo) {
			case "1":
				run = BookMain.prtBook(m, run);
				break;
			case "2":
				run = BookMain.srchCase(m, run);
				break;
			case "3":
				run = prtRental(m, run);
				break;
			case "4":
				run = myPage(m, run);
				break;
			//공통 메뉴
			case "o":
				if(m != null) return 0;
				break;
			case "q": return -1;
			}
		}
		
		return run;
	} //end userMain
	
	//대출 목록 출력
	public static int prtRental(Member m, int back) {
		BookDAO bdao = new BookDAO();
		List<Book> b = null;
		
		int run = 41;
		while(run == 41) {
			b = bdao.rentalList(m);
			System.out.println("\n\n");
			System.out.println("===================================================================");
			System.out.println("============================  대출 목록  ============================");
			System.out.println("===================================================================");
			System.out.println("           로그아웃(o)         메인메뉴(h)         프로그램 종료(q)       ");
			System.out.println("===================================================================");
			System.out.println("-------------------------------------------------------------------");
			System.out.println("번호\t제목\t\t\t작가\t    대여상태\t대여 기간");
			System.out.println("-------------------------------------------------------------------");
			
			//도서 목록 출력 5개
			if(b.size() != 0) {
				for(int i = start; i <= end; i++) {
					String rState = (b.get(i).getRentalDate() == null) ? "대여 가능" : "대여중";
					System.out.printf("%d\t%s\t\t\t%s\t    %s\t%s\n", b.get(i).getBookNo(), b.get(i).getTitle(), b.get(i).getWriter(), rState, b.get(i).getRentalDate());
					if((i+1) == b.size()) break;
				}
			}
			//도서 목록 하단 메뉴
			System.out.println();
			System.out.println("-------------------------------------------------------------------");
			System.out.printf("이전페이지(-) [%d/%d] 다음페이지(+)  연장(e) 반납(r) 도서선택(번호) 뒤로가기(b)\n", (start / 5 + 1), (b.size()/5 + 1));
			System.out.println("-------------------------------------------------------------------");
			System.out.print("선택 >> ");
			String select = sc.nextLine();
			
			int result, bno;
			switch(select) {
			case "-":
				if(start >= 5) {
					start -= 5;
					end = start + 4;
				}
				break;
			case "+":
				if(end < b.size()) {
					start += 5;
					end = start + 4;
				}
				break;
			case "e":
				//연장
				System.out.print("번호 입력 >> ");
				bno = Integer.parseInt(sc.nextLine());
				result = bdao.rentalExtend(bno);
				
				if(result == 1) System.out.println("연장 완료");
				break;
			case "r":
				System.out.print("번호 입력 >> ");
				bno = Integer.parseInt(sc.nextLine());
				Book book = bdao.searchBook("book_no", "" + bno);
				result = bdao.returnBook(book, m);
				
				if(result == 1) System.out.println("반납 완료");
				break;
			
			//공통 메뉴
			case "o":
				if(m != null) return 0;
				break;
			case "h": return 4;
			case "q": return -1;
			case "b": return back;
			}
			
			try {
				if(Integer.parseInt(select) > 0) {
					//select가 0이상의 숫자면 해당 번호의 책 검색
					run = BookMain.bookDetail(bdao.searchBook("book_no", select), m, run);
				}
			} catch (Exception e) {}
		}
		
		return run;
	}
	
	//마이페이지
	public static int myPage(Member m, int back) {
		
		int run = 42;
		while(run == 42) {
			System.out.println("\n\n");
			System.out.println("===================================================================");
			System.out.println("===========================  마이페이지  ============================");
			System.out.println("===================================================================");
			System.out.println("           로그아웃(o)         메인메뉴(h)         프로그램 종료(q)       ");
			System.out.println("===================================================================");
			
			System.out.println();
			System.out.println("아이디\t: " + m.getId());
			System.out.println("비밀번호\t: " + m.getPassword());
			System.out.println("주소\t: " + m.getAddr());
			System.out.println("전화번호\t: " + m.getTel());
			
			String rState = "";
			rState = m.getRental() ? "대여 가능" : "대여 제한(" + m.getRentalDate() + ")";
			System.out.println("대여 상태\t: " + rState);
			
			System.out.println();
			System.out.println("-------------------------------------------------------------------");
			System.out.println("정보변경(c)\t\t회원탈퇴(x)\t\t뒤로가기(b)");
			System.out.println("-------------------------------------------------------------------");
			
			MemberDAO mdao = new MemberDAO();
			m = mdao.searchMember("" + m.getMemberNo());

			System.out.print("선택 >> ");
			String select = sc.nextLine();
			
			switch(select) {
			case "c": //정보변경
				System.out.print("비밀번호 확인 >> ");
				String upCheck = sc.nextLine();
				if(upCheck.equals(m.getPassword())) {
					System.out.println("\n[변경할 정보 입력]");
					System.out.print("비밀번호\t>> ");
					m.setPassword(sc.nextLine());
					System.out.print("주소\t>> ");
					m.setAddr(sc.nextLine());
					System.out.print("전화번호\t>> ");
					m.setTel(sc.nextLine());
				}
				
				int result = mdao.updateMember(m);
				if(result == 1) {
					System.out.println("변경 완료!!!");
					
				}
				break;
			case "x": //회원탈퇴
				BookDAO bdao = new BookDAO();
				if(bdao.rentalList(m).size() != 0) {
					System.out.println("대출한 책이 남아있습니다.");
					break;
				}
				System.out.print("비밀번호 확인 >> ");
				String delCheck = sc.nextLine();
				if(delCheck.equals(m.getPassword())) {
					mdao.deleteMember(m);
					return 0;					
				}
				break;
			
			//공통 메뉴
			case "o":
				if(m != null) return 0;
				break;
			case "h": return 4;
			case "q": return -1;
			case "b": return back;
			}
		}
		
		return run;
	}
	
	//도서 대출
	public static int rtBook(int bno, Member m) {
		if(m == null) {
			System.out.println("로그인 필요!!!");
			return 0;
		}
		
		if(m.getRental()) {
			BookDAO bdao = new BookDAO();
			Book book = bdao.searchBook("book_no", "" + bno);
			if(book.getRentalDate() == null) {
				bdao.rentalBook(bno, m.getMemberNo());
				System.out.println("대출 성공!!!");
				book = bdao.searchBook("book_no", "" + bno);
				System.out.println("반납일 : " + book.getRentalDate());
				return 1;
			}
			else System.out.println("대출 실패");
		}
		else if(!m.getRental() && m.getRentalDate() == null) System.out.println("대출 불가 계정");
		else System.out.println(m.getRentalDate() + " 이후 대출 가능");
		
		return 0;
	}
	
}
