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
        if(node == null)
            return null;
        // Step 1: Get all the nodes
        List<UndirectedGraphNode> nodes = getNodes(node);
        
        // Step 2: Copy all the nodes, and store the mapping to hashmap
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        for(UndirectedGraphNode n : nodes) {
            map.put(n, new UndirectedGraphNode(n.label));
        }
        
        // Step 3: Connect the neighbors
        for(UndirectedGraphNode n : nodes) {
            List<UndirectedGraphNode> neighbors = n.neighbors;
            UndirectedGraphNode copy = map.get(n);
            List<UndirectedGraphNode> copyNeighbors = new ArrayList<>();
            for(UndirectedGraphNode neighbor : neighbors) {
                copyNeighbors.add(map.get(neighbor));
            }
            copy.neighbors = copyNeighbors;
        }
        
        return map.get(node);
    }
    
    public ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        HashSet<UndirectedGraphNode> set = new HashSet<>();
        
        queue.offer(node);
        set.add(node);
        while(!queue.isEmpty()) {
            UndirectedGraphNode head = queue.poll();
            for(UndirectedGraphNode neighbor : head.neighbors) {
                if(!set.contains(neighbor)) {
                    queue.offer(neighbor);
                    set.add(neighbor);
                }
            }
        }
        return new ArrayList<UndirectedGraphNode>(set);
    }
}