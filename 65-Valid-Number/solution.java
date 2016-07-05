public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        int len = s.length();
        if(len == 0)
            return false;
            
        boolean num = false;
        boolean dot = false;
        boolean exp = false;
        int i = 0;
        
        if(s.charAt(i) == '+' || s.charAt(i) == '-')
            i++;
    
        for(; i < len; i++) {
            char c = s.charAt(i);
            if(c >= '0' && c <= '9') {
                num = true;
            } else if(c == '.') {
                if(dot || exp)
                    return false;
                else 
                    dot = true;
            } else if(c == 'e') {
                if(exp || (num == false))
                    return false;
                exp = true;
                num = false;    
            } else if(c == '+' || c == '-') {
                if(s.charAt(i - 1) != 'e')
                    return false;
            } else {
                return false;
            }
            
        }
        return num;
    }
}