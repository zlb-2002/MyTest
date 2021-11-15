package leetcode;

public class ClimbStairs {

    /*��¥��
    ��¥�ݾ���һ��쳲��������У���Ϊ����һ��¥�ݻ������ַ�ʽ��Ҫô����һ��¥�ݣ�Ҫô������¥�ݣ�
    ���Ծ���һ���򵥵�쳲��������С�
     */

    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int x = 1;
        int y = 2;
        int count = 0;
        for (int i = 0;i < n-2;i++) {
            count = x + y;
            x = y;
            y = count;
        }
        return count;
    }

}
