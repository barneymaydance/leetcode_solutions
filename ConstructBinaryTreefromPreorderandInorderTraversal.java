//O(n) time
//O(n) space

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||inorder==null||preorder.length==0||inorder.length==0){
            return null;
        }
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0; i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
    }
    private TreeNode helper(int[] preorder, int preL,int preR,int[] inorder,int inL,int inR, HashMap<Integer,Integer> map){
        if(preL>preR||inL>inR)
            return null;
        TreeNode root = new TreeNode(preorder[preL]);
        int index=map.get(preorder[preL]);
        root.left = helper(preorder, preL + 1, preL-inL+index, inorder, inL, index - 1,	map);
		root.right = helper(preorder, preL-inL+index + 1, preR, inorder, index+1, inR, map);
        return root;
    } 
}