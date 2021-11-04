package leetcode;

public class MaxSubArray {


    /* ��������
    �������� ��Ҫ�ҵ���������������ͣ���Ҫ��̰���������
    ����һ����֮ǰ�ĺ�С��0���ͽ�������������Ǵ���0���ͼ��ϵ�ǰ��һλ����
    ����жϼ��������֮���Ƿ���֮ǰ�����ֵ������֮ǰ�Ĵ󣬾͸���maxֵ����û��֮ǰ��maxֵ�󣬾Ͳ���Ҫ����maxֵ��
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
