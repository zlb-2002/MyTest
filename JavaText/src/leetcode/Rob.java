package leetcode;

public class Rob {
    /*��ҽ���3
    ��ҽ�����Ҫ�ҵ������ڵĽ������͡�ֻ��Ҫ�Ұ�������ڵ��ֵ�������ӵĺ��������ĺ�
    ���������������ĺ͡��ݹ�Ѱ�Ҿ��ҵ��������ֵ��
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
