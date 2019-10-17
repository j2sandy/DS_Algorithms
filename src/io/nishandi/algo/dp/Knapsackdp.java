package io.nishandi.algo.dp;

public class Knapsackdp {
	
	public static void main(String[] args) {
		int weights[] = {2,3,1,4};
		int profits[] = {4,5,3,7};
		int knapsack_capacity=5;
		//int pr=getMaximumProfitRecursive(weights, profits, knapsack_capacity, 0);
		//System.out.println(pr);
		//getMaximumProfitMemoizationUtil(weights, profits, knapsack_capacity, 0);
		getMaximumProfitTabulation(weights, profits, knapsack_capacity);
	}
	
	//simple recursive solution
	public static int getMaximumProfitRecursive(int weights[],int profits[],int capacity,int start) {
		
		if(capacity<=0 || start>=weights.length)
			return 0;
		
		int inc=0;
		
		if(weights[start]<=capacity)
		inc= profits[start]+getMaximumProfitRecursive(weights,profits,capacity-weights[start],start+1);
		int exc= getMaximumProfitRecursive(weights,profits,capacity,start+1);
		
		System.err.println("inc:"+inc+"exc:"+exc);
		return Math.max(inc, exc);
		
		
	}

	//top down memoization solution
	/*Since we have two changing values (capacity and currentIndex) in our recursive function knapsackRecursive(), 
	 * we can use a two-dimensional array to store the results of all the solved sub-problems. As mentioned above, 
	 * we need to store results for every 
	 * sub-array (i.e. for every possible index ‘i’) and for every possible capacity ‘c’.
	 */
	
	//time complexity - O(N*C)
	public static int getMaximumProfitMemoization(int weights[],int profits[],int capacity,int start,int memoization[][]) {
		if(capacity<=0 || start>=weights.length)
			return 0;
		
		if(memoization[start][capacity]!=0)
			return memoization[start][capacity];
		
		int inc=0;
		if(weights[start]<=capacity)
			inc=profits[start]+getMaximumProfitMemoization(weights,profits,capacity-weights[start],start+1,memoization);
		int exc=getMaximumProfitMemoization(weights,profits,capacity,start+1,memoization);
		
		memoization[start][capacity]=Math.max(inc, exc);
		return memoization[start][capacity];
			
		
		
	}
	
	public static void getMaximumProfitMemoizationUtil(int weights[],int profits[],int capacity,int start) {
		int memoization[][]=new int[profits.length][capacity+1];
		for(int i=0;i<weights.length;i++) {
			for(int j=0;j<weights.length;j++)
				memoization[i][j]=0;
		}
		
		int res=getMaximumProfitMemoization(weights,profits,capacity,start,memoization);
		System.out.println(res);
		
		
	}
	
	//bottom up tabulation
	public static void getMaximumProfitTabulation(int weights[],int profits[],int capacity) {
		if(capacity<=0 || profits.length==0 || weights.length!=profits.length)
			return ;
		
		int n=profits.length;
		int [][] dp=new int[n][capacity+1];
		
		// populate the capacity=0 columns, with '0' capacity we have '0' profit
		for(int i=0;i<n;i++)
			dp[i][0]=0;
		
		// if we have only one weight, we will take it if it is not more than the capacity
		for(int c=0;c<=capacity;c++) {
			if(weights[0]<=c)
				dp[0][c]=profits[0];
			
		}
		
		// process all sub-arrays for all the capacities
	    for(int i=1; i < n; i++) {
	      for(int c=1; c <= capacity; c++) {
	        int profit1= 0, profit2 = 0;
	        // include the item, if it is not more than the capacity
	        if(weights[i] <= c)
	          profit1 = profits[i] + dp[i-1][c-weights[i]];
	        // exclude the item
	        profit2 = dp[i-1][c];
	        // take maximum
	        dp[i][c] = Math.max(profit1, profit2);
	      }
			
		
		
	}
	    
	 // maximum profit will be at the bottom-right corner.
	    System.out.println( dp[n-1][capacity]);
	}
}
