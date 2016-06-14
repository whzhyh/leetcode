public class Solution {
    // 剥皮法？
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<Integer>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> leaves = new LinkedList<>();
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < n; i++) {
            if(graph.get(i).size() <= 1) {
                leaves.add(i);
                set.add(i);
            }
        }
        
        while(n > 2) {
            int size = leaves.size();
            n -= size;
            for(int i = 0; i < size; i++) {
                int leaf = leaves.poll();
                Set<Integer> neighbors = graph.get(leaf);
                for(int neighbor : neighbors) {
                    graph.get(neighbor).remove(leaf);
                    if(graph.get(neighbor).size() == 1 && !set.contains(neighbor)) {
                        leaves.add(neighbor);
                        set.add(neighbor);
                    }
                }
            }
        }
        return new ArrayList<Integer>(leaves);
        
    }


}