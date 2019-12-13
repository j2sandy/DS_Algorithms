package io.nishandi.ds.array;

public class KadanesAlgo {
	
	public static void main(String[] args) {
		int arr[]={-2, -3, 4, -1, -2, 1, 5, -3};
		int arr1[]= {-9,-6,-1,-5};
		getMaximumSumSubArray(arr1);
	}
	
	public static void getMaximumSumSubArray(int arr[]) {
		
		int max_till_here=arr[0];
		int max_so_far=arr[0];
		
		for(int i=1;i<arr.length;i++) {
			max_till_here=Math.max(arr[i], arr[i]+max_till_here);
			max_so_far=Math.max(max_so_far, max_till_here);
		}
		
		System.out.println("Maximum sum subarray:"+max_so_far);
		
	}

}
