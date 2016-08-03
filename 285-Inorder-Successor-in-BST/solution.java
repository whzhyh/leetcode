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
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        if(root == null)
            return null;
            
        Stack<TreeNode> stack = new Stack<>();
        TreeNode left = root;
        while(left != null) {
            stack.push(left);
            left = left.left;
        }
        boolean isNext = false;
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(isNext)
                return node;
            if(node == p) {
                isNext = true;
            }
            
            TreeNode l = node.right;
            while(l != null) {
                stack.push(l);    
                l = l.left;
            }
        }
        return null;
            
    }
    
    TreeNode ans = null;
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        if(root == null)
            return root;
        List<TreeNode> list = new ArrayList<>();
        inorder(root, list, p);
        return ans;
    }
    public void inorder(TreeNode root, List<TreeNode> list, TreeNode p) {
        if(root == null || ans != null)
            return;
        inorder(root.left, list, p);
        
        if(list.size() > 0 && p == list.get(list.size() - 1)) {
            ans = root;
        }
    
        list.add(root);
        inorder(root.right, list, p);
    }
}