package io.nishandi.algo.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSum {

    static ArrayList<ArrayList<Integer>> res;
    public static void main(String args[])
    {
    	CombinationSum csum=new CombinationSum();
    	ArrayList<Integer> list=new ArrayList<>();
    	list.add(2);
    	list.add(3);
    	list.add(6);
    	list.add(7);
    	System.out.println(csum.combinationSum(list, 10));
    }
    
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        
        res = new ArrayList<>();
        ArrayList<Integer> unique = new ArrayList<>();
        
        if (A == null)
            return res;
            
        Collections.sort(A);
        
        unique.add(A.get(0));
        for (int i = 0; i < A.size(); i++) {
            if (i != 0 && A.get(i) != A.get(i - 1))
                unique.add(A.get(i));
        }
        
        combinationSum(unique, new ArrayList<>(), B, 0);
            
        return res;
        
    }
    
    
    public void combinationSum(ArrayList<Integer> A, ArrayList<Integer> res, int B, int index) {
        if (B == 0) {
            this.res.add(new ArrayList(res));
            return;
        }
        
        if (B < 0) {
            return;
        }
        for (int i = index; i < A.size(); i++) {
            int num = A.get(i);
            res.add(num);
            combinationSum(A, res, B - num, i);
            res.remove(res.size() - 1);
        }
        
    }

}
