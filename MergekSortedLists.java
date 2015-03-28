//O(nklog(k)) runtime , n stands for maximum length of all lists, k stands number of lists.
//O(log(k)) space
//T(k)=2T(k/2)+O(n*k) master method -----> O(nklog(k))
//merge sort linked lists

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
 
 // Top-down 's space is O(log(k)), the Bottom-up's space is O(1)
/* Bottom-up 
 public ListNode mergeKLists(List<ListNode> lists) {
        for(int i = 1;i < lists.size();i *= 2)
            for(int j = 0;j+i < lists.size();j += 2*i)
                lists.set(j,mergeTwoLists(lists.get(j),lists.get(j+i)));
        return lists.size()==0?null:lists.get(0);
    }
	**/
	
	//Top-down
public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        if(lists==null||lists.size()==0)
            return null;
        return mergeSort(lists,0,lists.size()-1);
    }
    
    private ListNode mergeSort(List<ListNode> lists,int left, int right){
        if(left<right){
            int mid= (right+left)/2;
            return mergeList(mergeSort(lists,left,mid),mergeSort(lists,mid+1,right));
        }
        return lists.get(left);
    }
    
    private ListNode mergeList(ListNode l1, ListNode l2){
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode dummyhead=new ListNode(0);
        ListNode node=dummyhead;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                node.next=l1;
                l1=l1.next;
            }
            else{
                node.next=l2;
                l2=l2.next;
                
            }
            node=node.next;
        }
        if(l1!=null){
            node.next=l1;
        }
        if(l2!=null){
            node.next=l2;
        }
        return dummyhead.next;
    }
}

//O(nklog(k)) runtime , n stands for maximum length of all lists, k stands number of lists.
//O(k) space
//heap sort using a priorityQueue
//
public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        Queue<ListNode> heap = new PriorityQueue(new Comparator<ListNode>(){
            @Override public int compare(ListNode l1, ListNode l2) { 
                return l1.val - l2.val; 
            }
        });
        ListNode head = new ListNode(0), tail = head;
        for (ListNode node : lists) if (node != null) heap.offer(node);
        while (!heap.isEmpty()) {
            tail.next = heap.poll();
            tail = tail.next;
            if (tail.next != null) heap.offer(tail.next);
        }
        return head.next;
    }
}



