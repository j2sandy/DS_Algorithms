package io.nishandi.algo.dp;

/* Characteristics of Dynamic Programming
 * 1.  Overlapping Subproblems
 * Subproblems are smaller versions of the original problem. Any problem has 
 * overlapping sub-problems if finding its solution involves solving the same subproblem multiple times.
 * 
 * 2.Optimal Substructure Property
Any problem has optimal substructure property if its 
overall optimal solution can be constructed from the optimal solutions of its subproblems.
 */

/* Dynamic Programming Methods
 * 1. Top-down with Memoization
In this approach, we try to solve the bigger problem by recursively finding the solution to smaller sub-problems. 
Whenever we solve a sub-problem, we cache its result so that we don’t end up solving it repeatedly 
if it’s called multiple times. Instead, we can just return the saved result. This technique 
of storing the results of already solved subproblems is called Memoization.


2. Bottom-up with Tabulation
Tabulation is the opposite of the top-down approach and avoids recursion. In this approach, 
we solve the problem “bottom-up” (i.e. by solving all the related sub-problems first). This is typically done by 
filling up an n-dimensional table. Based on the results in the table, 
the solution to the top/original problem is then computed.

Tabulation is the opposite of Memoization, as in Memoization we solve the problem 
and maintain a map of already solved sub-problems. In other words, in memoization, 
we do it top-down in the sense that we solve the top problem first (which typically recurses down 
to solve the sub-problems).
 */



public class FibonacciDp {
	
	public static void main(String[] args) {
		System.out.println("simple recursive:"+calculateFibonacci(5));
		System.out.println("top down memoization:"+calculateFibonacciUtil(5));
		System.out.println("bottom up tabulation:"+calculateFibonacciTabulation(5));
	}
	
	//simple recursive no dp
	public static int calculateFibonacci(int n) {
		if(n<2)
			return n;
		else
			return calculateFibonacci(n-1)+calculateFibonacci(n-2);
		
	}
	
	//top down with memoization
	public static int calculateFibonacciUtil(int n) {
		int memoization[] = new int[n+1];
		return calculateFibonnaciMemoization(memoization,n);
	}

	public static int calculateFibonnaciMemoization(int[] memoization, int n) {
		if(n<2)
			return n;
		
		if(memoization[n]!=0)
			return memoization[n];
		
		memoization[n]=calculateFibonnaciMemoization(memoization,n-1)+calculateFibonnaciMemoization(memoization, n-2);
		return memoization[n];
				
	}
	
	//bottom up with tabulation
	public static int calculateFibonacciTabulation(int n) {
		int dp[]=new int[n+1];
		dp[0]=0;
		dp[1]=1;
		
		for(int i=2;i<=n;i++)
			dp[i]=dp[i-1]+dp[i-2];
		
		return dp[n];
		
		
	}
	
	
	

}
