package chap05;

import java.util.Arrays;

public class Exam202 {

	public static void main(String[] args) {
		//run 메뉴 -> run config 메뉴 - arguments 내용 = main의 문자열 배열
		//String args1 = args[2];
		//System.out.println(args1);
		
		// 배열 생성
		// 배열 이용 방법
		int[] scores = { 83, 90, 87 };
		
		System.out.println("scores[0] : " + scores[0]);
		System.out.println("scores[1] : " + scores[1]);
		System.out.println("scores[2] : " + scores[2]);
		
		int sum = 0;
		for(int i = 0; i < scores.length; i++) {
			sum += scores[i];
		}
		System.out.println("총합 : " + sum);
		double avg = (double) sum / 3;
		System.out.printf("평균 : %.2f\n\n", avg);
		
		
		//배열에 1~100 임의의 수 10개 저장
		//배열의 합, 평균(소수 첫쨰자리 나타냄)
		//최대값, 최소값
		
		//배열 생성
		int[] arr = new int[10];
		
		outer: for(int i = 0; i < arr.length; i++) {
			int rNum = (int)(Math.random() * 100) + 1;
			for(int j = 0; j < i; j++) {
				if(arr[j] == rNum) {
					i--;
					continue outer;
				}
			}
			arr[i] += rNum;
		}
		
		//배열 출력
		System.out.println("배열 : " + Arrays.toString(arr));
		
		//배열 이용, 합, 평균, 최대, 최소값 구하기
		int arrSum = 0;
		int arrMax = arr[0];
		int arrMin = arr[0];
		for(int i = 0; i < arr.length; i++) {
			arrSum += arr[i];
			if(arrMax < arr[i]) arrMax = arr[i];
			if(arrMin > arr[i]) arrMin = arr[i];
		}
		System.out.println("배열의 합 : " + arrSum);
		System.out.printf("배열의 평균 : %.1f\n", ((double)arrSum / arr.length));
		System.out.println("배열의 최대값 : " + arrMax);
		System.out.println("배열의 최소값 : " + arrMin);
		
		
	}//end main

}//end class
