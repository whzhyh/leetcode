public class Solution {
    public int numSquares(int n) {
        if(n == 1)
            return 1;
        
        List<Integer> list = new ArrayList<>();
        int[] dp = new int[n + 1];
        dp[1] = 1;
        
        for(int i = 2; i <= n; i++) {
            
            int root = (int)Math.sqrt(i);
            if(root * root == i) {
                dp[i] = 1;
                continue;
            }
            
            int min = Integer.MAX_VALUE;
            for(int j = 1; j < i / j; j++) {
                
                min = Math.min(dp[i - j * j] + 1, min);
            }
            dp[i] = min;
        }
        
        return dp[n];
    }
}