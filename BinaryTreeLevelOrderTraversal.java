//O(n) time
//O(n) space
//use two queue, one records the treenode order, one records level number.

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res= new ArrayList<List<Integer>>();
        if(root==null)
            return res;
        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
        LinkedList<Integer> levels=new LinkedList<Integer>();
        queue.add(root);
        levels.add(1);
        while(!queue.isEmpty()){
            TreeNode cur=queue.poll();
            int level=levels.poll();
            if(res.size()<level){
                List<Integer> temp=new ArrayList<Integer>();
                temp.add(cur.val);
                res.add(temp);
            }
            else{
                res.get(level-1).add(cur.val);
            }
            if(cur.left!=null){
                queue.add(cur.left);
                levels.add(level+1);   
            }
            if(cur.right!=null){
                queue.add(cur.right);
                levels.add(level+1);  
            }
        }
        return res;
    }
}

//one queue
//
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res= new ArrayList<List<Integer>>();
        if(root==null)
            return res;
        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> temp=new ArrayList<Integer>();
            for(int i=0;i<size;i++){
                TreeNode cur=queue.poll();
                temp.add(cur.val);
                if(cur.left!=null){
                    queue.add(cur.left);
                }
                if(cur.right!=null){
                    queue.add(cur.right);
                }
            }
            res.add(temp);
        }
        return res;
    }
}