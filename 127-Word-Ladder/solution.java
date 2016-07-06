public class Solution {
    
    // BFS
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        
        wordList.add(beginWord);
        wordList.add(endWord);
        
        Queue<String> q = new LinkedList<String>();
        HashSet<String> used = new HashSet<>();
        
        q.add(beginWord);
        used.add(beginWord);
        int len = 0;
        
        while(!q.isEmpty()) {
            len++;
            
            int size = q.size();
            for(int i = 0; i < size; i++) {
                String str = q.poll();
                if(str.equals(endWord))
                    return len;
                Set<String> possibles = getPossibles(str, wordList);
                for(String word : possibles) {
                    if(!used.contains(word)) {
                        q.add(word);
                        used.add(word);
                    }
                }
            }
        }
        return 0;
    }
    
    public Set<String> getPossibles(String str, Set<String> dic) {
        Set<String> ans = new HashSet<>();
        int len = str.length();
        if(len == 0)
            return ans;
        for(int i = 0; i < len; i++) {
            for(char j = 'a'; j <= 'z'; j++) {
                if(j != str.charAt(i)) {
                    String s = replace(str, i, j);
                    if(dic.contains(s)) {
                        ans.add(s);
                    }
                }
            }
        }
        return ans;
    }
    
    private String replace(String str, int i, char c) {
        char[] chars = str.toCharArray();
        chars[i] = c;
        return new String(chars);
    } 
}