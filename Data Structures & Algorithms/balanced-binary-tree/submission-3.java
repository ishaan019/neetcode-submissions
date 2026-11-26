/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    boolean isBalanced;
    public boolean isBalanced(TreeNode root) {
        int ans = dfs(root);
        
        return ans != -1;
    }

    private int dfs(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int leftHeight = dfs(node.left);
        if(leftHeight == -1) {
            return -1;
        }
        int rightHeight = dfs(node.right);
        if(rightHeight == -1) {
            return -1;
        }

        if(Math.abs(leftHeight - rightHeight) > 1) {
           return -1;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
