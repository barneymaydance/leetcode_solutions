//O(n) time
//O(1) space

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null){
            return;
        }
        TreeLinkNode start,curNode,nextNode;
        while(root!=null){
            ArrayList<TreeLinkNode> list=new ArrayList<TreeLinkNode>();
            list.add(root);
            start=findStartNodeNextLevel(list);
            curNode=start;
            nextNode=findNextNodeNextLevel(list,start);
            while(nextNode!=null){
                curNode.next=nextNode;
                curNode=nextNode;
                nextNode=findNextNodeNextLevel(list,curNode);
            }
            root=start;
        }    
    }
    private TreeLinkNode findNextNodeNextLevel(ArrayList<TreeLinkNode> list,TreeLinkNode start){
        TreeLinkNode root=list.get(0);
        if(root.left==start&&root.right!=null){
            return root.right;
        }
        while(root.next!=null){
            root=root.next;
            list.set(0,root);
            if(root.left!=null&&root.left!=start){
                return root.left;
            }
            if(root.right!=null&&root.right!=start){
                return root.right;
            }
        }
        return null;
    }
    
    private TreeLinkNode findStartNodeNextLevel(ArrayList<TreeLinkNode> list){
        TreeLinkNode root=list.get(0);
        if(root==null){
            return null;
        }
        if(root.left!=null){
            return root.left;
        }
        return findNextNodeNextLevel(list,root.left);
    }
}