package leetcode;

public class Rob1 {

    /*打家劫舍
    打家劫舍是典型的动态规划，需要一个数组，记录这个位置之前能够拿到的最多的钱数，
    在判断当前的这个节点是否需要时，就需要找到是除了前一个之前的所有最多的加上当前
    节点大还是不要当前节点之前的最大值大，这就是找到每一项最多的钱数。
     */

    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int[] number = new int[nums.length];
        number[0] = nums[0];
        number[1] = Math.max(nums[0], nums[1]);
        for (int i = 2;i < nums.length;i++) {
            number[i] = Math.max(number[i-2]+nums[i], number[i-1]);
        }
        return number[number.length-1];
    }

}
