package io.nishandi.ds.linkedlist;import java.awt.List;

public class Solution {
	
	static class ListNode {
	   int val;
	   ListNode next;
	   ListNode(int x) { val = x; }
	 }
	
	public static void main(String[] args) {
		ListNode head1 = new ListNode(3);
		head1.next = new ListNode(7);
		//head1.next.next = new ListNode(3);
		
		ListNode head2 = new ListNode(9);
		head2.next = new ListNode(2);
		//head2.next.next = new ListNode(4);
		
		Solution sol = new Solution();
		
		
		ListNode head = sol.addTwoNumbers(head1, head2);
		sol.printList(head);
		
		
		
	}
	
	public void printList(ListNode head) {
		while(head!=null)
		{
			System.out.println(head.val);
			head=head.next;
		}
		
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        if(l1==null && l2==null)
        	return head;
        
        if(l1==null)
        	return l2;
        
        if(l2==null)
        	return l1;	
        
        head = new ListNode((l1.val+l2.val)%10);
        ListNode temp=head;
        boolean carry = l1.val + l2.val >9 ?true:false;
        l1=l1.next;
        l2=l2.next;
        
        while(l1!=null || l2!=null) {
        	if(l1!=null) {
        		if(l2!=null) {
        			if(carry)
        				{
        				    temp.next=new ListNode((l1.val+l2.val+1)%10);
        				    carry=l1.val + l2.val+1 >9 ?true:false;
        				}
        			else
        				{
        				    temp.next=new ListNode((l1.val+l2.val)%10);
        				    carry=l1.val + l2.val >9 ?true:false;
        				}
        			
        			l1=l1.next;
        			l2=l2.next;
        			temp=temp.next;
        		}
        		else {
        			if(carry)
        				{
        				   temp.next=new ListNode((l1.val+1)%10);
        				   carry= l1.val + 1 >9 ?true:false;
        				}
        			else
        				temp.next=new ListNode(l1.val);
        			l1=l1.next;
        			temp=temp.next;
        			
        		}
        	}
        	
        	else {
        		
        			if(carry)
        				{
        				   temp.next=new ListNode((l2.val+1)%10);
        				   carry = l2.val + 1 >9 ?true:false;
        				}
        			else
        				temp.next=new ListNode((l2.val)%10);
        			l2=l2.next;
        		    temp=temp.next;
        		
        		}
        	
        }
        
        if(carry) {
        	temp.next=new ListNode(1);
        }
        
        return head;
        
        
        
    }
	 

}
