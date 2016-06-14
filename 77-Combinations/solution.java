public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if(n < 1 || k > n)
            return ans;
        List<Integer> tmp = new ArrayList<>();
        dfs(ans, tmp, n, 1, k);
        return ans;
    }
    
    public void dfs(List<List<Integer>> ans, List<Integer> tmp, int n, int pos, int k) {
        if(tmp.size() == k) {
            ans.add(new ArrayList<Integer>(tmp));
            return;
        }
        
        for(int i = pos; i <= n; i++) {
            tmp.add(i);
            dfs(ans, tmp, n, i + 1, k);
            tmp.remove(tmp.size() - 1);
        }
        
    }
}