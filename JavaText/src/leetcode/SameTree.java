package leetcode;

public class SameTree {

    /*��ͬ����
        ��ͬ�����������ı��������ǽ�������ͬʱ������������ǿ���һֱ������ȥ��
        ��˵����������ͬ������������ǲ��ܱ�����ȥ���ͽ����ݹ飬˵�����ǲ�����ͬ����
     */

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q != null) {
            return false;
        } else if (p != null && q == null) {
            return false;
        } else if (p == null && q == null) {
            return true;
        }
        boolean b1 = false;
        boolean b2 = false;
        if (p.val == q.val) {
            b1 = isSameTree(p.right, q.right);
            b2 = isSameTree(p.left, q.left);
        }
        return b1 && b2;
    }

}
