//O(n)
//O(log(n))

//binary search tree inorder travseral is sorted increasingly
public class Solution {
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> pre=new ArrayList<Integer>();
        pre.add(null);
        return inorder(root,pre);
    }
    private boolean inorder(TreeNode root, ArrayList<Integer> pre){
        if(root ==null)
            return true;
        boolean left=inorder(root.left,pre);
        if(pre.get(0)!=null&&root.val<=pre.get(0)){
            return false;
        }
        pre.set(0,root.val);
        return left&&inorder(root.right,pre);
    }
}


//all nodes in left-subtree always less than root node, all nodes in right subtree always bigger than root node
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,null,null);
    }
    private boolean isValidBST(TreeNode root, Integer min, Integer max){
        if(root ==null)
            return true;
        if((max!=null&&root.val>=max)||(min!=null&&root.val<=min)){
            return false;
        }
        return isValidBST(root.left,min,root.val)&&isValidBST(root.right,root.val,max);
    }
}