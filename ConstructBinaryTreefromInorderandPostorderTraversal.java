//O(n) time
//O(n) space
//similar to Construct Binary Tree from Preorder and Inorder Traversal

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder==null||inorder==null||postorder.length==0||inorder.length==0){
            return null;
        }
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0; i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(postorder,0,postorder.length-1,inorder,0,inorder.length-1,map);
    }
    private TreeNode helper(int[] postorder, int postL,int postR,int[] inorder,int inL,int inR, HashMap<Integer,Integer> map){
        if(postL>postR||inL>inR)
            return null;
        TreeNode root = new TreeNode(postorder[postR]);
        int index=map.get(postorder[postR]);
        root.left = helper(postorder, postL, index-1-inR+postR, inorder, inL, index-1,	map);
		root.right = helper(postorder, index-inR+postR, postR-1, inorder, index+1, inR, map);
        return root;
    } 
}