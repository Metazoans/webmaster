package bookManage;

import java.util.Scanner;

//메인

public class Main {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		MemberDAO mdao = new MemberDAO();
		
		Member member = null;
		
		//메인 메뉴
		int run = 0; //메인 메뉴 실행 번호
		
		while(run == 0) {
			
			System.out.println("\n\n");
			System.out.println("===================================================================");
			System.out.println("============================  메인 메뉴  ============================");
			System.out.println("-------------------------------------------------------------------");
			System.out.println("    1.도서 목록    2.도서 검색    3.로그인    4.회원가입    5.종료     ");
			System.out.println("-------------------------------------------------------------------");
			System.out.print("선택 >> ");
			String selNo = sc.nextLine();
			
			switch(selNo) {
			case "1": //도서 목록
				run = BookMain.prtBook(member, run);
				break;
			case "2": //도서 검색
				//bookdao에서 책 검색
				run = BookMain.srchCase(member, run);
				break;
			case "3": //로그인
				System.out.println("\n\n");
				System.out.println("===================================================================");
				System.out.println("============================  로 그 인  ============================");
				System.out.println("===================================================================");
				
				System.out.println();
				System.out.print("아이디 입력 >> ");
				String id = sc.nextLine();
				System.out.print("비밀번호 입력 >> ");
				String pw = sc.nextLine();
				
				//memberdao에서 로그인
				member = mdao.login(id, pw);
				
				//로그인 성공시 권한 확인
				String type = null;
				if(member != null) {
					type = member.getMemberType();
				}
				else {
					System.out.println("로그인 실패");
					break;
				}
				//권한 확인 후 usermain or adminmain 실행
				if(type.equals("user")) run = UserMain.userMain(member);
				else if(type.equals("admin")) run = AdminMain.adminMain(member);
				
				break;
			case "4": //회원가입
				//memberdao에서 회원가입
				System.out.println("\n\n");
				System.out.println("===================================================================");
				System.out.println("============================  회원 가입  ============================");
				System.out.println("===================================================================");
				
				System.out.println();
				System.out.print("아이디 입력 >> ");
				String uid = sc.nextLine();
				System.out.print("비밀번호 입력 >> ");
				String upw = sc.nextLine();
				System.out.print("주소 입력 >> ");
				String uaddr = sc.nextLine();
				System.out.print("전화번호 입력 >> ");
				String utel = sc.nextLine();
				
				int join = 0;
				boolean selRun = true;
				while(selRun) {
					System.out.print("\n입력하신 정보가 맞습니까? [확인(y) / 취소(n)] >> ");
					String yn = sc.nextLine();
					
					switch(yn) {
					case "y":
						member = new Member(-1, uid, upw, uaddr, utel);
						join = mdao.join(member);
						selRun = false;
						break;
					case "n":
						System.out.println("취소되었습니다.");
						selRun = false;
						break;
					default:
						System.out.println("선택을 확인해 주세요(y/n)");
					}
				}
				if(join == 0) System.out.println("회원가입 실패");
				break;
			case "5": //종료
				run = -1;
				break;
			default:
				System.out.println("\n잘못된 선택입니다\n");
			}
			
		}
		
		System.out.println("프로그램 종료");
		sc.close();
	} //end main
	
	
} // end class
