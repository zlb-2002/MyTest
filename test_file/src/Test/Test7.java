package Test;

import java.util.ArrayList;
import java.util.Scanner;

public class Test7 {

    /*
    约瑟夫环
    获取幸运数字
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(getNum(num));
    }

    public static int getNum(int num) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1;i <= num;i++) {
            list.add(i);
        }

        int count = 1;
        for(int i = 0;list.size() != 1;i++) {
            if (i == (list.size())) {
                i = 0;
            }
            if(count % 3 == 0) {
                list.remove(i--);
            }
            count++;
        }
        return list.get(0);
    }

}
