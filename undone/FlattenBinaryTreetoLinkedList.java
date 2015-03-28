//O(n) time
//O(log(n)) space

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void flatten(TreeNode root) {
        helper(root, null);
    }
    private TreeNode helper(TreeNode root, TreeNode pre){
        if(root == null)
            return pre;
        TreeNode right = root.right;
        if(pre!=null)
        {
            pre.left = null;
            pre.right = root;
        }
        return helper(right, helper(root.left, root));

    }
}