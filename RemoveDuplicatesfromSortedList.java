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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode dummyhead=new ListNode(0);
        dummyhead.next=head;
        ListNode pre=head;
        head=head.next;
        while(head!=null){
            if(head.val==pre.val){
                head=head.next;
                pre.next=head;
            }
            else{
                head=head.next;
                pre=pre.next;
            }
        }
        return dummyhead.next;
    }
}

//modify simpler and shorter
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode node=head;
        while(node.next!=null){
            if(node.val==node.next.val){
                node.next=node.next.next;
            }
            else{
                node=node.next;
            }
        }
        return head;
    }
}
