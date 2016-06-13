public class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    // 1. BFS
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0)
            return;
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++) {
            bfs(board, i, 0);
            bfs(board, i, n - 1);
        }
        for(int j = 1; j < n - 1; j++) {
            bfs(board, 0, j);
            bfs(board, m - 1, j);
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == '#')
                    board[i][j] = 'O';
                else 
                    board[i][j] = 'X';
            }
        }
    }
    
    public void bfs(char[][] board, int x, int y) {
        int m = board.length;
        int n = board[0].length;
        
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        
        while(!q.isEmpty()) {
            Node node = q.poll();
            if(board[node.x][node.y] != 'O')
                continue;
            board[node.x][node.y] = '#';
            for(int i = 0; i < 4; i++) {
                int x2 = node.x + dx[i];
                int y2 = node.y + dy[i];
                if(x2 < 0 || x2 >= m || y2 < 0 || y2 >= n)
                    continue;
                q.add(new Node(x2, y2));
            }    
        }
    }
    class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    // 2. Union Find To Do
    // public void solve(char[][] board) { 
    //     if(board == null || board.length == 0 || board[0] == null || board[0].length == 0)
    //         return;
    //     int m = board.length;
    //     int n = board[0].length;
    //     UnionFind uf = new UnionFind();
    //     for(int i = 0; i < m; i++) {
    //         for(int j = 0; j < n; j++) {
    //             if(board[i][j] == 'O') {
    //                 uf.add(i * n + j);
    //             }
                    
    //         }
    //     }
    // }
    
    // class UnionFind {
    //     HashMap<Integer, Integer> father = new HashMap<>();
        
    //     public void add(int x) {
    //         father.put(x, x);
    //     }
        
    //     // can be optimized
    //     public int find(int x) {
    //         int parent = father.get(x);
    //         while(parent != father.get(parent)) {
    //             parent = father.get(parent);
    //         }
    //         return parent;
    //     }
        
    //     public void union(int x, int y) {
    //         int fa_x = find(x);
    //         int fa_y = find(y);
    //         if(fa_x != fa_y) {
    //             father.put(fa_x, fa_y);
    //         }
    //     }
        
    // }
}