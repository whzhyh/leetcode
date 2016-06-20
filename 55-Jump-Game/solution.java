public class Solution {
    // DP
    public boolean canJump(int[] nums) {
        boolean[] can = new boolean[nums.length];
        can[0] = true;
        
        for(int i = 1; i < nums.length; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(can[j] && j + nums[j] >= i) {
                    can[i] = true;
                    break;
                }
            }
        }
        
        return can[nums.length - 1];
    }
    // Greedy
    public boolean canJump2(int[] nums) {
        if(nums == null || nums.length == 0)
            return false;
            
        int farthest = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(i <= farthest && nums[i] + i >= farthest) {
                farthest = nums[i] + i;
            }
        }
        
        return farthest >= nums.length - 1;
    }
}