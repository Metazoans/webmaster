package 김선용;

public class Array {

	public static void main(String[] args) {
		// 2024.09.26 과제
		//1번
		System.out.println("[1번]");
		
		int[] arr1 = new int[10];
		for(int i = 0; i < arr1.length; i++) {
			arr1[i] = (int)(Math.random() * 10);
		}
		int sum1 = 0;
		int max1 = Integer.MIN_VALUE;
		int min1 = Integer.MAX_VALUE;
		for(int ele : arr1) {
			System.out.print(ele + " ");
			sum1 += ele;
			if(max1 < ele) max1 = ele;
			if(min1 > ele) min1 = ele;
		}
		System.out.printf("\nsum = %d, max = %d, min = %d\n", sum1, max1, min1);
		
		//2번
		System.out.println("\n[2번]");
		int[][] arr2 = {
				{1, 2, 3},
				{1, 2},
				{1},
				{1, 2, 3}
		};
		
		for(int[] i : arr2) {
			for(int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		
		//3번
		System.out.println("\n[3번]");
		
		int[][] arr3 = new int[3][10];
		for(int i = 0; i < arr3.length; i++) {
			for(int j = 0; j < arr3[i].length; j++) {
				arr3[i][j] = (int)(Math.random() * 2);
			}
		}
		
		for(int[] i : arr3) {
			for(int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		
		int sum3 = 0;
		for(int[] i : arr3) {
			for(int j : i) {
				sum3 += j;
			}
		}
		System.out.printf("현재 관객 수는 %d명\n", sum3);
		
		
		//4번
		System.out.println("\n[4번]");
		
		int[][] arr4 = new int[3][5];
		for(int i = 0; i < arr4.length; i++) {
			for(int j = 0; j < arr4[i].length; j++) {
				arr4[i][j] = (int)(Math.random() * 51) + 50;
			}
		}
		for(int[] i : arr4) {
			for(int j : i) {
				System.out.print(j + "\t");
			}
			System.out.println();
		}
		for(int i = 0; i < arr4.length; i++) {
			int sum4 = 0;
			for(int j : arr4[i]) {
				sum4 += j;
			}
			System.out.printf("%d번 학생 평균 = %d\n", (i + 1), (sum4 / arr4[i].length));
		}
		
		//5번
		System.out.println("\n[5번]");
		
		String[] arr5 = {"Clubs", "Diamonds", "Hearts", "Spades"};
		String[] arr5Num = {"2","3","4", "5", "6","7","8","9","10","Jack","Queen","King","Ace"};
		
		for(int i = 0; i < 5; i++) {
			int rNum1 = (int)(Math.random() * arr5.length);
			int rNum2 = (int)(Math.random() * arr5Num.length);
			System.out.printf("%s의 %s\n", arr5[rNum1], arr5Num[rNum2]);
		}
		
		//6번
		System.out.println("\n[6번]");
		
		int[][] arr6 = new int[3][5];
		
		for(int i = 0; i < 5; i++) {
			int inX = (int)(Math.random() * arr6.length);
			int inY = (int)(Math.random() * arr6[inX].length);
			if(arr6[inX][inY] == 0) arr6[inX][inY] = 1;
			else i--;
		}
		
		for(int[] i : arr6) {
			for(int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		
		
	}

}
