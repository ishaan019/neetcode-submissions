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
    int preIdx = 0;
    Map<Integer, Integer> inorderMap = new HashMap<>(); // inorder(val,idx)
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return dfs(preorder, 0, inorder.length - 1);
    }

    TreeNode dfs(int[] preorder, int l, int r) {
        if (l > r) {
            return null;
        }

        int val = preorder[preIdx];
        preIdx++;
        TreeNode root = new TreeNode(val);
        int mid = inorderMap.get(val);
        root.left = dfs(preorder, l, mid - 1);
        root.right = dfs(preorder, mid + 1, r);
        return root;
    }
}
