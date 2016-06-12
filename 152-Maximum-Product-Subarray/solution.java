public class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int[] maxdp = new int[nums.length];
        int[] mindp = new int[nums.length];
        maxdp[0] = nums[0];
        mindp[0] = nums[0];
        int ans = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int max = Math.max(Math.max(nums[i] * maxdp[i - 1], nums[i] * mindp[i - 1]), nums[i]);
            int min = Math.min(Math.min(nums[i] * maxdp[i - 1], nums[i] * mindp[i - 1]), nums[i]);
            maxdp[i] = max;
            mindp[i] = min;
            ans = Math.max(max, ans);
        }
        return ans;
    }
}