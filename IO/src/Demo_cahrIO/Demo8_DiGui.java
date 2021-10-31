package Demo_cahrIO;

import java.util.Scanner;

public class Demo8_DiGui {

    /*
    递归：方法自己调用自己
    5!
    递归的弊端：
        不能调用次数过多，容易导致栈内存溢出
    递归的好处：
        不用知道循环的次数
    构造方法不能使用递归调用

    递归调用是否必须有返回值?
    不一定（可以有，也可以没有）
     */
    public static void main(String[] args) {
        //demo1();
        Scanner sc = new Scanner(System.in);
        int x;
        x = sc.nextInt();
        x = fun(x);
        System.out.println(x);
    }

    public static int fun(int num) {
        if(num == 1) return 1;
        else return num * fun(num - 1);
    }

    private static void demo1() {
        int result = 1;
        for(int i = 1;i < 6;i++) {
            result = result * i;
        }
        System.out.println(result);
    }

}
