public class Solution {
    public String reverseWords(String s) {
        String[] parts = s.trim().split("\\s+");
        String out = "";
        for (int i = parts.length - 1; i > 0; i--) {
            out += parts[i] + " ";
        }
        return out + parts[0];
    }
    
    public String reverseWords2(String s) {
        s = s.trim();
        int len = s.length();
        if(len == 0)
            return s;
        List<String> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            char start = s.charAt(i);
            if(start == ' ')
                continue;
            int j = i;
            for(; j < s.length(); j++) {
                char end = s.charAt(j);
                if(end == ' ')
                    break;
            }
            list.add(s.substring(i, j));
            i = j;
        }
        
        int start = 0, end = list.size() - 1;
        while(start < end) {
            String tmp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, tmp);
            start++;
            end--;
        }
        StringBuilder sb = new StringBuilder();
        for(String str : list) {
            
            sb.append(str);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}