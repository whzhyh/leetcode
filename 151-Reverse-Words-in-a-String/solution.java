public class Solution {
    public String reverseWords2(String s) {
        String[] parts = s.trim().split("\\s+");
        String out = "";
        for (int i = parts.length - 1; i > 0; i--) {
            out += parts[i] + " ";
        }
        return out + parts[0];
    }
    
    public String reverseWords(String s) {
        s = s.trim();
        int len = s.length();
        if(len == 0)
            return s;
        List<String> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ')
                continue;
            int j = i;
            for(; j < s.length(); j++) {
                if(s.charAt(j) == ' ')
                    break;
            }
            list.add(s.substring(i, j));
            i = j;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}