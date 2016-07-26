public class Solution {
    // Use Array
    public String minWindow(String s, String t) { 
        int[] map = new int[128];
        for(int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
        }
        int counter = t.length();
        int i = 0, j = 0;
        int start = 0;
        int d = Integer.MAX_VALUE;
        
        while(j < s.length()) {
            if(map[s.charAt(j++)]-- > 0)
                counter--;
            while(counter == 0) {
                if(j - i < d) {
                    start = i;
                    d = j - i;
                }
                if(map[s.charAt(i++)]++ == 0)
                    counter++;
            }
        }
        return d == Integer.MAX_VALUE ? "" : s.substring(start, start + d);
    }
    
    // Use Hashtable
    public String minWindow2(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < t.length(); i ++) {
            char c = t.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(t.charAt(i), 1);    
            }
        }
        int counter = t.length();
        int i = 0, j = 0;
        int start = 0, end = 0;
        int d = Integer.MAX_VALUE;
        
        while(j < s.length()) {
            char b = s.charAt(j);
            if(map.containsKey(b)) {
                if(map.get(b) > 0) {
                    counter--;
                }
                map.put(b, map.get(b) - 1);
            }
            j++;
            
            while(counter == 0 && i < j) {
                if(j - i < d) {
                    start = i;
                    end = j;    
                    d = j - i;
                }
                
                char a = s.charAt(i);
                if(map.containsKey(a)) {
                    if(map.get(a) == 0)
                        counter++;
                    map.put(a, map.get(a) + 1);
                }
                i++;
            }
        }
        
        return start >= end ? "" : s.substring(start, end);
    }
}