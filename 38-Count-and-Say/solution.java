public class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for(int i = 1; i < n; i++) {
            s = countAndSay(s);
        }
        return s;
    }
    public String countAndSay(String s) {
        StringBuilder sb = new StringBuilder();
        
        List<Integer> counts = new ArrayList<>();
        
        for(int i = 0; i < s.length();) {
            int j = i + 1;
            while(j < s.length() && s.charAt(i) == s.charAt(j)) {
                j++;
            }
            
            counts.add(j - i);
            i = j;
        }
        
        int len = 0;
        for(int i : counts) {
            sb.append(i).append(s.charAt(len));
            len += i;
        }
        return sb.toString();
    }
}