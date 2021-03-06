//O(n) time
//O(n)+O(log(n)) space, O(log(n)) extra space
//ascending order array

public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        if(num==null||num.length==0) return null;
        int len=num.length;
        return helper(num,0,len-1);
    }
    private TreeNode helper(int[] num, int left, int right){
        if(left>right)
            return null;
        int mid=(left+right)/2;
        TreeNode root=new TreeNode(num[mid]);
        root.left=helper(num,left,mid-1);
        root.right=helper(num,mid+1,right);
        return root;
    }
}