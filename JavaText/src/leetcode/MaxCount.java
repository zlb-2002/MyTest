package leetcode;

public class MaxCount {

    /*��Χ���
    ��Χ���ֻ��Ҫ�ҵ���Щ��Χ����С���Ǹ���Χ��������ķ�Χ��
    ������ķ�Χ�ҵ�֮�󣬾�ֻ��Ҫ���䳤�Ϳ�Ļ���������������ķ�Χ���������ĸ�����
     */

    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0) {
            return m*n;
        }
        int x,y;
        x = ops[0][0];
        y = ops[0][1];
        for (int i = 0;i < ops.length;i++) {
            x = Math.min(x, ops[i][0]);
            y = Math.min(y, ops[i][1]);
        }
        return x*y;
    }

}
