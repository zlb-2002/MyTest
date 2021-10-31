package leetcode;

public class SingleNumber {

    /*
    只出现一次的数字
    题目中有两个出现奇数个的数，所以异或运算一次不能找到这两个数，所以需要找到这两个数，就需要
    将这两个数分组，需要找到这两个数从右向左第一位不相同的二进制数，所以将这两个数异或的结果在进行
    按位与运算，x = x & -x  就找到了这两个数第一位不相同的数，再进行一次异或，按照不同的数进行
    异或就能找到这两个数
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
