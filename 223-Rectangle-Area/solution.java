public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int x = Math.min(G, C) < Math.max(E, A) ? 0 : Math.min(G, C) - Math.max(E, A);
        int y = Math.min(D, H) < Math.max(B, F) ? 0 : Math.min(D, H) - Math.max(B, F);
        
        return (D - B) * (C - A) + (H - F) * (G - E) - x * y;
    }
}