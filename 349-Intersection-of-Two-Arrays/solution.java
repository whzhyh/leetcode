public class Solution {
    // Two Pointers
    public int[] intersection2(int[] nums1, int[] nums2) { 
        if(nums1 == null || nums2 == null)
            return null;
        HashSet<Integer> ans = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i = 0, j = 0;
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]) {
                ans.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i] < nums2[j]) 
                i++;
            else
                j++;
        }
        
        int[] res = new int[ans.size()];
        int index = 0;
        for(int num : ans) {
            res[index++] = num;
        }
        return res;
    }
    
    // Binary Search
    public int[] intersection1(int[] nums1, int[] nums2) { 
        if(nums1 == null || nums2 == null)
            return null;
        
        HashSet<Integer> ans = new HashSet<>();
        Arrays.sort(nums1);
        for(int i : nums2) {
            int index = Arrays.binarySearch(nums1, i);
            if(index >= 0)
                ans.add(i);
        }
        int[] res = new int[ans.size()];
        int i = 0;
        for(int num : ans) {
            res[i++] = num;
        }
        return res;
    } 
    
    // HashSet
    public int[] intersection3(int[] nums1, int[] nums2) {
        // Write your code here
        if(nums1 == null || nums2 == null)
            return new int[0];
        
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> ans = new HashSet<>();
        for(int i : nums1) {
            set.add(i);
        }
        for(int i : nums2) {
            if(set.contains(i)) {
                ans.add(i);
            }
        }
        int[] res = new int[ans.size()];
        
        int i = 0;
        for(int num : ans) {
            res[i++] = num;
        }
        
        return res;
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        // Write your code here
        List<Integer> list = new ArrayList<>();
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[]{ };
        }
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums1) {
            if(!set.contains(n))
                set.add(n);
        }
        for(int n : nums2) {
            if(set.contains(n)) {
                list.add(n);
                set.remove(n);
            }
        }
        int[] ans = new int[list.size()];
        int i = 0;
        for(int n : list) {
            ans[i] = n;
            i++;
        }
        
        return ans;
    }
}