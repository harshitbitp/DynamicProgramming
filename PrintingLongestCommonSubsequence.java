package dynamicProgramming.adityaVerma;

import java.util.Arrays;

public class PrintingLongestCommonSubsequence {
	static Integer t[][] = new Integer[1000][1000];

	public static void main(String[] args) {	
		String x = "abcdgh";
		String y = "abedfhr";
		int count = LCSTabulation(x, y, x.length(), y.length());
		int i=x.length(),j=y.length();
		String s="";
		while(i>0 && j>0) {
			if(x.charAt(i-1)==y.charAt(j-1)) {
				s=x.charAt(i-1)+s;
				i--; j--;
					}
			else {
				if(t[i][j-1]>t[i-1][j])
					j--;
				else
					i--;
			}
		}
		System.out.println(s);
		
	}

	static int LCSTabulation(String x, String y, int m, int n) {
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				if (i == 0 || j == 0) {
					t[i][j] = 0;
				}
			}
		}
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (x.charAt(i - 1) == y.charAt(j - 1))
					t[i][j] = 1 + t[i - 1][j - 1];
				else
					t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
			}
		}
	
		return t[m][n];
	}
}
