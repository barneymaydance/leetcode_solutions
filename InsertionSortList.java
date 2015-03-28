//O(n^2)
//O(1)

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode dummyHead=new ListNode(0);
        while(head!=null){
            ListNode next=head.next;
            ListNode prev=dummyHead;
            while(prev.next!=null&&prev.next.val<head.val){
                prev=prev.next;
            }
            head.next=prev.next;
            prev.next=head;
            head=next;
        }
        return dummyHead.next;
    }
}
