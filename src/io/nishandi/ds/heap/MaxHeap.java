package io.nishandi.ds.heap;

import java.util.Vector;

public class MaxHeap {

	private static Vector<Integer> A;
	
	public MaxHeap()
	{
		A=new Vector<>();
	}
	
	
	public int getParent(int i)
	{
		if(i==0)
			return 0;
		else
			return (i-1)/2;
	}
	
	public int getLeftChild(int i)
	{
		return 2*i+1;
	}
	
	public int getRightChild(int i)
	{
		return 2*i+2;
	}
	
	public void swap(int x,int y)
	{
		int temp=A.get(x);
		A.set(x, A.get(y));
		A.set(y, temp);
	}
	
	public void add(int ele)
	{
		A.add(ele);
		heapifyUp(A.size()-1);
	}
	
	public int poll()
	{
		if(A.size()==0)
		{
			System.out.println("heap empty");
			return Integer.MAX_VALUE;
		}
		
		int curr_max=A.get(0);
			swap(0,A.size()-1);
			heapifyDown(0);
			return curr_max;
		
		
		
	}
	private void heapifyDown(int i) {
		
		int leftChild=getLeftChild(i);
		int rightChild=getRightChild(i);
		int largest=i;
		
		if(i<A.size() && A.get(i)<A.get(leftChild))
			largest=leftChild;
		if(i<A.size() && A.get(largest)<A.get(rightChild))
			largest=rightChild;
		
		if(largest!=i)
		{
			swap(i,largest);
			heapifyDown(largest);
		}
		
	}

	private void heapifyUp(int i) {
		if(A.get(getParent(i)) < A.get(i))
		{
			swap(i,getParent(i));
			heapifyUp(getParent(i));
		}
		
	}
	
	private int getCurrMax()
	{
		if(A.size()!=0)
			return A.get(0);
		else return Integer.MAX_VALUE;
	}

	public static void main(String[] args) {
		MaxHeap maxheap=new MaxHeap();
		maxheap.add(4);
		maxheap.add(10);
		maxheap.add(2);
		maxheap.add(6);
		maxheap.add(1);
        System.out.println(maxheap.getCurrMax());
        System.out.println(A);
	}

}
