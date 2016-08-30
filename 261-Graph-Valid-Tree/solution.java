public class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        
        if(edges.length != n - 1)
            return false;
        
        for(int i = 0; i < n; i++) {
            graph.add(i, new ArrayList<Integer>());
        }
        for(int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        if(hasCycle(graph, 0, visited, -1))
            return false;
        
        for(int i = 0; i < n; i++) {
            if(!visited[i])
                return false;
        }
        return true;
    }
    
    boolean hasCycle(List<List<Integer>> graph, int u, boolean[] visited, int parent) {
        visited[u] = true;
        
        for(int i = 0; i < graph.get(u).size(); i++) {
            int v = graph.get(u).get(i);
            if(visited[v] && parent != v || (!visited[v] && hasCycle(graph, v, visited, u)))
                return true;
        }
        return false;
    }
}