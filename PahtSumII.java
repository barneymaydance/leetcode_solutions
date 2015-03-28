//O(n) time
//O(klog(n)) space, k is the maxium paths that can sum to the target

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null){
            return res;
        }
        helper(root,sum,res,new ArrayList<Integer>());
        return res;
    }
    private void helper(TreeNode root, int sum, List<List<Integer>> res,List<Integer> temp){
        if(root==null)
            return;
        if(root.left==null&&root.right==null&&sum==root.val){
            temp.add(root.val);
            res.add(new ArrayList<Integer>(temp));
            temp.remove(temp.size()-1);
            return;
        }
        temp.add(root.val);
        helper(root.left,sum-root.val,res,temp);
        helper(root.right,sum-root.val,res,temp);
        temp.remove(temp.size()-1);
    }
}