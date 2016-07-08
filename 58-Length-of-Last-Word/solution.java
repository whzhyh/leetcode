public class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if(s.length() == 0)
            return 0;
        int i = s.length() - 1;
        for(; i >= 0; i--) {
            if(s.charAt(i) == ' ')
                break;
        }
        return s.length() - 1 - i;
    }
}