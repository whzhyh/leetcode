public class Solution {
    
    public void sortColors(int[] nums) { 
        if(nums == null || nums.length == 0)
            return;
        int left = 0, right = nums.length - 1;
        for(int i = 0; i < nums.length; i++) {
            while(nums[i] == 2 && i < right) {
                swap(nums, i, right--);
            }
            while(nums[i] == 0 && i > left) {
                swap(nums, i, left++);
            }
        }
        
    }
    
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    // Counting Sort
    public void sortColors2(int[] nums) {
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