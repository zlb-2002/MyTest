package leetcode;

public class MinCostClimbingStairs {

    /*使用最小花费爬楼梯
    这道题主要是解决最小的花费，所以就需要找到之前的花费和这层楼梯花费两个和的最小花费。
    当找到了每层楼梯的最小花费，就找到了最终的结果.
    */

    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 1) {
            return cost[0];
        }
        int[] nums = new int[cost.length+1];
        nums[0] = 0;
        nums[1] = 0;
        for (int i = 2;i <= cost.length;i++) {
            nums[i] = Math.min(cost[i-1]+nums[i-1], cost[i-2]+nums[i-2]);
        }
        return nums[cost.length];
    }

}
