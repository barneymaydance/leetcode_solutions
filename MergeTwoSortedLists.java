/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
 //O(m+n) runtime, m, n stand for the length of two Lists
 //O(1) space
 //use a dumb head to manipulate a linked list
 
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dumbhead=new ListNode(0);
        ListNode current=dumbhead;
        while(l1!=null&&l2!=null){
            if(l1.val>l2.val){
                current.next=new ListNode(l2.val);
                l2=l2.next;
            }
            else{
                current.next=new ListNode(l1.val);
                l1=l1.next;
            }
            current=current.next;
        }
        if(l1!=null){
            current.next=l1;
        }
        if(l2!=null){
            current.next=l2;
        }
        return dumbhead.next;
        
    }
}