package ö����;

public class Demo_Enum {

    public static void main(String[] args) {
        Week2 mon = Week2.MON;
        Week2 tue = Week2.TUE;
        Week2 wed = Week2.WED;

        //demo1(mon, tue, wed);
        //demo2(mon, tue);

        //demo2();
        Week2[] arr = Week2.values();           //���Ի�ȡÿһ��ö����
        for (Week2 week2 : arr) {
            System.out.println(week2);
        }
    }

    private static void demo2() {
        Week2 mon2 = Week2.valueOf(Week2.class,"MON");      //ͨ���ֽ�������ȡö����
        System.out.println(mon2);
    }

    private static void demo2(Week2 mon, Week2 tue) {
        System.out.println(mon.name);
        System.out.println(tue.toString());
    }

    private static void demo1(Week2 mon, Week2 tue, Week2 wed) {
        System.out.println(mon.ordinal());              //ö�������б�ŵ�
        System.out.println(tue.ordinal());
        System.out.println(wed.ordinal());

        System.out.println(mon.compareTo(tue));         //�Ƚϱ��
        System.out.println(mon.compareTo(wed));
    }
}
