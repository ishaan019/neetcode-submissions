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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>(); 
        }

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);//4 5 6 7

        while(!queue.isEmpty()) {
            int length = queue.size();//2

            List<Integer> localList = new ArrayList<>();

            for(int i = 0; i < length; i++) {//0,1
                TreeNode top = queue.poll();//1

                localList.add(top.val);//[2, 3]

                if(top.left != null) {
                    queue.offer(top.left);
                }
                
                if(top.right != null) {
                    queue.offer(top.right);
                }
            }

            result.add(localList);//[[1], ]
        }

        return result;
    }
}
