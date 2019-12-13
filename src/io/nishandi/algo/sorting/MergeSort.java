package io.nishandi.algo.sorting;

public class MergeSort {
	
	static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
  
    
    public static void main(String args[]) 
    { 
        int arr[] = {12, 11, 13, 5, 6, 7}; 
  
        System.out.println("Given Array"); 
        printArray(arr); 
        MergeSort ob = new MergeSort(); 
        ob.mergeSort(0, arr.length-1, arr); 
  
        System.out.println("\nSorted array"); 
        printArray(arr); 
    } 
	
	public void mergeSort(int low,int high,int arr[]) {
		if(low<high) {
			int mid=low + (high-low)/2;
			
			mergeSort(low,mid,arr);
			mergeSort(mid+1, high, arr);
			merge(low,high,mid,arr);
		}
	}
	
	public void merge(int low,int high,int mid,int arr[]) {
		
		int left_arr[]=new int[mid-low+1];
		int right_arr[]=new int[high-mid];
		
		//System.out.println(left_arr.length+" "+right_arr.length);
		for(int i=0;i<left_arr.length;i++)
			left_arr[i]=arr[low+i];
		
		for(int j=0;j<right_arr.length;j++)
			right_arr[j]=arr[mid+1+j];
		
		int k,l,m;
		for( k=0,l=0,m=low;k<left_arr.length && l<right_arr.length && m<=high;m++) {
			if(left_arr[k]<=right_arr[l])
				{
				arr[m]=left_arr[k];
				k++;
				
				}
			else
			{
				arr[m]=right_arr[l];
				l++;
				
			}
			
		}
		
		while(k<left_arr.length)
		{
			arr[m]=left_arr[k];
			k++;
			m++;
		}
		
		while(l<right_arr.length)
		{
			arr[m]=right_arr[l];
			l++;
			m++;
		}
		
		
		
	}
	

}
