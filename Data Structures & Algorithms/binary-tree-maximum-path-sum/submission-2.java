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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        dfs(root);
        return maxSum;
    }

    //postorder
    int dfs(TreeNode root) {

        if(root == null) {
            return 0;
        }

        int leftMaxPathSum = dfs(root.left);//-5
        int rightMaxPathSum = dfs(root.right);//0

        int temp = Math.max(root.val, root.val + leftMaxPathSum + rightMaxPathSum);
        int temp2 = Math.max(temp, root.val + leftMaxPathSum);
        int temp3 = Math.max(temp2, root.val + rightMaxPathSum);

        maxSum = Math.max(maxSum, temp3);

        return Math.max(root.val + Math.max(leftMaxPathSum, rightMaxPathSum), root.val);
    }
}
