package io.nishandi.ds.array;

public class MinJumps {
    
    public static void main(String[] args) {
        int input_array[]={1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        MinJumps minJumps=new MinJumps();
        System.out.println(minJumps.getMinJumps(input_array));
    }

    public int getMinJumps(int []arr){
        
         int min_arr[]=new int[arr.length];
         min_arr[0]=0;
         
         for(int k=1;k<min_arr.length;k++)
        	 min_arr[k]=Integer.MAX_VALUE;
         for(int i=0;i<arr.length;i++) {
        	 if(min_arr[min_arr.length-1]!=Integer.MAX_VALUE)
        		 return min_arr[min_arr.length-1];
        	 for(int j=i+1;j<=i+arr[i] && j<arr.length;j++) {
        		 if(min_arr[min_arr.length-1]!=Integer.MAX_VALUE)
        			 return min_arr[min_arr.length-1];
        		 if(min_arr[j]!=Integer.MAX_VALUE)
        			 continue;
        		 if(arr[i]>0 && min_arr[j]>min_arr[i]+1)
        			 min_arr[j]=min_arr[i]+1;
        		 
        		System.out.println("min_Arr:"+min_arr[j]); 
        	 }
         }
         
         return min_arr[min_arr.length-1];
         

    }
	

}
