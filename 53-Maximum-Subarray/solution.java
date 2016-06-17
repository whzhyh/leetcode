public class Solution {
    // Prefix Sum
    public int maxSubArray(int[] nums) { 
        if(nums == null || nums.length == 0)
            return 0;
        int max = Integer.MIN_VALUE, sum = 0, minSum = 0;
        
        for(int num : nums) {
            sum += num;
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
        }
        return max;
    }
    
    // DP 
    public int maxSubArray1(int[] nums) {
        int n = nums.length;
        int[] local = new int[2];
        int[] global = new int[2];
        local[0] = nums[0];
        global[0] = nums[0];
        for(int i = 1; i < n; i++) {
            local[i%2] = Math.max(local[(i-1)%2] + nums[i], nums[i]);
            global[i%2] = Math.max(global[(i-1)%2], local[i%2]);
        }
        return global[(n-1)%2];
    }
}