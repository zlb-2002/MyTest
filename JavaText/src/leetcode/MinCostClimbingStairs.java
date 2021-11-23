package leetcode;

public class MinCostClimbingStairs {

    /*ʹ����С������¥��
    �������Ҫ�ǽ����С�Ļ��ѣ����Ծ���Ҫ�ҵ�֮ǰ�Ļ��Ѻ����¥�ݻ��������͵���С���ѡ�
    ���ҵ���ÿ��¥�ݵ���С���ѣ����ҵ������յĽ��.
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
