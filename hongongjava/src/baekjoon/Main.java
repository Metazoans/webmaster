package baekjoon;
//패키지 제외하고 제출

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		s = s.toUpperCase();
		char[] c = s.toCharArray();
		
		int[] cNum = new int[26];
		for(int i = 0; i < c.length; i++) {
			cNum[c[i] - 65]++;
		}

		int max = Integer.MIN_VALUE;
		int maxCnt = 0;
		int maxI = 0;
		for(int i = 0; i < cNum.length; i++) {
			if(max < cNum[i]) { max = cNum[i]; }
		}
		for(int i = 0; i < cNum.length; i++) {
			if(max == cNum[i]) {
				maxCnt++;
				maxI = i;
			}
		}
		int result = 65 + maxI;
		if(maxCnt != 1) {
			System.out.println("?");
		}
		else {
			System.out.println((char)result);
		}
		
		
		
		sc.close();
	}//end main
	
}//end class
