package leetcode;

import java.util.*;

public class LengthOfLIS {

    /*最长递增子序列 之前做过这道题，但是没理解，现在再重新做一遍
    这是个这是个动态规划的题目，这道题需要找到最大的递增序列，就需要找到每一个元素
    在它之前的最长的递增子序列，需要一个数组将其记录下来，这就是找到这个问题的子问题，
    解决了子问题就能够解决这个问题。动态规划就是要解决子问题的最优解，就是找到这个问题的最优解。
     */

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int max = 1;
        dp[0] = 1;
        for (int i = 1; i < nums.length;i++) {
            dp[i] = 1;
            for (int j = 0;j < i;j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        List<Integer> list = new ArrayList<>();
        
        return max;
    }
}
