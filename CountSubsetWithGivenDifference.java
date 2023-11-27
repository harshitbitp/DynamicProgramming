package dynamicProgramming.adityaVerma;

import java.util.Arrays;

public class CountSubsetWithGivenDifference {
	//Target sum problem is same as this
//some correction has been done in this code
	public static void main(String[] args) {
		
		int arr[]= {0,0,0,0,0,0,0,0,1};
		int diff = 1;
		int range = 0;
		for(int i=0;i<arr.length;i++) {
			range+=arr[i];
		}
		int sumToCheck= (range + diff)/2;
		System.out.println(findTargetSumWays(arr,sumToCheck));
	}

	 public static int findTargetSumWays(int[] arr, int target) {
			int diff = target;
			int range = 0;
			for(int i=0;i<arr.length;i++) {
				range+=arr[i];
			}
			if(target>range)
			return 0;
			if((range+diff)%2!=0)
			return 0;
			int sumToCheck= (range + diff)/2;
			if(sumToCheck<0)
			return 0;

	        return CountSubsets(arr,arr.length,sumToCheck);
	    }

	   static int CountSubsets(int arr[], int n, int sum) {
		int  t[][] = new int[n+1][sum+1]; // DP - matrix
		// initialization 
	  // here we are setting 1st row and 1st column 
	  // i denotes the size of the array 
	  // j denotes the target sum (subset sum)
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= sum; j++) {// NOTE:-----here as correction j start from 0 instead of 1 
				if (i == 0) // when array(i) is empty than there is no meaning of sum of elements so return count of subset as 0;
					t[i][j] = 0;
				if (j == 0) // when sum(j) is zero and there is always a chance of empty subset so return count as 1;
					t[i][j] = 1;
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= sum; j++) {
				if (arr[i - 1] <= j) // when element in the list is less then target sum 
					t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j]; // either exclude or inxlude and add both of them to get final count 
				else
					t[i][j] = t[i - 1][j]; // exclude when element in the list is greater then the sum 
			}
		}

		return t[n][sum]; // finally return the last row and last column element 
	}
}
