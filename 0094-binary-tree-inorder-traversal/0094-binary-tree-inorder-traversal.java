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

        List<Integer> result = new ArrayList<>();
        TreeNode curr = root;

        while (curr != null) {
            // case 1 curr.left -> null
            if (curr.left == null) {
                result.add(curr.val);
                curr = curr.right;
            } 

            // case 2 to find the right most element in the left subtree and connect it with the curr
            else {
                TreeNode pred = curr.left;

                //find the right most element (it shouldnt be linked to curr)
                while (pred.right != null && pred.right != curr){
                    pred = pred.right;
                }

                // the rightmost element is not connected to curr
                if (pred.right == null) {
                    pred.right = curr;  // connect the thread
                    curr = curr.left; // the left tree is not visited, go explore it
                }

                // the rightmost element is connected to curr
                else { 
                    pred.right = null;  // destroy the thread
                    result.add(curr.val); // We are visiting this node again
                    curr = curr.right; // now go right
                }
            }
        }

        return result;
    }
}