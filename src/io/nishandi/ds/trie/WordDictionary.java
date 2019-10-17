package io.nishandi.ds.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordDictionary {
	
	
	public static void main(String[] args) {
		String[] dictionary= {"a", "banana", "app", "appl", "ap", "apply", "apple"};
		Arrays.parallelSort(dictionary);
		List<String> res=getLongestWords(dictionary);
		for(String str:res)
			System.out.println(str);
		
		/*
		 * Trie trie=new Trie(); trie.insert("a"); trie.insert("banana");
		 * trie.insert("app"); trie.insert("appl"); trie.insert("ap");
		 * trie.insert("apply"); trie.insert("apple");
		 * System.out.println(trie.search("banana"));
		 */
		
		TrieUsingMap trie1=new TrieUsingMap();
		trie1.insert("a");
		trie1.insert("banana");
		trie1.insert("app");
		trie1.insert("appl");
		trie1.insert("ap");
		trie1.insert("apply");
		trie1.insert("apple");
		System.out.println(trie1.search("banan"));
		
	}
	
	public static List<String> getLongestWords(String [] dict) {
		List<String> list=new ArrayList<String>();
		if(dict.length==0)
			return list;
		
		if(dict.length==1)
		{
			list.add(dict[0]);
			return list;
		}
		
		Set<String> set=new HashSet<String>();
		for(String str:dict)
			set.add(str);
		
		for(int i=dict.length-1;i>=0;i--) {
			boolean flag=true;
			String curr=dict[i];
			for(int j=0;j<curr.length()-1;j++) {
				String substr=curr.substring(0, j+1);
				if(set.contains(substr))
				{
					continue;
				}
				else
				{
					flag=false;
					break;
				}
			}
			if(flag)
				{
				list.add(curr);
				break;
				}
		}
		return list;	
		
	}
	
	
	
}

//space complexity = O(N*M*C) N=no of strings,M=highest length string , C=size of alphabet(26)
class Trie{
	private static final int CHAR_SIZE=26;
	boolean isLeaf;
	List<Trie> children=null;
	
	Trie(){
		isLeaf=false;
		children=new ArrayList<Trie>();
		for(int i=0;i<CHAR_SIZE;i++) {
			children.add(null);
		}
	}
	
	public void insert(String key) {
		System.out.println("Inserting key:"+key);
		Trie curr=this;
		
		for(int i=0;i<key.length();i++) {
			if(curr.children.get(key.charAt(i)-'a')==null)
				curr.children.set(key.charAt(i)-'a', new Trie());
			
			curr=curr.children.get(key.charAt(i)-'a');
				
		}
		curr.isLeaf=true;
	}
	
	public boolean search(String key) {
		System.out.println("Searching key:"+key);
		
		Trie curr=this;
		for(int i=0;i<key.length();i++) {
			curr=curr.children.get(key.charAt(i)-'a');
			if(curr==null)
				return false;
			
		}
		
		return curr.isLeaf;
		
	}
}

//space efficient implementation = O(N*M)
class TrieUsingMap{
	
	private class TrieNode{
		Map<Character,TrieNode> children;
		boolean endOfWord;
		public TrieNode() {
			endOfWord=false;
			children=new HashMap<Character, TrieUsingMap.TrieNode>();
		}
		
	}
	
	private final TrieNode root;
	public TrieUsingMap() {
		this.root=new TrieNode();
	}
	
	public void insert(String key) {
		System.out.println("Inserting key:"+key);
		TrieNode current=root;
		for(int i=0;i<key.length();i++) {
			char ch=key.charAt(i);
			TrieNode node=current.children.get(ch);
			if(node==null) {
				node=new TrieNode();
				current.children.put(ch, node);
			}
			current=node;
		}
		
		current.endOfWord=true;
	}
	
	public boolean search(String key) {
		System.out.println("Searching key:"+key);
		TrieNode current=root;
		for(int i=0;i<key.length();i++) {
			char ch=key.charAt(i);
			if(current.children.containsKey(ch))
				current=current.children.get(ch);
			else
				return false;
		}
		
		if(current.endOfWord)
			return true;
		return false;
	}
	
    public String getLongestWordsUsingTrie(String[] dict) {
		
		TrieUsingMap trie=new TrieUsingMap();
		for(String str:dict) {
			trie.insert(str);
		}
		
		TrieNode current=this.root;
        
		
		return null;
	}
    
    public String dfsTrie(TrieNode root, String str ) {
    	if(root==null)
    		return null;
    }
    
    
}


















