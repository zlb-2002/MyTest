package Text;

import java.util.Scanner;

public class Text7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        int f = sc.nextInt();
        LinearEquation l = new LinearEquation(a,b,c,d,e,f);
        if (l.isSolvable()) {
            System.out.println(l.getX());
            System.out.println(l.getY());
        } else {
            System.out.println("The equation has no solution");
        }
    }

}

class LinearEquation {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;

    public LinearEquation(int a, int b, int c, int d, int e, int f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public int getD() {
        return d;
    }

    public int getE() {
        return e;
    }

    public int getF() {
        return f;
    }

    public boolean isSolvable () {
        return (a * d - b * c) != 0;
    }

    public double getX () {
        if (isSolvable()) {
            return (e*d - b*f)/(a*d - b*c);
        }
        return 0;
    }

    public double getY () {
        if (isSolvable()) {
            return (a*f - e*c)/(a*d - b*c);
        }
        return 0;
    }

}
