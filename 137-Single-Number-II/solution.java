public class Solution {
    // Best
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for(int i = 0; i < nums.length; i++){
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }
        return ones;
    }
    // General Method
    public int singleNumber2(int[] nums) {
        if(nums == null || nums.length == 0)
            return - 1;
        int result = 0;
        int[] bits = new int[32];
        for(int i = 0; i < 32; i++) {
            for(int j = 0; j < nums.length; j++) {
                bits[i] += (nums[j] >> i) & 1;
                bits[i] %= 3;
            }
            result |= (bits[i] << i);
        }
        return result;
        
    }
}