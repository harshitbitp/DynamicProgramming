package dynamicProgramming.adityaVerma;

import java.util.Arrays;

public class CountSubset {
	static Integer t[][] = new Integer[100][100];

	public static void main(String[] args) {
		{
			for (Integer[] row : t)
				Arrays.fill(row, -1);
		}
		

		int arr[]= {1,2,3,3};
		System.out.println(CountSubsetSum(arr,4,5));
	}
	static Integer CountSubsetSum(int set[], int n, int sum) {
		// Base Cases
		if (sum == 0)
			return 1;
		if (n == 0 && sum != 0)
			return 0;
		if (t[n][sum] != -1)
			return t[n][sum];
		// If last element is greater than
		// sum, then ignore it
		if (set[n - 1] > sum)
			t[n][sum] = CountSubsetSum(set, n - 1, sum);

		/*
		 * else, check if sum can be obtained by any of the following (a) including the
		 * last element (b) excluding the last element
		 */
		else
			t[n][sum] =CountSubsetSum(set, n - 1, sum) + CountSubsetSum(set, n - 1, sum - set[n - 1]);
		return t[n][sum];
	}
}
