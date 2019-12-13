package io.nishandi.ds.linkedlist;

public class LinkedListJava {
	
	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data=data;
			this.next=null;
		}
	static Node head1;
	static Node head2;
	public static void main(String[] args) {
		head1=new Node(10);
		head1.next=new Node(50);
		head1.next.next=new Node(90);
		head1.next.next.next=new Node(110);
		head1.next.next.next.next=new Node(120);
		head1.next.next.next.next.next=new Node(150);
		//head1.next.next.next.next.next=head1.next;
		//System.out.println(checkLoop(head1));
		
		head2=new Node(5);
		head2.next=new Node(12);
		head2.next.next=new Node(51);
		head2.next.next.next=new Node(130);
		//Node temp=reverseListIterative(head1);
		//Node temp=reverseListRecursive(head1);
		//printList(temp);
		reverseListRecursivly(head1);
		printList(head1);
			
		}
	
	public static void printList(Node head) {
		if(head==null)
			return;
		Node temp=head;
		while(temp!=null) {
			System.out.println(temp.data);
			temp=temp.next;
		}
	}
	
	public static boolean checkLoop(Node head1) {
		
		if(head1==null)
			return false;
		Node fast=head1,slow=head1;
		
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			
			if(slow==fast)
				return true;
		}
		return false;
	}
	
	public static Node reverseListIterative(Node head) {
		Node prev,next,curr;
		if(head==null || head.next==null)
			return head1;
		
		prev=null;
		curr=head;
		next=curr.next;
		while(curr!=null ) {
			System.out.println("curr:"+curr.data);
			curr.next=prev;
			prev=curr;
			curr=next;
			if(curr!=null)
				next=curr.next;
		}
		head=prev;
		return head;
		
	}
	
	public static Node reverseListRecursive(Node node) {
		if(node==null || node.next==null) 
			return node;
		Node temp=reverseListRecursive(node.next);
		node.next.next=node;
		node.next=null;
		return temp;
		
	}
	
	public static void reverseListRecursivly(Node node) {
		if(node.next==null) {
			head1=node;
			return;
		}
		
		reverseListRecursivly(node.next);
		node.next.next=node;
		node.next=null;
		
	}
	
	public static Node reverseListKGroup(Node head,int k) {
		   Node current = head; 
	       Node next = null; 
	       Node prev = null; 
	         
	       int count = 0; 
	  
	       /* Reverse first k nodes of linked list */
	       while (count < k && current != null)  
	       { 
	           next = current.next; 
	           current.next = prev; 
	           prev = current; 
	           current = next; 
	           count++; 
	       } 
	  
	       /* next is now a pointer to (k+1)th node  
	          Recursively call for the list starting from current. 
	          And make rest of the list as next of first node */
	       if (next != null)  
	          head.next = reverseListKGroup(next, k); 
	  
	       // prev is now head of input list 
	       return prev; 
		
	}
	
	
	
	public static void mergeSortedLL(Node head1,Node head2) {
		
	}
}

}
