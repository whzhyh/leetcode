public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(i != 0 && nums[i] == nums[i - 1])
                continue;
            for(int j = i + 1; j < nums.length; j++) {
                if(j != i + 1 && nums[j] == nums[j - 1])
                    continue;
                    
                int start = j + 1, end = nums.length - 1;
                while(start < end) {
                    int sum = nums[i] + nums[j] + nums[start] + nums[end];
                    if(start != j + 1 && nums[start] == nums[start - 1]) {
                        start++;
                        continue;
                    }
                    if(end != nums.length - 1 && nums[end] == nums[end + 1]) {
                        end--;
                        continue;
                    }
                        
                    if(sum == target) {
                        int[] a = new int[] {nums[i], nums[j], nums[start], nums[end]};
                        for(int n : a) {
                            tmp.add(n);
                        }
                        ans.add(new ArrayList<Integer>(tmp));
                        tmp.clear();
                        start++;
                        end--;
                    } else if(sum > target) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }
        return ans;
    }
}