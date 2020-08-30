package io.nishandi.ds.stack;

import java.util.Stack;

public class RemoveBracketsFromExpression {
	
	public static void main(String[] args) {
		String expr="a+b-(c+d-(e+f))";
		String expr1="a+b-(c+d)+e+f";
		System.out.println(getExpression(expr));
		
	}
	
	public static String getExpression(String expression) {
		
		Stack<Character> st=new Stack<>();
		String result="";
		
		for(int i=0;i<expression.length();i++) {
			System.out.println(result);
			if(expression.charAt(i)!='(' && expression.charAt(i)!=')' 
					&& expression.charAt(i)!='+' && expression.charAt(i)!='-')
				result=result+expression.charAt(i);
			
			else if(expression.charAt(i)=='(')
			    st.add(result.charAt(result.length()-1));
			
			
			else if(expression.charAt(i)==')')
				st.pop();
			
			else if(expression.charAt(i)=='+' || expression.charAt(i)=='-')
				{
				if(st.isEmpty())
					result=result+expression.charAt(i);
				
				else if(st.peek()=='+')
				   result=result+expression.charAt(i);
				  
				else
				  {
					if(expression.charAt(i)=='-')
					result=result+'+';
					
					else
						result=result+'-';
					  
				  }
				}
			
				
		}
		return result;
		
	}

}
