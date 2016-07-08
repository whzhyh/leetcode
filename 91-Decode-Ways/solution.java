public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0)
            return 0;
        if(s.charAt(0) == '0')
            return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1; 
        dp[1] = 1;
        
        for(int i = 2; i <= s.length(); i++) {
            int one = Integer.parseInt(s.substring(i - 1, i));
            int two = Integer.parseInt(s.substring(i - 2, i));
            if(one == 0 && (two > 26 || two < 10)) {
                dp[i] = 0;
                break;
            } else if(one == 0) {
                dp[i] = dp[i - 2];
            } else if(two > 26 || two < 10) {
                dp[i] = dp[i - 1];  
            } else{
                dp[i] = dp[i - 2] + dp[i - 1];
            }
        }
        return dp[s.length()];
    }
}