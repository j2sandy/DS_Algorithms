package io.nishandi.ds.trie;

import java.util.HashMap;


class TrieImpl{
	
	private class TrieNode{
		
		HashMap<Character,TrieImpl.TrieNode> children;
		boolean endOfWord;
		public TrieNode() {
			children=new HashMap<Character, TrieImpl.TrieNode>();
			endOfWord=false;
		}
		
	}
	
	 private final  TrieNode root;
	 
	 public TrieImpl() {
		this.root=new TrieNode();
	}
	
	public  void insert(String str) {
		System.out.println("inserting key:"+str);
		
		
		TrieNode curr=root;
		
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			TrieNode node=curr.children.get(ch);
			if(node==null) {
				node =new TrieNode();
				curr.children.put(ch, node);
			}
			curr=node;
			
		}
		curr.endOfWord=true;
			
	}
	
	public  boolean search(String str) {
		
		TrieNode curr=root;
		
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			
			TrieNode node=curr.children.get(ch);
			
			if(node!=null)
				curr=node;
			
			else return false;
			
		}
		
		if(curr.endOfWord==true)
			return true;
		else
			return false;
		
		
	}
	
	public  void getDistinctRows(String str[]) {
		int count=0;
		for(int i=0;i<str.length;i++) {
			if(search(str[i]))
				continue;
			else
				{
				insert(str[i]);
				count++;
				}
		}
		
		System.out.println("no of dixtinct rows:"+count);
		
	}
	
	
}

class DistinctRowMatrix{
	public static void main(String[] args) {
		String[] dictionary= {"101", "100", "100", "001", "011", "100"};
		TrieImpl trie=new TrieImpl();
		trie.getDistinctRows(dictionary);
		/*
		 * trie.insert("101"); trie.insert("100"); trie.insert("101");
		 * trie.search("101");
		 */
	}
}


