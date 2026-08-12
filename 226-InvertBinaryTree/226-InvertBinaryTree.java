// Last updated: 12/08/2026, 19:13:53
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        return root;
    }
}