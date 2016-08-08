public class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] palindrome = new boolean[n][n];
        prepare(palindrome, s);
        int[] f = new int[s.length() + 1];
        Arrays.fill(f, Integer.MAX_VALUE);
        f[0] = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                if(palindrome[j][i - 1]) {
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }
        return f[s.length()] - 1;
    }
    public void prepare(boolean[][] palindrome, String s) {
        int n = palindrome.length;
        for(int i = 0; i < n; i++) {
            palindrome[i][i] = true;
        }
        for(int i = 0; i < n - 1; i++) {
            palindrome[i][i + 1] = (s.charAt(i) == s.charAt(i+1));
        }
        
        for(int i = n - 1; i >= 0; i--) {
            for(int j = i + 2; j < n; j++) {
                palindrome[i][j] = palindrome[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
            }
        }
    }
}