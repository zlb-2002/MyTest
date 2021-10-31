package Ã¶¾Ù;

public class Demo1_Enum {

    public static void main(String[] args) {
        //demo1();
        //demo2();
        //demo3();
    }

    private static void demo3() {
        Week3 mon = Week3.MON;
        mon.show();
    }

    private static void demo2() {
        Week2 mon = Week2.MON;
        Week2 tue = Week2.TUE;
        Week2 wed = Week2.WED;
        System.out.println(mon.getName());
        System.out.println(tue.getName());
        System.out.println(wed.getName());
    }

    private static void demo1() {
        Week mon = Week.MON;
        Week tue = Week.TUE;
        Week wed = Week.WED;
    }
}
