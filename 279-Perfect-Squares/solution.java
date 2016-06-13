public class Solution {
    private boolean isPerfectSquare(int n) {
        int root = (int)Math.sqrt(n);
        if(root * root == n) 
            return true;
        return false;
    }
    public int numSquares(int n) {
        if(isPerfectSquare(n))
            return 1;
        
        List<Integer> list = new ArrayList<>();
        int[] dp = new int[n + 1];
        dp[1] = 1;
        
        for(int i = 2; i <= n; i++) {
            if(isPerfectSquare(i)) {
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