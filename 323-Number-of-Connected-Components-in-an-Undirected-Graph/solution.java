public class Solution {
    class UnionFind {
        int[] fathers;
        public UnionFind(int n) {
            fathers = new int[n];
            for(int i = 0; i < n; i++) {
                fathers[i] = i;
            }
        }
        public void union(int x, int y) {
            int faX = find(x);
            int faY = find(y);
            if(faX != faY) {
                fathers[faX] = faY;    
            }
            
        }
        public int find(int x) {
            int father = fathers[x];
            while(father != fathers[father]) {
                father = fathers[father];
            }
            int tmp = -1;
            while(fathers[x] != father) {
                tmp = fathers[x];
                fathers[x] = father;
                x = tmp;
            }
            // System.out.println(x + " : " + father);
            return father;
        }
        public int countComponents() {
            Set<Integer> fas = new HashSet<Integer>();
            for(int i = 0; i < fathers.length; i++) {
                fas.add(find(i));
            }
            return fas.size();
        }
    }
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for(int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        return uf.countComponents();
    }
}