package io.nishandi.ds.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class HeapSort {
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(50);
		list.add(40);
		list.add(30);
		list.add(30);
		list.add(20);
		HeapSort hs=new HeapSort();
		hs.heapSort(list);
		
	}
	
	public static void heapSort(List<Integer> list){
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i:list)
			pq.add(i);
		
		list.clear();
		while(!pq.isEmpty()) {
			list.add(pq.poll());
		}
		
		for(int j:list)
			System.out.println(j);
			
	}
}
 