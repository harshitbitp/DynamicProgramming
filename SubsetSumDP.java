package dynamicProgramming.adityaVerma;

import java.util.Arrays;

public class SubsetSumDP {
	static String t[][] = new String[100][100];
	public static void main(String[] args) {
		{
			for (String[] row : t)
				Arrays.fill(row, "-1");
		}	
		int set[] = { 3, 34, 4, 12, 5, 2 };
        int sum = 9;
        int n = set.length;
        if (isSubsetSum(set, n, sum) == true)
            System.out.println("Found a subset"
                               + " with given sum");
        else
            System.out.println("No subset with"
                               + " given sum");
	}

	static boolean isSubsetSum(int set[], int n, int sum) {
// Base Cases
		if (sum == 0)
			return true;
		if (n == 0 && sum != 0)
			return false;
				if(t[n][sum]!="-1")
					return Boolean.parseBoolean(t[n][sum]);
// If last element is greater than
// sum, then ignore it
		if (set[n - 1] > sum)
			t[n][sum]= String.valueOf(isSubsetSum(set, n - 1, sum));

		/*
		 * else, check if sum can be obtained by any of the following (a) including the
		 * last element (b) excluding the last element
		 */
		else
		t[n][sum]=String.valueOf(isSubsetSum(set, n - 1, sum) || isSubsetSum(set, n - 1, sum - set[n - 1]));
		return Boolean.parseBoolean(t[n][sum]);
	}

}
