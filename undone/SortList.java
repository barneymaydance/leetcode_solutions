//O(nlog(n)) time
//O(log(n)) space
// use merge sort

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
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        return mergeSort(head);
    }
    private ListNode mergeSort(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode walker=head;
        ListNode runner=head;
        while(runner.next!=null&&runner.next.next!=null){
            walker=walker.next;
            runner=runner.next.next;
        }
        ListNode head1=head;
        ListNode head2=walker.next;
        walker.next=null;
        head1=mergeSort(head1);
        head2=mergeSort(head2);
        return merge(head1,head2);
    }
    private ListNode merge(ListNode head1,ListNode head2){
        ListNode dummyHead = new ListNode(0);
        ListNode dummy=dummyHead;
        while(head1!=null&&head2!=null){
            if(head1.val<head2.val){
                dummyHead.next=head1;
                head1=head1.next;
                
            }
            else{
                dummyHead.next=head2;
                head2=head2.next;
            }
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
