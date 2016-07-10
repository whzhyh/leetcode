public class Solution {
    // O(n)
    public int longestConsecutive(int[] nums) { 
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums) {
            set.add(n);
        }
        
        int longest = 0;
        for(int i = 0; i < nums.length; i++) {
            int down = nums[i] - 1;
            while(set.contains(down)) {
                set.remove(down);
                down--;
            }
            int up = nums[i] + 1;
            while(set.contains(up)) {
                set.remove(up);
                up++;
            }
            longest = Math.max(longest, up - down - 1);
        }
        return longest;
    }
    
    class UnionFind {
        HashMap<Integer, Integer> fathers = new HashMap<>();
        
        public UnionFind(int[] nums) {
            for(int n : nums) {
                fathers.put(n, n);
            }
        }
        
        public int find(int x) {
            int father = fathers.get(x);
            while(father != fathers.get(father)) {
                father = fathers.get(father);
            }
            
            int tmp = x;
            while(fathers.get(tmp) != father) {
                int newtmp = fathers.get(tmp);
                fathers.put(tmp, father);
                tmp = newtmp;
            }
        
            return father;
        }
        
        public void union(int x, int y) {
            int fatherX = find(x);
            int fatherY = find(y);
            if(fatherX != fatherY) {
                fathers.put(fatherX, fatherY);
            }
        }
        
        public boolean contains(int key) {
            return fathers.containsKey(key);
        }
        
        public int longest() {
            HashMap<Integer, Integer> lens = new HashMap<>();
                
            for(Integer key : fathers.keySet()) {
                int father = find(key);
                if(lens.containsKey(father)) {
                    lens.put(father, lens.get(father) + 1);
                } else {
                    lens.put(father, 1);
                }
            }
            int ans = 0;
            for(int len : lens.keySet()) {
                ans = Math.max(ans, lens.get(len));
            }
            return ans;
        }
    }
    // Union Find
    public int longestConsecutive2(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        UnionFind uf = new UnionFind(nums);
        
        for(int n : nums) {
            if(uf.contains(n - 1)) {
                uf.union(n, n - 1);
            } else if(uf.contains(n + 1)) {
                uf.union(n, n + 1);
            }
        }
          
        return uf.longest();
    }
}