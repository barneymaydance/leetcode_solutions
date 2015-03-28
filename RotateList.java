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
 //use two pointers
 // when n is bigger than the  linkedlist length, n=n%list.length
  
public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if (n==0||head==null||head.next==null)
            return head;
        ListNode dummyhead= new ListNode(0);
        dummyhead.next=head;
        ListNode p=head;
        int idx=0;
        while(head!=null&&idx<n){
            head=head.next;
            idx++;
        }
        if(head==null){
            n%=idx;
            head=dummyhead.next;
            idx=0;
            while(head!=null&&idx<n){
                head=head.next;
                idx++;
            }
        }
        while(head.next!=null){
            p=p.next;
            head=head.next;
            
        }
        head.next=dummyhead.next;
        head=p.next;
        p.next=null;
        return head;
    }
}