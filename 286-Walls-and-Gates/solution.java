public class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0)
            return;
        int m = rooms.length;
        int n = rooms[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(rooms[i][j] == 0)
                    bfs(rooms, i, j);
            }
        }
    }
    public void bfs(int[][] rooms, int x, int y) {
        Queue<Node> q = new LinkedList<>();
        int distance = -1;
        q.add(new Node(x, y));
        
        while(!q.isEmpty()) {
            int size = q.size();
            distance++;
            for(int i = 0; i < size; i++) {
                Node head = q.poll();
                
                if(distance < rooms[head.x][head.y] || rooms[head.x][head.y] == 0) {
                    if(distance < rooms[head.x][head.y])
                        rooms[head.x][head.y] = distance;
                    
                    for(int j = 0; j < 4; j++) {
                        int x2 = head.x + dx[j];
                        int y2 = head.y + dy[j];
                        if(isValid(rooms, x2, y2)) {
                            if(rooms[x2][y2] == -1 || rooms[x2][y2] == 0)
                                continue;
                            q.add(new Node(x2, y2));
                        }
                            
                    }
                }
                
            }
        }
        
            
    }   
    private boolean isValid(int[][] rooms, int x, int y) {
        int m = rooms.length;
        int n = rooms[0].length;
        if(x < 0 || x >= m || y < 0 || y >= n)
            return false;
        return true;
        
    }
}