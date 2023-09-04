package dynamicProgramming.adityaVerma;

import java.util.Arrays;

public class LongestCommonSubstring {
	static Integer t[][] = new Integer[1000][1000];

	public static void main(String[] args) {
		String x = "abcde";
		String y = "abfce";

		System.out.println("LongestCommonSubstring = " + LongestCommonSubstring(x, y, x.length(), y.length()));
	}
	static int LongestCommonSubstring(String x, String y, int m, int n) {
		int count = 0;
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				if (i == 0 || j == 0) {
					t[i][j] = 0;
				}
			}
		}
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (x.charAt(i - 1) == y.charAt(j - 1)) {
					t[i][j] = 1 + t[i - 1][j - 1];
					if (count < t[i][j])
						count = t[i][j];
				} else
					t[i][j] = 0;
			}
		}

		return count;
	}

}
