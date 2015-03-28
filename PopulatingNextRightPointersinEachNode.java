//O(n) time
//O(1) space
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null){
            return;
        }
        while(root!=null){
            TreeLinkNode curLevel=root;
            while(curLevel.left!=null){
                curLevel.left.next=curLevel.right;
                if(curLevel.next!=null){
                    curLevel.right.next=curLevel.next.left;
                    curLevel=curLevel.next;
                }
                else{
                    break;
                }
            }
            root=root.left;
        }
        
    }
}

//O(n) time
//O(log(n) space
//use a queue

public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null){
            return;
        }
        LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(root);
        int levelNum=1;
        while(!queue.isEmpty()){
            TreeLinkNode temp=null;
            for(int i=0;i<levelNum;i++){
                TreeLinkNode node = queue.poll();
                node.next=temp;
                temp=node;
                if(node.right!=null){
                    queue.add(node.right);
                }
                if(node.left!=null){
                    queue.add(node.left);
                }
            }
            levelNum*=2;
        }
        
    }
}