package dynamicProgramming.adityaVerma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KnapsackDP {
	static int t[][] = new int[100][100];

	static List<List<Integer>> l = new ArrayList<>();

	public static void main(String[] args) {
		{
			for (int[] row : t)
				Arrays.fill(row, -1);
		}
		System.out.println(t.toString());

		for (int[] row : t)
			l.add(Arrays.stream(row).boxed().collect(Collectors.toList()));
		System.out.println(l);
		System.out.println(l.size());
		// TODO Auto-generated method stub
		int wt[] = { 4, 1, 2, 3, 7 };
		int val[] = { 9, 0, 7, 5, 2 };
		int w = 10;
		KnapsackDP obj=new KnapsackDP();
		System.out.println(obj.knapsack(wt, val, w, 5));
		System.out.println(obj.knapsackMemoized(wt, val, w, 5));
		System.out.println(obj.knapsackTabulation(wt, val, w, 5));


	}

	public  int knapsack(int wt[], int val[], int w, int n) {
		if (n == 0 || w == 0)
			return 0;
		if (wt[n - 1] <= w)
			return Math.max(val[n - 1] + knapsack(wt, val, w - wt[n - 1], n - 1), knapsack(wt, val, w, n - 1));
		else if (wt[n - 1] > w)
			return knapsack(wt, val, w, n - 1);
		return 0;// for warning
	}

	public  int knapsackMemoized(int wt[], int val[], int w, int n) {

		if (n == 0 || w == 0)
			return 0;
		if (t[n][w] != -1)
			return t[n][w];
		else {
			if (wt[n - 1] <= w)
				t[n][w] = Math.max(val[n - 1] + knapsack(wt, val, w - wt[n - 1], n - 1), knapsack(wt, val, w, n - 1));
			else if (wt[n - 1] > w)
				t[n][w] = knapsack(wt, val, w, n - 1);

			return t[n][w];// once we have value in t[n][w]...return to method
		}

	}

	public  int knapsackTabulation(int wt[], int val[], int w, int n) {

		for (int i = 0; i < n + 1; i++)
			for (int j = 0; j < w + 1; j++) {
				if (i == 0 || j == 0)
					t[i][j] = 0;
			}
		for (int i = 1; i < n + 1; i++)
			for (int j = 1; j < w + 1; j++) {
				if (wt[i - 1] <= j)
					t[i][j] = Math.max(val[i - 1] + t[i - 1][j - wt[i - 1]], t[i - 1][j]);
				else
					t[i][j] = t[i - 1][j];
			}
		return t[n][w];
	}

}
