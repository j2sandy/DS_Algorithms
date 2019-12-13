package io.nishandi.algo.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		String str1="nitin";
		String str2="banana";
		
		List<String> list=new ArrayList<>();
		List<String> list1=new ArrayList<>();
		getAllSubstrings(str1, list);
		
		Collections.sort(list, Comparator.comparing(String::length));
		
		list.stream().forEach(System.out::println);
		
		getAllSubstringsRecursive(str2, 0, list1);
		
		Collections.sort(list1, Comparator.comparing(String::length));
		
		list1.stream().forEach(System.out::println);

	}
	
	public static void getAllSubstrings(String str,List<String> list) {
		
		for(int start=0;start<str.length();start++) {
			for(int end=start;end<str.length();end++) {
				list.add(str.substring(start,end+1));
			}
		}
		
		
	}
	
	public static void getAllSubstringsRecursive(String str,int start,List<String> list) {
		for(int i=start;i<str.length();i++) {
			list.add(str.substring(start,i+1));
		}
		
		if(start<str.length())
		getAllSubstringsRecursive(str,start+1,list);
		
	}

}
