package io.nishandi.ds.heap;

import java.util.Vector;

public class MinHeap {

	private static Vector<Integer> A;
	
	public MinHeap()
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
		
		int curr_min=A.get(0);
			swap(0,A.size()-1);
			heapifyDown(0);
			return curr_min;
		
	}
	public void heapifyDown(int i) {
		
		int leftChild=getLeftChild(i);
		int rightChild=getRightChild(i);
		int smallest=i;
		
		if(i<A.size() && A.get(i)>A.get(leftChild))
			smallest=leftChild;
		if(i<A.size() && A.get(smallest)>A.get(rightChild))
			smallest=rightChild;
		
		if(smallest!=i)
		{
			swap(i,smallest);
			heapifyDown(smallest);
		}
		
	}

	public void heapifyUp(int i) {
		if(A.get(getParent(i)) > A.get(i))
		{
			swap(i,getParent(i));
			heapifyUp(getParent(i));
		}
		
	}
	
	public int getCurrMin()
	{
		if(A.size()!=0)
			return A.get(0);
		else return Integer.MIN_VALUE;
	}

	public static void main(String[] args) {
		MinHeap minheap=new MinHeap();
		minheap.add(4);
		minheap.add(10);
		minheap.add(2);
		minheap.add(6);
		minheap.add(1);
        System.out.println(minheap.getCurrMin());
        System.out.println(A);
	}

}
