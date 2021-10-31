package Test;

import java.util.Scanner;

public class Test5 {

    /*
    斐波那契数列的计算
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要求的斐波那契数列的序号：");
        int x = sc.nextInt();
        System.out.println(Fib(x));
        String s = "abc" + 1;
        System.out.println(s);
    }

    public static int Fib(int x) {
        if (x == 1 || x == 2) {
            return 1;
        } else {
            return Fib(x - 2) + Fib(x - 1);
        }
    }

}
