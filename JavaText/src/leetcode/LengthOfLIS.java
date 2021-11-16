package leetcode;

import java.util.*;

public class LengthOfLIS {

    /*����������� ֮ǰ��������⣬����û��⣬������������һ��
    ���Ǹ����Ǹ���̬�滮����Ŀ���������Ҫ�ҵ����ĵ������У�����Ҫ�ҵ�ÿһ��Ԫ��
    ����֮ǰ����ĵ��������У���Ҫһ�����齫���¼������������ҵ��������������⣬
    �������������ܹ����������⡣��̬�滮����Ҫ�������������Ž⣬�����ҵ������������Ž⡣
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
