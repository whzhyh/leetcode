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
        int i = 0, m = s.length() - 1, n = t.length() - 1;
        while(i < t.length() && s.charAt(i) == t.charAt(i)) {
            i++;
        }
        while(n >= 0 && s.charAt(m) == t.charAt(n)) {
            m--;
            n--;
        }
        return i == m;
    }
}