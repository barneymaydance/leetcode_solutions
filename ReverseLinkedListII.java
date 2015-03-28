//O(n) time
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null)
            return head;
        ListNode dummyHead= new ListNode(0);
        dummyHead.next=head;
        ListNode prev=dummyHead;
        int idxPrev=1;
        ListNode end=head;
        int idxTail=1;
        while(idxPrev<m){
            prev=prev.next;
            idxPrev++;
        }
        while(idxTail<n){
            end=end.next;
            idxTail++;
        }
        ListNode node=prev.next;
        while(node!=end){
            ListNode next=node.next;
            node.next=end.next;
            end.next=node;
            prev.next=next;
            node=prev.next;
        }
        return dummyHead.next;
    }
}

