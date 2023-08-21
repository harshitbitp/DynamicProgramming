package dynamicProgramming.adityaVerma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnboundedKnapsack {
 //Rod cutting problem is same as this
	static int t[][] = new int[1005][1006];

	static List<List<Integer>> l = new ArrayList<>();

	public static void main(String[] args) {
		for (int[] row : t)
			Arrays.fill(row, -1);
		int wt[] = { 1, 50 };
		int val[] = { 1, 30 };
		int w = 100;
		System.out.println(knapsackTabulation(wt, val, w, 2));
		System.out.println(knapsackMemoized(wt, val, w, 2));

	}
	public static int knapsackMemoized(int wt[], int val[], int w, int n) {

		if (n == 0 || w == 0)
			return 0;
		if (t[n][w] != -1)
			return t[n][w];
		else {
			if (wt[n - 1] <= w)
				t[n][w] = Math.max(val[n - 1] + knapsackMemoized(wt, val, w - wt[n - 1], n - 1), knapsackMemoized(wt, val, w, n - 1));
			else if (wt[n - 1] > w)
				t[n][w] = knapsackMemoized(wt, val, w, n - 1);

			return t[n][w];// once we have value in t[n][w]...return to method
		}

	}
	public static int knapsackTabulation(int wt[], int val[], int w, int n) {

		for (int i = 0; i < n + 1; i++)
			for (int j = 0; j < w + 1; j++) {
				if (i == 0 || j == 0)
					t[i][j] = 0;
			}
		for (int i = 1; i < n + 1; i++)
			for (int j = 1; j < w + 1; j++) {
				if (wt[i - 1] <= j)
					t[i][j] = Math.max(val[i - 1] + t[i][j - wt[i - 1]], t[i - 1][j]);
				else
					t[i][j] = t[i - 1][j];
			}
		return t[n][w];
	}
}
