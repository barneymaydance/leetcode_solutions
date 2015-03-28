//
//

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return helper(1,n);
    }
    private List<TreeNode> helper(int left, int right){
        List<TreeNode> res = new ArrayList<TreeNode>();
        if(left>right){
            res.add(null);
            return res;
        }
        
        for(int i=left;i<=right;i++){
            List<TreeNode> leftList=helper(left,i-1);
            List<TreeNode> rightList=helper(i+1,right);
            for(TreeNode leftNode:leftList){
                for(TreeNode rightNode:rightList){
                    TreeNode root=new TreeNode(i);
                    root.left=leftNode;
                    root.right=rightNode;
                    res.add(root);
                }
            }
        }
        return res;
    }
}