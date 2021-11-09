package leetcode;

public class Rob {
    /*打家劫舍3
    打家劫舍需要找到不相邻的结点的最大和。只需要找包含这个节点的值和它孩子的孩子子树的和
    或者他孩子子树的和。递归寻找就找到了其最大值。
     */
    public int rob(TreeNode root) {
        int[] array = dfs(root);
        return Math.max(array[0], array[1]);
    }

    public int[] dfs (TreeNode root) {
        if (root == null) {
            return new int[]{0,0};
        }
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        int s = root.val + l[1] + r[1];
        int n = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[]{s, n};
    }

}
