/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int closestValue(TreeNode root, double target) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        
        int start = 0, end = list.size() - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(list.get(mid) < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if(Math.abs(list.get(start) - target) < Math.abs(list.get(end) - target)) {
            return list.get(start);
        } else {
            return list.get(end);
        }
        
    }
    
    public void inorder(TreeNode root, List<Integer> list) {
        if(root == null)
            return;
        
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
        
    }
}