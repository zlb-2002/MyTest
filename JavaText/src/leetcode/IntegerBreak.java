package leetcode;

public class IntegerBreak {

    /*整数拆分
    整数拆分主要是是找到一个数，这个数加上前面的数或者加上前面的数的整数拆分的结果值最大，
    就找到了这个最终的结果。很典型的使用了动态规划思想。
     */

    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        for (int i = 2;i < dp.length;i++) {
            int max = 0;
            for (int j = 1;j < i;j++) {
                max = Math.max(max, Math.max(j*(i-j), j*dp[i-j]));
            }
            dp[i] = max;
        }
        return dp[n];
    }

}
