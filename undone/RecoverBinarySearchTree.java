//O(n) time
//O(log(n)) space
//use a list to record, need to record the pre node information

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
    public void recoverTree(TreeNode root) {
        if(root==null){
            return;
        }
        ArrayList<TreeNode> pre = new ArrayList<TreeNode>();
        pre.add(null);
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        inorder(root,pre,res);
        if(res.size()!=0){
            int temp= res.get(0).val;
            res.get(0).val=res.get(1).val;
            res.get(1).val=temp;
        }
    }
    private void inorder(TreeNode root,ArrayList<TreeNode> pre,ArrayList<TreeNode> res){
        if(root!=null){
            inorder(root.left,pre,res);
            if(pre.get(0)!=null && pre.get(0).val>root.val){
                if(res.size()==0){
                    res.add(pre.get(0));
                    res.add(root);
                    
                }   
                else{
                    res.set(1,root);
                }
                
            }
            pre.set(0,root);
            inorder(root.right,pre,res);
        }
    }
}