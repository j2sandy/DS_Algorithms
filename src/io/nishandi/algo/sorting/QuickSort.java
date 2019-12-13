package io.nishandi.algo.sorting;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {
	
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
        QuickSort ob = new QuickSort(); 
        ob.sort(0, arr.length-1, arr); 
  
        System.out.println("\nSorted array"); 
        printArray(arr); 
    }

	private void sort(int low, int high, int[] arr) {
		
		if(low<high) {
			int pi=partition(low,high,arr);
			sort(low, pi-1, arr);
			sort(pi+1, high, arr);
			
		}
		
		
		
	}
	
	private int partition(int low,int high,int[] arr) {
		
		int pivot=arr[high];
		
		int i=low-1;
		
		for(int j=low;j<high;j++) {
			if(arr[j]<pivot) {
				i++;
				int temp=arr[j];
				arr[j]=arr[i];
				arr[i]=temp;
			}
		}
		
		int temp1=arr[i+1];
		arr[i+1]=arr[high];
		arr[high]=temp1;
		
		return i+1;
		
		
	}

}
