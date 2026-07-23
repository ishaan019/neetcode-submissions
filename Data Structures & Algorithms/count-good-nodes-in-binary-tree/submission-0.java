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

/*
arrive at node
check if it’s good
update max
pass updated max to children

Final rule of thumb
Preorder: use when the current node depends on ancestor/path state
Postorder: use when the current node depends on results from children

Simple rule of thumb
If the recursive call’s job is “compute and return something” → use a return type like int
If the recursive call’s job is “walk the tree and update something” → use void
*/


class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int maxVal) {
        if(node == null) {
            return 0;
        }

        int res = node.val >= maxVal ? 1 : 0;
        maxVal = Math.max(maxVal, node.val);
        res += dfs(node.left, maxVal);
        res += dfs(node.right, maxVal);

        return res;
    }
}
