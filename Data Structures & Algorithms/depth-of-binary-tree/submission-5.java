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
    public int maxDepth(TreeNode root) {

        return dfs(root);
        
    }

    private int dfs(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int leftHeight = dfs(node.left);//1
        int rightHeight = dfs(node.right);//2

        int totalHeight = 1 + Math.max(leftHeight, rightHeight);//

        return totalHeight;//1
    }
}
