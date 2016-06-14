public class Solution {
    public int titleToNumber(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int ans = 0;
        int n = s.length();
        char[] letters = s.toCharArray();
        for(int i = n - 1; i >= 0; i--) {
            ans += (int)(letters[i] - 'A' + 1) * Math.pow(26, n - i - 1);
        }
        
        return ans;
    }
}