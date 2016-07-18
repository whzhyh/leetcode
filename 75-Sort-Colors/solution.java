public class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0)
            return;
            
        int[] counter = new int[3];
        for(int n : nums) {
            counter[n]++;
        }
        
        int idx = 0;
        for(int i = 0; i < nums.length;) {
            while(counter[idx] != 0) {
                nums[i++] = idx;
                counter[idx]--;
            }
            idx++;
        }
    }
}