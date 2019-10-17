package io.nishandi.ds.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
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
	
	static int tilt=0;
	static int max_level=0;
	static Node root;
	static ArrayList<Integer> arr1;
	static ArrayList<Integer> arr2;
	static ArrayList<Integer> arr3;
	public static void main(String[] args) {
		BinaryTree btree=new BinaryTree();
		root=new Node(10);
		root.left=new Node(20);
		root.right=new Node(30);
		root.left.left=new Node(40);
        root.left.right=new Node(50);
        //root.left.right.right=new Node(100);
        root.right.left=new Node(60);
        root.right.right=new Node(70);
        
        //btree.recursiveInorder(root);
       // btree.iterativePreorder(root);
       // btree.recursivePreorder(root);
        //btree.iterativePostorder(root);
        //System.out.println(btree.getHeightRecursive(root));
        //btree.levelOrderTraversalIterative(root);
        //btree.levelOrderTraversaslUtil(root);
        //btree.levelOrderTraversalWithStacks(root);
        //btree.zigZagTraversalRecursiveUtil(root);
        arr1=new ArrayList<Integer>();
        arr2=new ArrayList<Integer>();
        arr3=new ArrayList<Integer>();
		
        //btree.lcaBinaryTree(50, 60);
        //btree.twoNodeDistance(60, 70);
        //btree.getWidthIterative(root);
        btree.getTiltTree(root);
        System.out.println(tilt);
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
	
	public int getHeightRecursive(Node root) {
		if(root==null)
			return 0;
		int l_height=getHeightRecursive(root.left);
		int r_height=getHeightRecursive(root.right);
		return Math.max(l_height, r_height)+1;
	}
	
	 
	
	public void levelOrderTraversalIterative(Node root) {
		if(root==null)
			return;
		Queue<Node> queue=new LinkedList<Node>();
		queue.add(root);
		Node current = root;
		while(!queue.isEmpty()) {
			 current=queue.poll();
			 System.out.println(current.val);
			 if(current.left!=null)
				 queue.add(current.left);
			 if(current.right!=null)
				 queue.add(current.right);
		}
		
		
	}
	
	public void levelOrderTraversaslUtil(Node root) {
		int height=getHeightRecursive(root);
		for(int i=0;i<height;i++)
			levelOrderTraversalRecursive(root,i);
	}
	public void levelOrderTraversalRecursive(Node root,int level) {
		
		if(root==null)
			return;
		
		if(level==0)
			{
			System.out.println(root.val);
			return;
			}
		
		levelOrderTraversalRecursive(root.left,level-1);
		levelOrderTraversalRecursive(root.right,level-1);
		
	}
	
	public void zigZagTraversalWithStacks(Node root) {
		if(root==null)
			return;
		Stack<Node> current_level = new Stack<>();
		Stack<Node> next_level = new Stack<>();
		current_level.add(root);
		Node current;
		boolean flag=true;
		while(!current_level.isEmpty()) {
			current=current_level.pop();
			System.out.println(current.val);
			if(flag) {
			if(current.left!=null)
				next_level.add(current.left);
			if(current.right!=null)
				next_level.add(current.right);
			}
			else {
				if(current.right!=null)
					next_level.add(current.right);
				if(current.left!=null)
					next_level.add(current.left);
			}
			if(current_level.isEmpty())
			{
				Stack<Node> temp = current_level;
				current_level=next_level;
				next_level=temp;
				flag=!flag;
			}
			
			
		}
		
		
	}
	
	public void zigZagTraversalRecursiveUtil(Node root) {
		if(root==null)
			return;
		
		int height=getHeightRecursive(root);
		boolean flag=true;
		for(int i=0;i<height;i++) {
			zigZagTraversalRecursive(root,i,flag);
			flag=!flag;
		}
			
	}
	
	public void zigZagTraversalRecursive(Node root,int level,boolean flag) {
		if(root==null)
			return;
		
		if(level==0)
			System.out.println(root.val);
		if(flag) {
			zigZagTraversalRecursive(root.left,level-1,flag);
			zigZagTraversalRecursive(root.right,level-1,flag);
		}
		else {
			zigZagTraversalRecursive(root.right,level-1,flag);
			zigZagTraversalRecursive(root.left,level-1,flag);
		}
		
	}
	
	public void leftViewUtil(Node root) {
		leftViewTree(root,1);
	}
	public void leftViewTree(Node root,int level) {
		if(root==null)
			return;
		
		if(max_level<level) {
			System.out.println(root.val);
			max_level=level;
		}
		
		leftViewTree(root.left,level+1);
		leftViewTree(root.right, level+1);
		
	}
	
	public void rightViewUtil(Node root) {
		rightViewTree(root,1);
	}
	
	public void rightViewTree(Node root,int level) {
		if(root==null)
			return;
		if(max_level<level)
		{
			max_level=level;
			System.out.println(root.val);
		}
		
		leftViewTree(root.right, level+1);
		leftViewTree(root.left, level+1);
		
	}
	
	public int getDiameterTree(Node root) {
		if(root==null)
			return 0;
		int l_height=getHeightRecursive(root.left);
		int r_height=getHeightRecursive(root.right);
		
		int l_diameter=getDiameterTree(root.left);
		int r_diameter=getDiameterTree(root.right);
		return Math.max(l_height+r_height+1,Math.max(l_diameter, r_diameter));
	}
	
	public boolean ifNodeExists(Node root,int n1) {
		if(root==null)
			return false;
		
		if(root.val==n1)
			return true;
		
		if(ifNodeExists(root.left,n1) || ifNodeExists(root.right,n1))
			return true;
		else
			return false;
	}
	
	public ArrayList<Integer> rootToNodePath(Node root,int n1,ArrayList<Integer> arr ) {
		if(root==null)
			return arr;
		if(root.val==n1)
			{
			   arr.add(n1);
			   return arr;
			}
		
		arr.add(root.val);
		
		if(ifNodeExists(root.left, n1))
			rootToNodePath(root.left,n1,arr);	
		else if(ifNodeExists(root.right, n1))
			rootToNodePath(root.right, n1,arr);
		else
		arr.remove(arr.size()-1);
		
		return arr;
			
	}
	
	public int lcaBinaryTree(int n1,int n2) {
		
		arr1=rootToNodePath(root, n1, arr1);
		arr2=rootToNodePath(root, n2, arr2);
		int i,j;
		for(i=0,j=0;i<arr1.size() && j<arr2.size();i++,j++) {
			if(arr1.get(i)==arr2.get(j))
				continue;
			else
				break;
		}
		
		System.out.println("lca of n1,n2:"+arr1.get(i-1));
		return arr1.get(i-1);
		
	}
	
	
	public int twoNodeDistance(int n1,int n2) {
		ArrayList<Integer> arr4=new ArrayList<Integer>();
		ArrayList<Integer> arr5=new ArrayList<Integer>();
		arr4=rootToNodePath(root, n1, arr4);
		arr5=rootToNodePath(root, n2, arr5);
		int lca=lcaBinaryTree(n1, n2);
		arr3=rootToNodePath(root, lca, arr3);
		//System.out.println(arr4.size()+":"+arr5.size()+":"+arr3.size());
		int dist=(arr4.size()+arr5.size()-2)-(2*(arr3.size()-1));
		System.out.println("distance between two nodes:"+dist);
		return dist;
	}
	
	//total number of nodes at the level which contains maximum nodes is called width of tree
	public int getWidthIterative(Node root) {
		if(root==null)
			return 0;
		
		int curr_width=1;
		Queue<Node> queue=new LinkedList<BinaryTree.Node>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			int count=queue.size();
			System.out.println("curr level count:"+count);
			for(int i=0;i<count;i++ ) {
				Node temp=queue.poll();
				if(temp.left!=null)
					queue.add(temp.left);
				if(temp.right!=null)
					queue.add(temp.right);
			}
			count=queue.size();
			System.out.println("next level count:"+count);
			if(count>curr_width)
				curr_width=count;
		}
		System.out.println("tree width:"+curr_width);
		return curr_width;
		
	}
	
	
		
	public int getTiltTree(Node root) {
		if(root==null)
			return 0;
		
		int l_sum=getTiltTree(root.left);
		int r_sum=getTiltTree(root.right);
		
		tilt=tilt+Math.abs(l_sum-r_sum);
		return l_sum+r_sum+root.val;
		
	}
}
