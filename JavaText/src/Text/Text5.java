package Text;

import java.util.Scanner;

public class Text5 {

    public static void main(String[] args) {
        double a, b, c;
        double r1, r2;
        Scanner sc = new Scanner(System.in);
        try {
            a = sc.nextDouble();
            b = sc.nextDouble();
            c = sc.nextDouble();
            if ((b*b-4*a*c) > 0) {
                r1 = (0-b+(Math.sqrt(b*b-4*a*c)))/2*a;
                r2 = (0-b-(Math.sqrt(b*b-4*a*c)))/2*a;
                System.out.println("The roots are " + r1 + " and " + r2);
            } else if ((b*b-4*a*c) == 0) {
                r1 = (0-b)/2*a;
                System.out.println("The roots is " + r1);
            } else {
                System.out.println("The equation no real roots");
            }
        } catch (Exception e) {
            System.out.println("输入的格式不正确！");
        }
    }

}
