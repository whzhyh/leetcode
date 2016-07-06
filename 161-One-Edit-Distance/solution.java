public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(Math.abs(m - n) > 1)
            return false;
        if(m == n) {
            int count = 0;
            for(int i = 0; i < m; i++) {
                if(s.charAt(i) != t.charAt(i)) {
                    count++;
                }
            }
            return count == 1;
        }
        if(m > n) {
            return isDel(s, t);
        } else {
            return isDel(t ,s);
        }
            
    }
    // length of s > t
    private boolean isDel(String s, String t) {
        for(int i = 0; i < s.length(); i++) {
            if((s.substring(0, i) + s.substring(i + 1, s.length())).equals(t))
                return true;
        }
        return false;
    }
}