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

        return dfs(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    TreeNode dfs(int[] preorder, int pl, int pr, int[] inorder, int il, int ir) {
        if (pl > pr || il > ir) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[pl]);
        int mid = inorderMap.get(root.val);
        int numsOnLeft = mid - il;

        root.left = dfs(preorder, pl + 1, pl + numsOnLeft, inorder, il, mid - 1);
        root.right = dfs(preorder, pl + numsOnLeft + 1, pr, inorder, mid + 1, ir);

        return root;


       
    }
}
