public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        return helper(s, dict, map);
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