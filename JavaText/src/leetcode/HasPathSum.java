package leetcode;

public class HasPathSum {


    /*·���ܺ�
    ·���ܺ� �������Ҫ֪������·���ܺͣ����Է���˼����ֻ��Ҫ���targetSum
    �����Ҷ�ӽڵ��ֵ�Ƿ�Ϊ0��Ϊ0���Ƿ���Ϊ�棬��Ϊ0���Ƿ���Ϊ�١�Ϊ�շ���false��һ��·����֮��ͻ��ݡ�
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        targetSum -= root.val;
        if (root.right == null && root.left == null) {
            if (targetSum == 0) {
                return true;
            } else {
                return false;
            }
        }
        boolean b1 = false;
        boolean b2 = false;
        b1 = hasPathSum(root.right, targetSum);
        b2 = hasPathSum(root.left, targetSum);
        return b1 || b2;
    }

}
