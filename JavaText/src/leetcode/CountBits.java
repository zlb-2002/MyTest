package leetcode;

public class CountBits {

    /* 比特位计数
        比特位计数主要是要找出每个数的二进制中存在多少的1，使用X = X & （X-1）这种方法将最后一位是1的数变为0，
        直到这个数全部变为0，就找到了这个数二进制中存在的1的个数。
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
