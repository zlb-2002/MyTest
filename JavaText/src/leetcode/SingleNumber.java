package leetcode;

public class SingleNumber {

    /*
    ֻ����һ�ε�����
    ��Ŀ�����������������������������������һ�β����ҵ�����������������Ҫ�ҵ���������������Ҫ
    �������������飬��Ҫ�ҵ������������������һλ����ͬ�Ķ������������Խ������������Ľ���ڽ���
    ��λ�����㣬x = x & -x  ���ҵ�������������һλ����ͬ�������ٽ���һ����򣬰��ղ�ͬ��������
    �������ҵ���������
     */
    public int[] singleNumber(int[] nums) {
        int x = 0;
        for (int i : nums) {
            x = x ^ i;
        }
        int num1 = 0;
        int num2 = 0;
        x = x & -x;
        for (int i : nums) {
            if ((i & x) != 0) {
                num1 ^= i;
            } else {
                num2 ^= i;
            }
        }
        return new int[]{num1, num2};
    }
}
