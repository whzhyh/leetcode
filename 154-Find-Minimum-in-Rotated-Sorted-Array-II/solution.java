public class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        if(nums == null || nums.length == 0)
            return min;
        for(int i : nums) {
            min = Math.min(min, i);
        }
        return min;
    }
}