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
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        calculateMax(root);
        return maxSum;
    }

    public int calculateMax(TreeNode root){
        // base case
        if (root == null) {
            return 0;
        }

        int left = Math.max( 0, calculateMax(root.left));
        int right = Math.max( 0, calculateMax(root.right)); // if we get a negetive node we will exclude that subtree path

        int currentMax = left + right + root.val;

        maxSum = Math.max( maxSum, currentMax );

        return root.val + Math.max( left, right );
    }
}