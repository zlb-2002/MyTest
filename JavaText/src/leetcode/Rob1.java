package leetcode;

public class Rob1 {

    /*��ҽ���
    ��ҽ����ǵ��͵Ķ�̬�滮����Ҫһ�����飬��¼���λ��֮ǰ�ܹ��õ�������Ǯ����
    ���жϵ�ǰ������ڵ��Ƿ���Ҫʱ������Ҫ�ҵ��ǳ���ǰһ��֮ǰ���������ļ��ϵ�ǰ
    �ڵ���ǲ�Ҫ��ǰ�ڵ�֮ǰ�����ֵ��������ҵ�ÿһ������Ǯ����
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
