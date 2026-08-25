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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot != null) {
            return false;
        }

        if(subRoot == null) {
            return true;
        }

        if(isSameTree(root, subRoot)) {
            return true;
        }

        boolean ansFromLeft = isSubtree(root.left, subRoot);
        boolean ansFromRight = isSubtree(root.right, subRoot);

        return ansFromLeft || ansFromRight;
    }

    boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) {
            return true;
        }
        if(root == null || subRoot == null) {
            return false;
        }

        if(root.val != subRoot.val) {
            return false;
        }

        boolean isLeftsubtreeSame = isSameTree(root.left, subRoot.left);
        boolean isRightsubtreeSame = isSameTree(root.right, subRoot.right);

        return (root.val == subRoot.val) && isLeftsubtreeSame && isRightsubtreeSame;
    }
}
