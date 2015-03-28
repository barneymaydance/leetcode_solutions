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
 
 //O(n) runtime
 //O(1) space
 // use a dummy head
 
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode point=new ListNode(0);
        point.next=head;
        head=point;
        while(point.next!=null&&point.next.next!=null){
            ListNode temp=point.next.next.next;
            point.next.next.next=point.next;
            point.next=point.next.next;
            point.next.next.next=temp;
            point=point.next.next;
        }
        return head.next;
       
    }
}