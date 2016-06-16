public class Solution {
    public int maxProduct(String[] words) {
        if(words == null || words.length == 0)
            return 0;
            
        int[] flags = new int[words.length];
        for(int i = 0; i < words.length; i++) {
            flags[i] = convert(words[i]);
        }
        
        int ans = 0;
        for(int i = 0; i < words.length; i++) {
            for(int j = i + 1; j < words.length; j++) {
                if((flags[i] & flags[j]) == 0) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        
        return ans;
    }
    private int convert(String s) {
        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            ans = setBit(ans, s.charAt(i) - 'a' + 1);
        }
        return ans;
    }
    
    private int setBit(int n, int i) {
        return n | (1 << i);
    }
}