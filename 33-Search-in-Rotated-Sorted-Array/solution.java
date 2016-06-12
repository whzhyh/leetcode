public class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return -1;
            
        int left = 0, right = nums.length - 1;
        int guard = nums[0];
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
                return mid;
            
            if (nums[mid] < guard) {
                if(nums[mid] < target && target < guard) {
                    left = mid;
                } else {
                    right = mid;
                }
                
            } else {
                if(nums[mid] > target && target >= guard) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
        } 
        
        if(nums[left] == target)
            return left;
        else if(nums[right] == target)
            return right;
        
        return -1;
    }
}