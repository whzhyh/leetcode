public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int max = 1;
        for(int i = 0; i < s.length(); i++) {
            HashSet<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            int j = i - 1;
            for(; j >= 0; j--) {
                set.add(s.charAt(j));
                if(set.size() > 2)
                    break;
                
            }
            max = Math.max(i - j, max);
        }
        return max;
    }
}