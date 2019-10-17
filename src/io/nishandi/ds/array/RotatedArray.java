package io.nishandi.ds.array;

public class RotatedArray {

	public static void main(String[] args) {
		int[] rot_arr1= {4,5,6,1,1,2,3,3};
		int[] rot_arr2= {1,2,3,4,5,6};
		int[] rot_arr3= {3,4,5,1,2,3};
		int[] rot_arr4= {1,1,2,3,4,5};
		getMin(rot_arr1, rot_arr1.length);
		//getMin(rot_arr2, rot_arr2.length);
		//getMin(rot_arr3, rot_arr3.length);
		//getMin(rot_arr4, rot_arr4.length);

	}

	public static void getMin(int arr[],int len) {
		int low=0,high=len-1;
		
		if(len==0)
			System.out.println("empty array");
		
		if(low==high)
			System.out.println("single element array:"+arr[0]);
		
		while(high>=low)
		{
			if(low==high)
			{
				System.out.println("min element:"+arr[low]);
				break;
			}
			
			int mid=low+ (high-low)/2;
			//System.out.println("low:"+low+"mid:"+mid+"high:"+high);
			if(mid-1>=0 && arr[mid-1]>=arr[mid])
				{
				  System.out.println("min element:"+arr[mid]);
				  break;
				}
			
			else if(mid+1<len && arr[mid+1]<=arr[mid])
			{
				System.out.println("min element:"+arr[mid+1]);
				break;
			}
			else if(mid+1<len && arr[mid+1]>arr[mid])
			    high=mid;
			
			else if(mid-1>=0 && arr[mid-1]<arr[mid])
				low=mid;
		}
		
	}
}
