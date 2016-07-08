public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3)
            return -1;
            
        Arrays.sort(nums);
        int min = nums[0] + nums[1] + nums[2];
        
        for(int i = 0; i < nums.length - 2; i++) {
            int start = i + 1, end = nums.length - 1;
            while(start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if(Math.abs(sum - target) < Math.abs(min - target)) {
                    min = sum;
                    System.out.println(sum);
                }
                if(sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        
        return min;
    }
}