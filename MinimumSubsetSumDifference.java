package dynamicProgramming.adityaVerma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumSubsetSumDifference {
	static String t[][] = new String[100][100];
	static Boolean[][] t1 = new Boolean[100][100];

	public static void main(String[] args) {
		{
			for (String[] row : t)
				Arrays.fill(row, "-1");
		}
		int set[] = { 1, 2, 7 };
		System.out.println(isSubsetSumTabulation(set, 3, 10)); // we need to use tabulation always so that dp matrix is
																// filled completely
		System.out.println("*****************");
		List<Integer> possibleSumsOfSubset = new ArrayList<>();
		// we are iterating till half of range since we are assuming s1 < s2 and s2- s1
		// should be minimum and s1 + s2 = range
		for (int j = 0; j <= 5; j++) {
			System.out.println(t1[3][j]);
			if (t1[3][j] == true)
				possibleSumsOfSubset.add(j);
		}

		System.out.println("result is " + getMinimumSubsetSumDifferene(possibleSumsOfSubset, 10));
	}

	static int getMinimumSubsetSumDifferene(List<Integer> sums, int range) {
		int minimum = Integer.MAX_VALUE;
		for (Integer i : sums) {
			minimum = Math.min(minimum, range - 2 * i);
		}
		return minimum;
	}

	static boolean isSubsetSumTabulation(int arr[], int n, int sum) {
		// boolean t[n + 1][sum + 1]; // DP - matrix
		// initialization
		// here we are setting 1st row and 1st column
		// i denotes the size of the array
		// j denotes the target sum (subset sum)
		for (int i = 0; i <= n; i++) { // itereate as long it is less then length of the array
			for (int j = 0; j <= sum; j++) {
				if (i == 0)// when array(i) is empty than there is no meaning of sum of elements so return
							// false
					t1[i][j] = false;
				if (j == 0) // when sum(j) is zero and there is always a chance of empty subset so return it
							// as true;
					t1[i][j] = true;
			}
		}
		// start from 1 since 1st row and column is already considerd
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (arr[i - 1] <= j)
					// after taking and element substract from the (sum) i.e -> in {3,8} 3 is taken
					// then we want 11-3=8in the array
					t1[i][j] = t1[i - 1][j - arr[i - 1]] || t1[i - 1][j]; // either take or(||) do not take
				else // if sum is less than array size just leave and increment
					t1[i][j] = t1[i - 1][j];
			}
		}

		return t1[n][sum]; // at last return T/F
	}

	static boolean isSubsetSum(int set[], int n, int sum) {
		// Base Cases
		if (sum == 0)
			return true;
		if (n == 0 && sum != 0)
			return false;
		if (t[n][sum] != "-1")
			return Boolean.parseBoolean(t[n][sum]);
		// If last element is greater than
		// sum, then ignore it
		if (set[n - 1] > sum)
			t[n][sum] = String.valueOf(isSubsetSum(set, n - 1, sum));

		/*
		 * else, check if sum can be obtained by any of the following (a) including the
		 * last element (b) excluding the last element
		 */
		else
			t[n][sum] = String.valueOf(isSubsetSum(set, n - 1, sum) || isSubsetSum(set, n - 1, sum - set[n - 1]));
		return Boolean.parseBoolean(t[n][sum]);
	}
}
