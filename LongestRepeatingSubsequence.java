package dynamicProgramming.adityaVerma;

import java.util.Arrays;

public class LongestRepeatingSubsequence {
	static Integer t[][] = new Integer[1000][1000];

	public static void main(String[] args) {
		for (Integer[] row : t)
			Arrays.fill(row, -1);
		String s= "AABEBCDD";
		System.out.println(LCSMemoization(s,s,s.length(),s.length()));
	}

	static int LCSMemoization(String x, String y, int m, int n) {
		if (n == 0 || m == 0) {
			return 0;
		}
		if (t[m][n] != -1)
			return t[m][n];
		if (x.charAt(m - 1) == y.charAt(n - 1) && m!=n)
			t[m][n] = 1 + LCSMemoization(x, y, m - 1, n - 1);
		else
			t[m][n] = Math.max(LCSMemoization(x, y, m - 1, n), LCSMemoization(x, y, m, n - 1));
		return t[m][n];

	}
}
