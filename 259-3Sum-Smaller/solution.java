public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length < 3)
            return 0;
        Arrays.sort(nums);
        int ans = 0;
        for(int i = 0; i < nums.length - 2; i++) {
            int start = i + 1, end = nums.length - 1;
            while(start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if(sum < target) {
                    ans += end - start;
                    start++;
                } else {
                    end--;
                }
                    
            }
        }
        return ans;
    }
}