package io.nishandi.ds.array;

public class NextGreaterNumber {

	public static void main(String[] args) {
		
      int number=54190;
      getNextGreaterWithSameDigits(number);

	}
	
	public static void getNextGreaterWithSameDigits(int number) {
		String str=String.valueOf(number);
		int arr[]=new int[str.length()];
		for(int i=0;i<str.length();i++)
		{
			arr[i]=number%10;
			number=number/10;
		}
		
		
		for(int j:arr)
			System.out.print(j+" ");
		
		if(isSorted(arr))
			{
			   System.out.println("already largest");
			   return;
			}
		
		for(int k=0;k<arr.length-1;k++) {
			for(int l=k+1;l<arr.length;l++) {
				if(arr[l]<arr[k])
				{
					System.out.println("swapping "+arr[l]+" and "+arr[k]);
					return;
				}
			}
		}
		
		return;
		
		
	}

	public static boolean isSorted(int arr[]) {
		int curr=arr[0];
		for(int i=1;i<arr.length;i++) {
			if(curr<arr[i]) {
				curr=arr[i];
				continue;
			}
			else
				return false;
		}
		
		return true;
	}
}
