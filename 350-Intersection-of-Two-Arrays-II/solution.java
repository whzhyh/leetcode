public class Solution {
    // Two Pointers
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null)
            return null;
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]) {
                ans.add(nums1[i]);
                i++;
                j++;
            } else if(nums1[i] < nums2[j])
                i++;
            else 
                j++;
        }
        
        int[] rest = new int[ans.size()];
        for(int m = 0; m < rest.length; m++) {
            rest[m] = ans.get(m);
        }
        return rest;
    }
    
    // HashMap
    public int[] intersect1(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i : nums1) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        
        for(int i : nums2) {
            if(map.containsKey(i) && map.get(i) > 0) {
                ans.add(i);
                map.put(i, map.get(i) - 1);
            }
        }
        int[] result = new int[ans.size()];
        for(int i = 0; i < result.length; i++) {
            result[i] = ans.get(i);
        }
        
        return result;
    }
}