package ö��;

public class Week2 {

    public static final Week2 MON = new Week2("����һ");
    public static final Week2 TUE = new Week2("���ڶ�");
    public static final Week2 WED = new Week2("������");

    private String name;

    private Week2(String name) {
        this.name = name;
    }                   //�����������

    public String getName () {
        return name;
    }


}
