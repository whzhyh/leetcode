public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        HashMap<String, Integer> toFind = new HashMap<>();
        HashMap<String, Integer> found = new HashMap<>();
        
        int m = words.length, n = words[0].length();
        for(int i = 0; i < m; i++) {
            toFind.put(words[i], toFind.containsKey(words[i]) ? toFind.get(words[i]) + 1 : 1);
        }
        
        for(int i = 0; i <= s.length() - m * n; i++) {
            found.clear();
            int j;
            for(j = 0; j < m; j++) {
                int k = i + j * n;
                String stub = s.substring(k, k + n);
                if(!toFind.containsKey(stub))
                    break;
                if(found.containsKey(stub)) {
                    found.put(stub, found.get(stub) + 1);
                } else {
                    found.put(stub, 1);
                }
                
                if(found.get(stub) > toFind.get(stub))
                    break;
            }
            if(j == m)
                ans.add(i);
        }
        return ans;
        
    }
}