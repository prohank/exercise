package competitive.leetcode.easy;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 * Date: 19-05-2020
 * This problem was not solved. Below answer is taken from Solutions.
 *
 */
public class DiameterOfBinaryTree {
    int ans;

    public static void main(String[] args) {
        DiameterOfBinaryTree dbt = new DiameterOfBinaryTree();
        System.out.println("Diameter of tree " + dbt.diameterOfBinaryTree(new TreeNode()));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    public int depth(TreeNode node) {
        if (node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L + R + 1);
        return Math.max(L, R) + 1;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}