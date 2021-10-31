import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class Test3 {

    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3};
        int target = 7;
        int x = Target(target,arr);
        System.out.println(x);
    }

    public static int Target (int target,int[] arr) {
        TreeSet<Integer> list = new TreeSet<>();
        int sum = 0;
        int i,j;
        for (i = arr.length - 1;i >= 0;i--) {
            sum = 0;
            for (j = i;sum < target && j >= 0 ;j--) {
                sum = sum + arr[j];
            }
            if (sum >= target ) {
                list.add(i - j);
            }

        }
        if (list.isEmpty()) {
            return 0;
        } else {
            return list.first();
        }
    }


}
