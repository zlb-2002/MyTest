package 枚举类;

public class Demo_Enum {

    public static void main(String[] args) {
        Week2 mon = Week2.MON;
        Week2 tue = Week2.TUE;
        Week2 wed = Week2.WED;

        //demo1(mon, tue, wed);
        //demo2(mon, tue);

        //demo2();
        Week2[] arr = Week2.values();           //可以获取每一个枚举项
        for (Week2 week2 : arr) {
            System.out.println(week2);
        }
    }

    private static void demo2() {
        Week2 mon2 = Week2.valueOf(Week2.class,"MON");      //通过字节码对象获取枚举项
        System.out.println(mon2);
    }

    private static void demo2(Week2 mon, Week2 tue) {
        System.out.println(mon.name);
        System.out.println(tue.toString());
    }

    private static void demo1(Week2 mon, Week2 tue, Week2 wed) {
        System.out.println(mon.ordinal());              //枚举项是有编号的
        System.out.println(tue.ordinal());
        System.out.println(wed.ordinal());

        System.out.println(mon.compareTo(tue));         //比较编号
        System.out.println(mon.compareTo(wed));
    }
}
