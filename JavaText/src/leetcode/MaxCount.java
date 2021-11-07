package leetcode;

public class MaxCount {

    /*范围求和
    范围求和只需要找到这些范围中最小的那个范围就是所求的范围，
    当所求的范围找到之后，就只需要求其长和宽的积，就是最终所求的范围内最大的数的个数。
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
