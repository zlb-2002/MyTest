package Text;

import java.util.Scanner;

public class Text4 {

    public static void main(String[] args) {
        double x1, x2, x3;
        double y1, y2, y3;
        double side1, side2, side3;
        double s, area;
        Scanner sc = new Scanner(System.in);
        try {
            x1 = sc.nextDouble();
            y1 = sc.nextDouble();
            x2 = sc.nextDouble();
            y2 = sc.nextDouble();
            x3 = sc.nextDouble();
            y3 = sc.nextDouble();

            side1 = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
            side2 = Math.sqrt((x1-x3)*(x1-x3) + (y1-y3)*(y1-y3));
            side3 = Math.sqrt((x3-x2)*(x3-x2) + (y3-y2)*(y3-y2));
            s = (side1 + side2 + side3) / 2;
            area = Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
            if (area <= 0) {
                System.out.println("输入的数据不正确！");
            } else {
                System.out.printf("The area of the triangle is %.1f", area);
            }
        } catch (Exception e) {
            System.out.println("输入的格式不正确！");
        }
    }

}
