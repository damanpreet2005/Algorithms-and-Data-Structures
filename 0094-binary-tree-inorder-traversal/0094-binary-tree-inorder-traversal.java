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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> tree = new ArrayList<>();
        inorder(root, tree);
        return tree;
    }

    public void inorder(TreeNode root, List<Integer> tree){
        if (root == null) {
            return;
        }
        inorder(root.left, tree); // go to leftest
        tree.add( root.val ); // store the leftest
        inorder(root.right, tree); // go to right id left not there
    }
}