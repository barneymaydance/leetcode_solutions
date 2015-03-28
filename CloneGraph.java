//O(n) time
//O(n) space
//use a hashmap to map  real node and copy node,
//use a queue or stack to visit, dfs or bfs

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null){
            return null;
        }
        LinkedList<UndirectedGraphNode> visiting = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label) ;
        visiting.add(node);
        map.put(node,copy);

        while(!visiting.isEmpty()){
            UndirectedGraphNode curNode=visiting.poll();
            for(UndirectedGraphNode neighbor:curNode.neighbors){
                if(!map.containsKey(neighbor)){
                    copy=new UndirectedGraphNode(neighbor.label);
                    visiting.add(neighbor);
                    map.put(neighbor,copy);
                }
                map.get(curNode).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node) ;
    }
}
 
