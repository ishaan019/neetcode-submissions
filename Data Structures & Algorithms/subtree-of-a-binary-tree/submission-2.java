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
        if(root == null && subRoot == null) {
            return true;
        } else if(root == null && subRoot != null) {
            return false;
        } else if (root != null && subRoot == null) {
            return false;
        }

        if (isSameTree(root, subRoot)) {
            return true;
        }


        boolean isSubtreeInLeft = isSubtree(root.left, subRoot);
        boolean isSubtreeInRight = isSubtree(root.right, subRoot);

        return isSubtreeInLeft || isSubtreeInRight;
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if ((p == null && q != null) || (q == null && p != null)) {
            return false;
        }

        boolean isLeftTreeSame = isSameTree(p.left, q.left);
        boolean isRightTreeSame = isSameTree(p.right, q.right);

        return (p.val == q.val) && isLeftTreeSame && isRightTreeSame;
    }
}
