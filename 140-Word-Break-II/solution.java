public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        Map<String, List<String>> map = new HashMap<>();
        return helper2(s, dict, map);
    }
    
    
    public List<String> helper2(String s, Set<String> dict, Map<String, List<String>> map) {
        if(map.containsKey(s))
            return map.get(s);
        List<String> ans = new ArrayList<String>();
        
        int n = s.length();
        if(n <= 0)
            return ans;
        for(int i = 1; i <= n; i++) {
            String prefix = s.substring(0, i);
            if(dict.contains(prefix)) {
                if(i == n)
                    ans.add(prefix);
                else {
                    String postfix = s.substring(i);
                    List<String> tmp = helper2(postfix, dict, map);
                    for(String str : tmp) {
                        ans.add(prefix + " " + str);
                    }
                }
            }
        }
        map.put(s, ans);
        return ans;
    }
    
    public List<String> helper(String s, Set<String> dict, Map<String, ArrayList<String>> map) {
        if(map.containsKey(s))
            return map.get(s);
        ArrayList<String> ans = new ArrayList<>();
        int n = s.length();
        if(n <= 0) 
            return ans;
        for(int len = 1; len <= n; len++) {
            String subfix = s.substring(0, len);
            if(dict.contains(subfix)) {
                if(len == n) {
                    ans.add(subfix);
                } else {
                    String prefix = s.substring(len);
                    List<String> tmp = helper(prefix, dict, map);
                    for(String str : tmp) {
                        str = subfix + " " + str;
                        ans.add(str);
                    }
                }
            }
        }
        map.put(s, ans);
        return ans;
    }
}