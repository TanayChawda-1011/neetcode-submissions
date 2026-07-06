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

// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         if(root == null)    return true;

//         boolean left = true;
//         if(root.left != null && root.left.val >= root.val)
//             left = false;
//         boolean right = true;
//         if(root.right != null && root.right.val <= root.val)
//             right = false;

//         return left && right && isValidBST(root.left) && isValidBST(root.right);
//     }
// }

class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public boolean helper(TreeNode root, int max, int min) {
        if(root == null)    return true;

        if(root.val >= max || root.val <= min)
            return false;
        
        boolean left = helper(root.left, root.val, min);
        boolean right = helper(root.right, max, root.val);

        return left && right;        
    }
}
