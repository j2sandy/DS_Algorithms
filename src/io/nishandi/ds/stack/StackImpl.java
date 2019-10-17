package io.nishandi.ds.stack;

import java.util.ArrayList;

public class StackImpl {
	ArrayList<Integer> arr;
	int capacity;
	
	public StackImpl(int capacity) {
		this.arr=new ArrayList<Integer>();
		this.capacity=capacity;
	}
	
	public int pop() {
		if(this.arr.size()==0)
			{
			   System.out.println("stack empty");
			   return Integer.MAX_VALUE;
			}
		else
			return arr.remove(arr.size()-1);
		
	}
	
	public void push(int value) {
		if(this.arr.size()==10)
			System.out.println("stack full");
		else
			this.arr.add(value);
	}
	
	public int peek() {
		if(this.arr.size()==0)
		{
		   System.out.println("stack empty");
		   return Integer.MAX_VALUE;
		}
		
		else
			return arr.get(arr.size()-1);
	}
	
	public void isEmpty() {
		
	}
	
	public int getSize() {
		return arr.size();
	}
	
	public static void main(String[] args) {
		StackImpl stack=new StackImpl(10);
		
	}

}
