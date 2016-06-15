public class Solution {
    // Method 2: Math
    public String getPermutation(int n, int k) { 
        StringBuilder sb = new StringBuilder();
        List<Integer> nums = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) {
            nums.add(i + 1);
        }
        int count = getTotalCount(n - 1);
        while(nums.size() > 0) {
            int idx = (int)Math.ceil(k * 1.0 / count) - 1;
            sb.append(nums.get(idx));
            nums.remove(nums.get(idx));
            k -= idx * count;
            count = n == 1 ? 1 : count/--n;
            // count /= --n;
        }
        return sb.toString();
    }
    
    public int getTotalCount(int n) {
        int ans = 1;
        for(int i = 1; i <= n; i++) {
            ans *= i;
        }
        return ans;
    }
    
    // Method 1: Backtracking, TLE error
    public String getPermutation2(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        List<Integer> tmp = new ArrayList<>();
        dfs(list, tmp, visited, n);
        List<Integer> ans = list.get(k - 1);
        StringBuilder sb = new StringBuilder();
        for(int i : ans) {
            sb.append(i);
        }
        return sb.toString();
    }
    public void dfs(List<List<Integer>> list, List<Integer> tmp, boolean[] visited, int n) {
        if(tmp.size() == n) {
            list.add(new ArrayList<Integer>(tmp));
            return;
        }
        for(int i = 1; i <= n; i++) {
            if(visited[i] == true)
                continue;
            tmp.add(i);
            visited[i] = true;
            dfs(list, tmp, visited, n);
            tmp.remove(tmp.size() - 1);
            visited[i] = false;
        }
    }
}