//O(n) time
//O(1) space
//need to judge node!=null and node.next!-=null

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode dummyhead=new ListNode(0);
        dummyhead.next=head;
        ListNode prev=dummyhead;
        while(head!=null){
            while(head.next!=null&&head.val==head.next.val){
                    head=head.next;
            }
            if(prev.next==head){
                prev=prev.next;
            }
            else{
                prev.next=head.next;
            }
            head=head.next;
        }
        return dummyhead.next;
    }
}