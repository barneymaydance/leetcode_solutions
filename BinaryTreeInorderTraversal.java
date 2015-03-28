//O(n) runtime
//O(log(n)) space, it can be O(1) Morris Traversal
//recursive method
// inorder, left, cur, right

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res= new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }
    private void inorder(TreeNode root,List<Integer> res){
        if(root==null)
            return;
        inorder(root.left,res);
        res.add(root.val);    
        inorder(root.right,res);
    }
}

//O(n) runtime
//O(log(n)) space
//iterative and stack
// keep track the node of we are visiting , not the  inorder print node
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root!=null||!stack.empty()){
            if(root!=null){
                stack.push(root);
                root=root.left;
            }
            else{
                root=stack.pop();
                res.add(root.val);
                root=root.right;
            }
        }
        return res;
    }
}

// stack, store the inorder
//
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultInorder = new ArrayList<Integer>();
        Stack<TreeNode> NodeStack = new Stack<TreeNode>();
        if (root != null){
            NodeStack.push(root);
        }
        while(!NodeStack.empty()){
            TreeNode current = NodeStack.pop();
            if (current.left == null && current.right == null){
                resultInorder.add(current.val);
            }
            else{
                if (current.right != null){
                    NodeStack.push(current.right);
                    current.right = null;
                }
                NodeStack.push(current);
                if (current.left != null){
                    NodeStack.push(current.left);
                    current.left = null;
                }
            }
        }
        return resultInorder;
    }
}







