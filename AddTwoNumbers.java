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
 // consider to decide the final carry digit
//consider the special case when one of the two list is empty 
 
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return null;
        }
        ListNode head=new ListNode((l1.val+l2.val)%10);
        ListNode pointer=head;
        int carry=(l1.val+l2.val)/10;
        while(l1.next!=null&&l2.next!=null){
            l1=l1.next;
            l2=l2.next;
            int sum=l1.val+l2.val+carry;
            carry=sum/10;
            pointer.next=new ListNode(sum%10);
            pointer=pointer.next;
           
        }
        while(l1.next!=null){
            l1=l1.next;
            int sum=l1.val+carry;
            carry=sum/10;
            pointer.next=new ListNode(sum%10);
            pointer=pointer.next;
         
        }
        while(l2.next!=null){
            l2=l2.next;
            int sum=l2.val+carry;
            carry=sum/10;
            pointer.next=new ListNode(sum%10);
            pointer=pointer.next;
           
        }
        if (carry!=0){
            pointer.next=new ListNode(1);
        }
        return head;
        
    }
}