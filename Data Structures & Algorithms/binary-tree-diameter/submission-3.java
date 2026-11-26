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
    int maxDiamter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxDiamter;
    }

    private int dfs(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int leftHeight = dfs(node.left);//1
        int rightHeight = dfs(node.right);

        maxDiamter = Math.max(maxDiamter, (leftHeight + rightHeight));

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
