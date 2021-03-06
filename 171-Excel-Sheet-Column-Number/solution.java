public class Solution {
    public int titleToNumber(String s) {
        if(s == null || s.length() == 0)
            return 0;
            
        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            ans = ans * 26 + (int)(s.charAt(i) - 'A' + 1);
        }
        
        return ans;
    }
}