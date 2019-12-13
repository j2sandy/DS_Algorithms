package io.nishandi.algo.sorting;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountingSort {
	
	public static void main(String[] args) {
		int arr[] = {1, 4, 1, 2, 7, 5, 2}; 
		  
        System.out.println("Given Array"); 
        printArray(arr); 
        CountingSort ob = new CountingSort(); 
        ob.sort(arr); 
  
        System.out.println("\nSorted array"); 
        printArray(arr); 
    
		
	}
	
	
	static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 

	static void sort(int [] arr) {
		
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        for(int i=0;i<arr.length;i++) {
        	if(hm.containsKey(arr[i]))
        		hm.put(arr[i], hm.get(arr[i])+1);
        	else
        		hm.put(arr[i], 1);
        }
        
        int sum=0;
        for(Map.Entry<Integer, Integer> e:hm.entrySet()) {
        	hm.put(e.getKey(), e.getValue()+sum);
        	sum=e.getValue();
        }
        
       		
        int new_arr[]=new int[arr.length];
        for(int i:arr) {
        	new_arr[hm.get(i)-1]=i;
        	hm.put(i, hm.get(i)-1);
        }
        
       System.out.println("sorted array:");
       for(int j:new_arr) {
    	   System.out.print(j+" ");
       }
		
	}
}
