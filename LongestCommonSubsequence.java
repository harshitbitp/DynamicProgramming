package dynamicProgramming.adityaVerma;

import java.util.Arrays;

public class LongestCommonSubsequence {
	static Integer t[][] = new Integer[1000][1000];
	static Integer t2[][] = new Integer[1000][1000];

	public static void main(String args[]) {
		String x = "abcdgh";
		String y = "abedfhr";
		long t1 = System.currentTimeMillis();
		System.out.println("LCS of x and y is " + LCSRecursive(x, y, x.length(), y.length()));
		System.out.println("recursion time is " + (System.currentTimeMillis() - t1));
		{
			for (Integer[] row : t)
				Arrays.fill(row, -1);
		}
		long t2 = System.currentTimeMillis();
		System.out.println("LCS(Memoization) of x and y is " + LCSMemoization(x, y, x.length(), y.length()));
		System.out.println("DP time is " + (System.currentTimeMillis() - t2));

		{
			for (Integer[] row : t)
				Arrays.fill(row, 0);
		}
		System.out.println("LCS(Tabulation) of x and y is " + LCSTabulation(x, y, x.length(), y.length()));

	}

	static int LCSRecursive(String x, String y, int m, int n) {
		if (n == 0 || m == 0) {
			return 0;
		}
		if (x.charAt(m - 1) == y.charAt(n - 1))
			return 1 + LCSRecursive(x, y, m - 1, n - 1);
		else
			return Math.max(LCSRecursive(x, y, m, n - 1), LCSRecursive(x, y, m - 1, n));

	}

	static int LCSMemoization(String x, String y, int m, int n) {
		if (n == 0 || m == 0) {
			return 0;
		}
		if (t[m][n] != -1)
			return t[m][n];
		if (x.charAt(m - 1) == y.charAt(n - 1))
			t[m][n] = 1 + LCSMemoization(x, y, m - 1, n - 1);
		else
			t[m][n] = Math.max(LCSMemoization(x, y, m - 1, n), LCSMemoization(x, y, m, n - 1));
		return t[m][n];

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
