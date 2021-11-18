package leetcode;

import java.util.Arrays;

public class ArrayPairSum {

    /*数组拆分
    数组拆分需要找到分组后最小数的最大和，所以贪心策略就是找到分组后的最小值的最大和，
    所以就先将数组进行排序，因为两个一组，就找到每一个分组的最小的一个，将其加起来就是其最大值。
     */

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0;i < nums.length;i += 2) {
            count += nums[i];
        }
        return count;
    }

}
