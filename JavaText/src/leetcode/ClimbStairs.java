package leetcode;

public class ClimbStairs {

    /*爬楼梯
    爬楼梯就是一个斐波那契数列，因为你上一步楼梯会有两种方式，要么是上一步楼梯，要么是两步楼梯，
    所以就是一个简单的斐波那契数列。
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
