//O(n) time
//O(n) space

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if(root==null)
            return res;
        LinkedList<TreeNode> queue= new LinkedList<TreeNode>();
        queue.add(root);
        boolean lefttoRight=true;
        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<Integer>();
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                if(lefttoRight){
                    temp.add(node.val);
                }
                else{
                    temp.add(0,node.val);
                }
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            lefttoRight=!lefttoRight;
            res.add(temp);
        }
        return res;
    }
}