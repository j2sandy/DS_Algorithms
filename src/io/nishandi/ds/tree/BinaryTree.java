package io.nishandi.ds.tree;

import java.util.Stack;

import io.nishandi.ds.tree.BinaryTree.Node;

public class BinaryTree {

	static class Node
	{
		Node left,right;
		int val;
		public Node(int val)
		{
			this.val=val;
			this.left=this.right=null;
		}
	}
	
	static Node root;
	public static void main(String[] args) {
		BinaryTree btree=new BinaryTree();
		root=new Node(10);
		root.left=new Node(20);
		root.right=new Node(30);
		root.left.left=new Node(40);
        root.left.right=new Node(50);
        root.right.left=new Node(60);
        root.right.right=new Node(70);
        
        //btree.recursiveInorder(root);
       // btree.iterativePreorder(root);
       // btree.recursivePreorder(root);
        btree.iterativePostorder(root);
        
	}
	
	public void iterativeInorder(Node root)
	{
		if(root==null)
			return;
		Stack<Node> stack=new Stack<>();
		
		Node current=root;
		while(!stack.isEmpty() || current!=null)
		{
			if(current!=null)
			{
				stack.push(current);
				current=current.left;
				continue;
			}
			
			current=stack.pop();
			System.out.println(current.val);
			current=current.right;
		}
		
	}
	
	public void recursiveInorder(Node root)
	{
		if(root==null)
			return;
		recursiveInorder(root.left);
		System.out.println(root.val);
		recursiveInorder(root.right);
		
	}
	
	public void iterativePreorder(Node root)
	{
		if(root==null)
			return;
		
		Stack<Node> stack =new Stack<>();
		stack.push(root);
		Node current=stack.peek();
		
		while(!stack.isEmpty())
		{
			if(current!=null)
			{
				stack.push(current);
				System.out.println(current.val);
				current=current.left;
				continue;
			}
			
			current=stack.pop();
			current=current.right;
			
			
		}
	}

	public void recursivePreorder(Node root)
	{
		if(root==null)
			return;
		System.out.println(root.val);
		recursivePreorder(root.left);
		recursivePreorder(root.right);
	}
	
	public void iterativePostorder(Node root)
	{
		if(root==null)
			return;
		
		Stack<Node> stack=new Stack<>();
		stack.push(root);
		Node current=root;
		while(!stack.isEmpty())
		{

			if(current!=null)
			{
				stack.push(current);
				current=current.left;
				continue;
			}
			
			
			
			current=stack.peek().right;
			if(current==null)
				{
				   
				   System.out.println(stack.pop().val);
				   if(!stack.isEmpty())
					   current=stack.peek().right;
				   
				}
			
			
		
			
			
		}
	}
	
	public void recursivePostorder(Node root)
	{
		if(root==null)
			return;
		recursivePostorder(root.left);
		System.out.println(root.val);
		recursivePostorder(root.right);
	}
	
}
