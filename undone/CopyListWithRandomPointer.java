//O(n) time 
//O(n) space, could be O(1) space
// Hashtable to map
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null){
            return null;
        }
        RandomListNode copy=new RandomListNode(head.label);
        HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        map.put(head,copy);
        RandomListNode newHead=copy;
        while(head!=null){
            RandomListNode r=head.random;
            RandomListNode n=head.next;
            if(n!=null&&!map.containsKey(n)){
                map.put(n,new RandomListNode(n.label));
            }
            copy.next=map.get(n);
            if(r!=null&&!map.containsKey(r)){
                map.put(r,new RandomListNode(r.label));
            }
            copy.random=map.get(r);
            copy=copy.next;
            head=head.next;
        }
        return newHead;
    }
}


