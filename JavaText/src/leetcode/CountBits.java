package leetcode;

public class CountBits {

    /* ����λ����
        ����λ������Ҫ��Ҫ�ҳ�ÿ�����Ķ������д��ڶ��ٵ�1��ʹ��X = X & ��X-1�����ַ��������һλ��1������Ϊ0��
        ֱ�������ȫ����Ϊ0�����ҵ���������������д��ڵ�1�ĸ�����
     */
    public int[] countBits(int n) {
        int[] num = new int[n+1];
        for (int i = 0;i <= n;i++) {
            num[i] = count(i);
        }
        return num;
    }

    public int count(int n) {
        int x = 0;
        while (n > 0) {
            n = n & (n - 1);
            ++x;
        }
        return x;
    }

}
