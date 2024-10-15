package chap05;

public class Exam214 {

	public static void main(String[] args) {
		//2차원 배열
		
		int[][] scores = {
				{10, 20, 30},
				{40, 50, 60}
		};
		
		for(int i = 0; i < scores.length; i++) { //scores.length = 행의 수(길이)
			for(int j = 0; j < scores[i].length; j++) { //scores[i].length = i행의 열의 수(길이)
				System.out.print(scores[i][j] + " ");
			}
			System.out.println();
		}
		
		//2*3 배열 선언
		//1에서 10까지 무작위 수 입력
		int[][] nums = new int[2][3];
		
		for(int i = 0; i < nums.length; i++) {
			for(int j = 0; j < nums[i].length; j++) {
				nums[i][j] = (int)(Math.random() * 10) + 1;
			}
		}
		
		System.out.println("---------------------------------------------------------");
		for(int i = 0; i < nums.length; i++) {
			for(int j = 0; j < nums[i].length; j++) {
				System.out.print(nums[i][j] + " ");
			}
			System.out.println();
		}
		
		//향상된 for문
		System.out.println("---------------------------------------------------------");
		for(int i = 0; i < nums.length; i++) {
			for(int j : nums[i]) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		int[] su = { 10, 200, 30, 40, -50, 777, 555 };
		
		//배열 합, 최대값, 최소갑
		int sum = 0;
		int max = Integer.MIN_VALUE; //int값 중에 최소값
		int min = Integer.MAX_VALUE; //int값 중에 최대값
		
		for(int ele : su) {
			sum += ele;
			if(max < ele) max = ele;
			if(min > ele) min = ele;
		}
		System.out.printf("sum = %d, max = %d, min = %d\n", sum, max, min);
		
	}

}
