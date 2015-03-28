// O(n) runtime, O(n+n)=O(2n)=O(n)
//O(1) space
//subroutine reverse a linked list


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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||k<=1)
            return head;
        ListNode dummyhead= new ListNode(0);
        dummyhead.next=head;
        ListNode pre= dummyhead;
        ListNode node= head;
        int count=0;
        while(node!=null){
            count++;
            ListNode end=node.next;
            if(count==k){
                pre=reverse(pre,node);
                count=0;
            }
            node=end;
        }
        return dummyhead.next;
    }
    
    private ListNode reverse(ListNode pre, ListNode end){
        ListNode cur=pre.next;
        while(pre.next!=end){
            ListNode next=cur.next;
            cur.next=next.next;
            next.next=pre.next;
            pre.next=next;
        }
        return cur;
    }
}