package dynamicProgramming.adityaVerma;

public class MinNumberCoin {
//minimum number of coin to get sum
	static int t[][]=new int[100][100];
	public static void main(String[] args) {
		int coin[]= {1,2,3};
		int sum=5;
		for(int j=0;j<sum+1;j++)
		{
			t[0][j]=Integer.MAX_VALUE-1;
		}
		for(int i=1;i<coin.length+1;i++)
		{
			t[i][0]=0;
		}
		for(int j=1;j<sum+1;j++) {
			if(j%coin[0]==0)
				t[1][j]=j/coin[0];
			else
				t[1][j]=Integer.MAX_VALUE-1;
		}
		
		for(int i=2;i<coin.length+1;i++) {
			for(int j=2;j<sum+1;j++) {
				if(coin[i-1]<=j) {
					t[i][j]= Math.min(t[i][j-coin[i-1]]+1, t[i-1][j]);					
				}
				else
					t[i][j]=t[i-1][j];
			}
		}
		System.out.println(t[3][5]);

	}

}
