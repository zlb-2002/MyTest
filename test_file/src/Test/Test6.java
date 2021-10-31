package Test;

import java.math.BigInteger;

public class Test6 {

    public static void main(String[] args) {
        //求1000阶乘中所有的0的个数
        demo1();
        //求1000阶乘尾部0的个数
        demo2();
    }

    private static void demo2() {
        BigInteger bi1 = new BigInteger("1");
        for (int i = 1;i <= 1000;i++) {
            BigInteger bi2 = new BigInteger( i + "");
            bi1 = bi2.multiply(bi1);
        }

        String str = bi1.toString();
        StringBuilder sb = new StringBuilder(str);
        str = sb.reverse().toString();
        int count = 0;
        for(int i = 0;i < str.length();i++) {
            if ('0' != str.charAt(i)) {
                break;
            }
            count++;
        }
        System.out.println(count);
    }

    private static void demo1() {
        BigInteger bi1 = new BigInteger("1");
        for (int i = 1;i <= 1000;i++) {
            BigInteger bi2 = new BigInteger( i + "");
            bi1 = bi2.multiply(bi1);
        }

        String str = bi1.toString();
        int count = 0;
        for (int i = 0;i < str.length(); i++) {
            if ('0' == str.charAt(i)) {
                count++;
            }
        }
        System.out.println(count);
    }

}
