package io.nishandi.algo.backtracking;

import java.util.HashSet;

public class GraySum {

	public static void main(String[] args) {
		GraySum graysum=new GraySum();
		//graysum.grayCode(3);
		//System.out.println(graysum.getBinary(101));
		graysum.grayCode(3);
	}
	
	HashSet<Integer> hset=new HashSet<>();
	
	  public void grayCode(int a) {
	  
	  int [] arr=new int[a]; for(int i:arr) i=0;
	  
	  StringBuffer str=new StringBuffer();
	  for(int i=0;i<arr.length;i++)
		  str.append('0');
	  grayCodeGenerator(str,0);
	  
    }
	  
	public void grayCodeGenerator(StringBuffer str,int start)
	{
		if(hset.contains(Integer.parseInt(str.toString())))
			return;
		
		for(int i=start;i<str.length();i++)
		{
			
			grayCodeGenerator(str,i);
		}
	}
	 
	
	public int getBinary(int num)
	{
		String num1=String.valueOf(num);
		
		int res=0;
		
		for(int i=0;i<num1.length();i++)
		{
			if(num1.charAt(i)=='1')
			{
				res=(int) (res+Math.pow(2, num1.length()-1-i));
				
			}
		}
		
		return res;
		
	}

}
