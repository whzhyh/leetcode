public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> l = new ArrayList<String>();
        backtracking(s, 0, ans, l);
        return ans;
    }
    public void backtracking(String s, int start, List<List<String>> ans, List<String> list) {
        if(start >= s.length() && list.size() > 0)
            ans.add(new ArrayList(list));
        
        for(int i = start; i < s.length(); i++) {
            if(isPalindrome(s, start, i)) {
                list.add(s.substring(start, i+1));
                backtracking(s, i+1, ans, list);
                list.remove(list.size() - 1);
            }
        }
    }
    public boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}