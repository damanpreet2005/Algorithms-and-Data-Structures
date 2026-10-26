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
    private int max;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE; // Reset global state per test case
        pathSum(root);
        return max;
    }

    private int pathSum(TreeNode node) {
        if (node == null) return 0;

        // 1. Recurse down subtrees & clamp negative contributions to 0
        int left = Math.max(0, pathSum(node.left));
        int right = Math.max(0, pathSum(node.right));

        // 2. Global Max Update: Arch path through node
        max = Math.max(max, node.val + left + right);

        // 3. Return Single Branch Gain upward
        return node.val + Math.max(left, right);
    }
}