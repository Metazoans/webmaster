package 도서관리;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class BookMain {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		MemberDao mdao = MemberDao.getInstance();
		Member member = null;
		
		while(true) {
			System.out.print("아이디 입력 > ");
			String id = sc.nextLine();
			System.out.print("비밀번호 입력 > ");
			String pw = sc.nextLine();
			
			// 정상적인 로그인되면 "홍길동" 환영메세지.
			member = mdao.checkMember(id, pw);
			if(member != null) {
				System.out.println(member.getMemberName() + " 환영합니다!");
				break;
			}
			System.out.println("아이디와 비밀번호를 확인하세요!");
		}
		
		//권한이 User => 도서관리 처리
		//권한이 Admin => 회원관리 처리
		if(member.getResponsibility().equals("User")) bookManage();
		else if(member.getResponsibility().equals("Admin")) memberManage();
		
		sc.close();
	} // end main
	
	static void bookManage() { //도서관리
		//1.도서등록 2.도서검색 3.도서전체 조회 4.도서삭제 5.도서 정보 변경 6. 종료
		//변수
		BookDao bdao = new BookDao();
		String btitle, bwriter, bno;
		int bprice, result;
		
		boolean run = true;
		while(run) {
			prtMenu("유저", 0);
			String menuNum = sc.nextLine();
			
			result = 0;
			Book book = null;
			switch(menuNum) {
			case "1":	//등록
				prtMenu("도서", 1);
				
				System.out.print("제목 > ");
				btitle = sc.nextLine();
				System.out.print("작가 > ");
				bwriter = sc.nextLine();
				System.out.print("가격 > ");
				bprice = Integer.parseInt(sc.nextLine());
				System.out.print("번호 > ");
				bno = sc.nextLine();
				
				book = new Book(btitle, bwriter, bprice, bno);
				
				boolean check = duplicate(book);
				
				if(!check) result = bdao.bookInsert(book);
				
				if(result == 1) System.out.println("도서 등록 성공");
				else System.out.println("도서 등록 실패");
				
				break;
			case "2":	//조건 검색
				prtMenu("도서", 2);
				
				System.out.print("제목 > ");
				btitle = sc.nextLine();
				
				book = bdao.bookSelect(btitle);
				if(book != null) System.out.println(book);
				else System.out.println("책이 없습니다.");
				break;
			case "3":	//전체 검색
				prtMenu("도서", 3);
				
				List<Book> blist = null;
				blist = bdao.allSelect();
				
				Iterator<Book> ir = blist.iterator();
				while(ir.hasNext()) {
					book = ir.next();
					System.out.println(book);
				}
				break;
			case "4":	//삭제
				prtMenu("도서", 4);
				
				System.out.print("번호 > ");
				bno = sc.nextLine();
				
				result = bdao.bookDelete(bno);
				if(result == 1) System.out.println("도서 삭제 성공");
				else System.out.println("도서 삭제 실패");
				
				break;
			case "5":	//갱신
				prtMenu("도서", 5);
				
				System.out.print("제목 > ");
				btitle = sc.nextLine();
				System.out.print("가격 > ");
				bprice = Integer.parseInt(sc.nextLine());
				System.out.print("번호 > ");
				bno = sc.nextLine();
				
				book = new Book(btitle, null, bprice, bno);
				
				result = bdao.bookUpdate(book);
				if(result == 1) System.out.println("도서 정보 갱신 성공");
				else System.out.println("도서 정보 갱신 실패");
				
				break;
			case "6":	//종료
				prtMenu("도서", 6);
				run = false;
				break;
			default:
				System.out.println("잘못된 선택입니다.");
			}
		} //end while
	}
	
	static void memberManage() { //회원관리
		System.out.println("관리자 메뉴입니다.");
		
		// 1.회원 등록 2.회원검색 3.회원목록 4. 회원삭제 5.회원 갱신 6.종료
		int result;
		String id, pw, name, phone, respon;
		
		Member m = null;
		MemberDao mdao = MemberDao.getInstance();
		
		boolean run = true;
		while(run) {
			prtMenu("유저", 0);
			String menuNum = sc.nextLine();
			
			result = 0;
			
			switch(menuNum) {
			case "1":	//등록
				prtMenu("유저", 1);
				
				System.out.print("아이디 > ");
				id = sc.nextLine();
				System.out.print("비밀번호 > ");
				pw = sc.nextLine();
				System.out.print("이름 > ");
				name = sc.nextLine();
				System.out.print("전화번호 > ");
				phone = sc.nextLine();
				System.out.print("권한 > ");
				respon = sc.nextLine();
				
				m = new Member(id, pw, name, phone, respon);
				
				result = mdao.memberInsert(m);
				
				if(result == 1) System.out.println("유저 등록 성공");
				else System.out.println("유저 등록 실패");
				
				break;
			case "2":	//조건 검색
				prtMenu("유저", 2);
				
				System.out.print("아이디 > ");
				id = sc.nextLine();
				
				m = mdao.memberSelect(id);
				if(m != null) System.out.println(m);
				else System.out.println("유저 정보가 없습니다.");
				break;
			case "3":	//전체 검색
				prtMenu("유저", 3);
				
				List<Member> list = mdao.memberList();
				for(Member member : list) {
					System.out.println(member);
				}
				break;
			case "4":	//삭제
				prtMenu("유저", 4);
				
				System.out.print("아이디 > ");
				id = sc.nextLine();
				System.out.print("비밀번호 > ");
				pw = sc.nextLine();
				
				if(mdao.checkMember(id, pw) != null) {
					result = mdao.memberDelete(id);
				}
				
				if(result == 1) System.out.println("유저 삭제 성공");
				else System.out.println("유저 삭제 실패");
				
				break;
			case "5":	//갱신
				prtMenu("유저", 5);
				
				System.out.print("아이디 > ");
				id = sc.nextLine();
				System.out.print("비밀번호 > ");
				pw = sc.nextLine();
				if(mdao.checkMember(id, pw) != null) {
					System.out.print("변경할 비밀번호 > ");
					pw = sc.nextLine();
					System.out.print("변경할 휴대폰 번호 > ");
					phone = sc.nextLine();
					
					m = new Member(id, pw, null, phone, null);
					
					result = mdao.memberUpdate(m);
				}
				
				if(result == 1) System.out.println("도서 정보 갱신 성공");
				else System.out.println("도서 정보 갱신 실패");
				
				break;
			case "6":	//종료
				prtMenu("유저", 6);
				run = false;
				break;
			default:
				System.out.println("잘못된 선택입니다.");
			}
		} //end while
		
	}
	
	static void prtMenu(String s, int n) { // 메뉴 출력
		switch(n) {
		case 0:
			System.out.println("---------------------------------------------------------------------------");
			System.out.printf("1.%s 등록 | 2.%s 검색 | 3.%s 전체 조회 | 4.%s 삭제 | 5.%s 정보 변경 | 6.종료\n", s, s, s, s, s);
			System.out.println("---------------------------------------------------------------------------");
			System.out.print("메뉴 선택 > ");
			break;
		case 1:
			System.out.println("-------------");
			System.out.printf("[%s 등록]\n", s);
			System.out.println("-------------");
			break;
		case 2:
			System.out.println("-------------");
			System.out.printf("[%s 검색]\n", s);
			System.out.println("-------------");
			break;
		case 3:
			System.out.println("-------------");
			System.out.printf("[%s 전체 조회]\n", s);
			System.out.println("-------------");
			break;
		case 4:
			System.out.println("-------------");
			System.out.printf("[%s 삭제]\n", s);
			System.out.println("-------------");
			break;
		case 5:
			System.out.println("-------------");
			System.out.printf("[%s 정보 변경]\n", s);
			System.out.println("-------------");
			break;
		case 6:
			System.out.println("-------------");
			System.out.println("[프로그램 종료]");
			System.out.println("-------------");
			break;
		}
	}
	
	public static boolean duplicate(Book b) { //책 중복 체크
		BookDao bdao = new BookDao();
		
		//Book bCheck = bdao.bookSelect(b.getBtitle());
		
		List<Book> bset = bdao.allSelect();
		
		boolean check = bset.contains(b);
		if(check) return true;
		
		return false;
	}
	
} // end class
