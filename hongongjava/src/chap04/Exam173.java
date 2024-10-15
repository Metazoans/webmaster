package chap04;

public class Exam173 {

	public static void main(String[] args) {
		//50에서 100까지 3의 배수 합 구하기
		// 3의 배수 출력, 마지막에 3의 배수 합 출력
		// 3의 배수 갯수 출력
		int sum = 0;
		int cnt = 0;
		String str = "";
		
		for(int i = 50; i <= 100; i++) {
			if(i % 3 == 0) {
				str += i;
				sum += i;
				cnt++;
				
				if(i + 3 > 100) break;
				
				str += ", ";
			}
		}
		System.out.println(str);
		System.out.println("합 = " + sum);
		System.out.println("3의 배수 갯수 = " + cnt);
		
		
		// 7의 배수의 합이 300이 넘는 순간의 7의 배수 찾기
		int num7, sum7;
		num7 = sum7 = 0;
		
		while(true) {
			num7 += 7;
			sum7 += num7;
			
			if(sum7 > 300) break;
		}
		System.out.println("마지막 7의 배수 = " + num7);
		System.out.println("7의 배수의 합 = " + sum7);
		
		
		//구구단 : 중첩 반복문
		for(int i = 2; i <= 9; i++) {
			System.out.println("=== " + i + "단 ===");
			for(int j = 1; j <= 9; j++) {
				System.out.printf("%d x %d = %d\n", i, j, (i * j));
			}
		}
		
		System.out.println("----------------------------------------------------------------");

		//구구단 변형
		for(int i = 2; i <= 9; i++) {
			System.out.print("  " + i + "단\t");
		}
		System.out.println();

		for(int i = 1; i <= 9; i++) {
			for(int j = 2; j <= 9; j++) {
				System.out.printf("%dx%d=%2d\t", j, i, (j * i));
			}
			System.out.println();
		}
		

		System.out.println("----------------------------------------------------------------");

		//구구단 변형2 - 중첩 for문 1개로 단수도 표시
		for(int i = 0; i <= 9; i++) {
			for(int j = 2; j <= 9; j++) {
				if(i == 0) {
					System.out.print("  " + j + "단\t");
				}
				else
					System.out.printf("%dx%d=%2d\t", j, i, (j * i));
			}
			System.out.println();
		}
		
	}// end main

}// end class
