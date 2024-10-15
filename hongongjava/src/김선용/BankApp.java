package 김선용;

import java.util.Scanner;

public class BankApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Account[] acc = new Account[100];
		int accNum = 0;
		boolean run = true;
		
		while(run) {
			System.out.println("------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("------------------------------------------");
			System.out.print("선택> ");
			int selNo = Integer.parseInt(sc.nextLine());
			
			boolean accCheck = true;
			
			switch(selNo) {
			case 1:
				System.out.println("-----------");
				System.out.println("계좌생성");
				System.out.println("-----------");
				
				Account newAcc = new Account();
				String result = "";
				
				System.out.print("계좌번호: ");
				newAcc.setAno(sc.nextLine());
				accCheck &= !anoCheck(acc, accNum, newAcc.getAno()); //중복이면 !true == true && false == false
				System.out.print("계좌주: ");
				newAcc.setOwner(sc.nextLine());
				System.out.print("초기입금액: ");
				accCheck &= newAcc.setBalence(Integer.parseInt(sc.nextLine()));
				
				if(accCheck) {
					result = "계좌가 생성되었습니다.";
					acc[accNum] = newAcc;
					accNum++;
				}
				else result = "계좌 생성에 실패했습니다.";
				System.out.println("결과: " + result);
				break;
			case 2:
				System.out.println("-----------");
				System.out.println("계좌목록");
				System.out.println("-----------");
				
				for(int i = 0; acc[i] != null; i++) {
					System.out.printf("%s %s %d\n", acc[i].getAno(), acc[i].getOwner(), acc[i].getBalence());
				}
				break;
			case 3:
				System.out.println("-----------");
				System.out.println("예금");
				System.out.println("-----------");
				
				System.out.print("계좌번호: ");
				String ano1 = sc.nextLine();
				accCheck = anoCheck(acc, accNum, ano1);
				
				if(!accCheck) {
					System.out.println("계좌번호가 다릅니다.");
					break;
				}
				
				int accIdx1 = 0;
				for(int i = 0; i < accNum; i++) {
					if(acc[i].getAno().equals(ano1)) {
						accIdx1 = i;
						break;
					}
				}
				
				System.out.print("예금액: ");
				int money = Integer.parseInt(sc.nextLine());
				acc[accIdx1].addBalence(money);
				break;
			case 4:
				System.out.println("-----------");
				System.out.println("출금");
				System.out.println("-----------");
				
				System.out.print("계좌번호: ");
				String ano2 = sc.nextLine();
				accCheck = anoCheck(acc, accNum, ano2);
				
				if(!accCheck) {
					System.out.println("계좌번호가 다릅니다.");
					break;
				}
				
				int accIdx2 = 0;
				for(int i = 0; i < accNum; i++) {
					if(acc[i].getAno().equals(ano2)) {
						accIdx2 = i;
						break;
					}
				}
				
				System.out.print("출금액: ");
				int money2 = Integer.parseInt(sc.nextLine());
				acc[accIdx2].minusBalence(money2);
				break;
			case 5: run = false;
			}
		}
		System.out.println("프로그램 종료");
		
		
		
	} //end main
	
	public static boolean anoCheck(Account[] acc, int accNum, String ano) {
		for(int i = 0; i < accNum; i++) { //계좌번호 중복 체크 (중복시 true, 아니면 false)
			if(acc[i].getAno().equals(ano)) return true;
		}
		
		return false;
	}
	
} //end class
