//O(n^2) runtime, is not good
//O(H) space
// use the method Maximum depth of Binary Tree

public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        int diff=maxDepth(root.left)-maxDepth(root.right);
        if(Math.abs(diff)>1)
            return false;
        return isBalanced(root.left)&&isBalanced(root.right);    
    }
    private int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
