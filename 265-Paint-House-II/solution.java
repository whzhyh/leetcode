public class Solution {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0] == null || costs[0].length == 0)
            return 0;
        int n = costs.length;
        int k = costs[0].length;
        int[][] dp = new int[n][k];
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(int i = 0; i < k; i++) {
            dp[0][i] = costs[0][i];
            if(dp[0][i] < min2) {
                if(dp[0][i] < min1) {
                    min2 = min1;
                    min1 = dp[0][i];
                } else {
                    min2 = dp[0][i];
                }
            }
        }
        for(int i = 1; i < n; i++) {
            int last1 = min1, last2 = min2;
            min1 = Integer.MAX_VALUE;
            min2 = Integer.MAX_VALUE;
            
            for(int j = 0; j < k; j++) {
                if(last1 != dp[i-1][j])
                    dp[i][j] = last1 + costs[i][j];
                else {
                    dp[i][j] = last2 + costs[i][j];
                }
                if(dp[i][j] < min2) {
                    if(dp[i][j] < min1) {
                        min2 = min1;
                        min1 = dp[i][j];
                    } else {
                        min2 = dp[i][j];
                    }
                }
            }
        }
        
        return min1;
    }
}