public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        dfs(ans, tmp, candidates, target, 0);
        return ans;
    }
    public void dfs(List<List<Integer>> ans, List<Integer> tmp, int[] candidates, int target, int idx) {
        if(target == 0) {
            ans.add(new ArrayList<Integer>(tmp));
            return;
        }
        
        for(int i = idx; i < candidates.length; i++) {
            if(target >= candidates[i]) {
                tmp.add(candidates[i]);
                dfs(ans, tmp, candidates, target - candidates[i], i);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}