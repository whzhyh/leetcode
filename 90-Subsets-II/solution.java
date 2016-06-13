public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if(nums == null || nums.length == 0)
            return ans;
        
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(nums);
        
        dfs(nums, ans, tmp, 0);
        return ans;
    }
    
    public void dfs(int[] nums, List<List<Integer>> ans, List<Integer> tmp, int pos) {
        
        ans.add(new ArrayList<Integer>(tmp));
        
        for(int i = pos; i < nums.length; i++) {
            if(i != pos && nums[i] == nums[i - 1])
                continue;
            tmp.add(nums[i]);
            dfs(nums, ans, tmp, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}