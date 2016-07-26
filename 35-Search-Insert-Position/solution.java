public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int start = 0, end = nums.length - 1;
        if(nums[end] < target)
            return nums.length;
            
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if(nums[start] >= target)
            return start;
        
        return end;
    }
}