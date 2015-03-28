//O(n) runtime
//O(1) space

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
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head==null||head.next==null)
            return head;
        ListNode smallHead=new ListNode(0);
        ListNode bigHead=new ListNode(0);
        ListNode smallnode=smallHead;
        ListNode bignode=bigHead;
        while(head!=null){
            if(head.val<x){
                smallHead.next=head;
                smallHead=smallHead.next;
            }
            else{
                bigHead.next=head;
                bigHead=bigHead.next;
            }
            head=head.next;
        }
        bigHead.next=null;
        smallHead.next=bignode.next;
        return smallnode.next;
    }
}





