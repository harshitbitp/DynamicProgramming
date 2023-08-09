package dynamicProgramming.adityaVerma;

import java.util.Arrays;

public class EqualPartitionSum {
	static String t[][] = new String[100][100];

	public static void main(String[] args) {
		{
			for (String[] row : t)
				Arrays.fill(row, "-1");
		}
		int arr[]= {1,2,3,3,2,1,7};
		System.out.println(isEqualPartitionSum(arr,7));
	}
	
	static boolean isEqualPartitionSum(int set[], int n) {
		int s=0;
		for(int i=0;i<n;i++) {
			s+=set[i];
		}
		if(s%2!=0)
			return false;
		return isSubsetSum(set,n,s/2);
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
