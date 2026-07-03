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
    ArrayList<Integer> res = new ArrayList<>();

    public void preorderDFS(TreeNode root) {
        if(root == null)    return;

        res.add(root.val);
        preorderDFS(root.left);
        preorderDFS(root.right);
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        preorderDFS(root);
        return res;
    }
}