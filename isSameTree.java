/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 //O(n) runtime
 //O(log(n)) space
 // pre-order traversal depth first
 
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if((p==null&&q!=null)||(p!=null&&q==null)){
            return false;
        }
        if(p==null&&q==null){
            return true;
        }
        if(p.val!=q.val){
            return false;
        }
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        
    }
}