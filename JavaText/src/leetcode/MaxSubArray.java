package leetcode;

public class MaxSubArray {


    /* 最大子序和
    最大子序和 需要找到数组中最大的子序和，需要用贪心来解决。
    当在一个数之前的和小于0，就将其舍弃，如果是大于0，就加上当前这一位数，
    最后判断加上这个数之后是否有之前的最大值大，若比之前的大，就更新max值，若没有之前的max值大，就不需要更新max值。
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int x = nums[0];
        int max = x;
        for (int i = 1;i < nums.length;i++) {
            if (x >= 0) {
                x += nums[i];
            } else {
                x = nums[i];
            }
            max = Math.max(x, max);
        }
        return max;
    }

}
