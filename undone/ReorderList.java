//O(n) time
//O(1) space
// divide the list into two lists, reverse one list, merge the two lists into one list.
//also need to consider two ways of reverse the linked list, recursive method and iterative method.

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head==null||head.next==null){
            return;
        }
        ListNode runner = head;
        ListNode walker = head;
        while(runner.next!=null&&runner.next.next!=null){
            walker=walker.next;
            runner=runner.next.next;
        }
        ListNode head1=head;
        ListNode head2=walker.next;
        walker.next=null;
        head2=reverse(head2);
        head=merge(head1,head2);
        
    }
    private ListNode reverse(ListNode head){
        ListNode newHead=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=newHead;
            newHead=cur;
            cur=next;
        }
        return newHead;
    } 
    private ListNode merge(ListNode head1,ListNode head2){
        ListNode dummyHead=new ListNode(0);
        ListNode dummy=dummyHead;
        int idx=0;
        while(head1!=null&&head2!=null){
            if(idx%2==0){
                dummyHead.next=head1;
                head1=head1.next;
            }
            else{
                dummyHead.next=head2;
                head2=head2.next;
            }
            idx++;
            dummyHead=dummyHead.next;
        }
        if(head1!=null){
            dummyHead.next=head1;
        }
        else{
            dummyHead.next=head2;
        }
        return dummy.next;
    }
    
}
