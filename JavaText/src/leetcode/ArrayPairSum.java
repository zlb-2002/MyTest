package leetcode;

import java.util.Arrays;

public class ArrayPairSum {

    /*������
    ��������Ҫ�ҵ��������С�������ͣ�����̰�Ĳ��Ծ����ҵ���������Сֵ�����ͣ�
    ���Ծ��Ƚ��������������Ϊ����һ�飬���ҵ�ÿһ���������С��һ����������������������ֵ��
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
