//O(n) time
//O(log(n)) space
//inorder traversal

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
            return null;
        }
        int len=0;
        ListNode cur=head;
        while(cur!=null){
            cur=cur.next;
            len++;
        }
        ArrayList<ListNode> list=new ArrayList<ListNode>();
        list.add(head);
        return helper(list,0,len-1);
        
    }
    private TreeNode helper(ArrayList<ListNode> list, int l, int r){
        if(l>r){
            return null;
        }
        int mid=(l+r)/2;
        TreeNode left=helper(list,l,mid-1);
        TreeNode root= new TreeNode(list.get(0).val);
        root.left=left;
        list.set(0,list.get(0).next);
        root.right=helper(list,mid+1,r);
        return root;
    }
    
}


//O(nlog(n)) time
//O(log(n)) space

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
            return null;
        }
        int len=0;
        ListNode cur=head;
        while(cur!=null){
            cur=cur.next;
            len++;
        }
        return helper(head,len);
        
    }
    private TreeNode helper(ListNode head, int len){
        if(len==0){
            return null;
        }
        ListNode node=head;
        int idx=(len-1)/2;
        while(idx!=0){
            node=node.next;
            idx--;
        }
        TreeNode root= new TreeNode(node.val);
        root.left=helper(head,(len-1)/2);
        root.right=helper(node.next,len/2);
        return root;
    }
    
}