package chap05;

import java.util.Scanner;

public class Exam223 {

	public static void main(String[] args) {
		//확인 문제 6번
		//학생수 학생들의 점수 입력 / 최고점수 평균점수 / 스위치 문으로 작성
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		Scanner scanner = new Scanner(System.in);
				
		while(run) {
			System.out.println("-----------------------------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("-----------------------------------------------------------------");
			System.out.print("선택> ");
			
			int selectNo = Integer.parseInt(scanner.nextLine());
			
			switch(selectNo) {
			case 1:
				System.out.print("학생수> ");
				studentNum = Integer.parseInt(scanner.nextLine());
				
				if(studentNum <= 0) {
					System.out.println("학생수 입력에 실패했습니다.");
					break;
				}
				
				scores = new int[studentNum];
				break;
			case 2:
				if(studentNum <= 0) {
					System.out.println("학생수를 입력하세요.");
					break;
				}
				for(int i = 0; i < studentNum; i++) {
					System.out.printf("scores[%d]> ", i);
					int score = Integer.parseInt(scanner.nextLine());
					if(score < 0) {
						System.out.println("정확한 점수를 입력해주세요");
						i--;
					}
					else scores[i] = score;
				}
				break;
			case 3:
				if(studentNum <= 0) {
					System.out.println("학생수를 입력하세요.");
					break;
				}
				for(int i = 0; i < studentNum; i++) {
					System.out.printf("scores[%d]> %d\n", i, scores[i]);
				}
				break;
			case 4:
				if(studentNum <= 0) {
					System.out.println("학생수를 입력하세요.");
					break;
				}
				int max = scores[0];
				int sum = 0;
				for(int i = 0; i < studentNum; i++) {
					sum += scores[i];
					if(max < scores[i]) max = scores[i];
				}
				System.out.printf("최고 점수: %d\n평균 점수: %f\n", max, ((double)sum / studentNum));
				break;
			case 5:
				run = false;
			}
		}
		
		System.out.println("프로그램 종료");
		
		
		
		
	}

}
