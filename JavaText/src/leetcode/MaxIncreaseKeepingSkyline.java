package leetcode;

public class MaxIncreaseKeepingSkyline {

    /*���ֳ��������
    �������Ҫ��Ҫ�ҵ��������������������󣬵��ҵ���Щʱ���Ϳ�������µ�¥�ߺͣ���¥�ߺ�����������������Сֵ����������̰�ĵ�˼�롣*/
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if (grid.length == 0)
            return 0;
        int[] nums1 = new int[grid.length];
        int[] nums2 = new int[grid.length];
        for (int i = 0;i < grid.length;i++) {
            int max = 0;
            for (int j = 0;j < grid[i].length;j++)
                max = Math.max(max, grid[i][j]);
            nums1[i] = max;
        }
        for (int i = 0;i < grid[0].length;i++) {
            int max = 0;
            for (int[] ints : grid)
                max = Math.max(max, ints[i]);
            nums2[i] = max;
            }
        int count1 = 0;
        int count = 0;
        for (int i = 0;i < grid.length;i++) {
            for (int j = 0;j < grid[i].length;j++) {
                count += Math.min(nums1[i], nums2[j]);
                count1 += grid[i][j];
            }
        }
        return count-count1;
    }

}
