package otherIO;

import java.io.*;

public class Demo7_PrintStream {


    public static void main(String[] args) throws FileNotFoundException {
        //demo1();
        PrintWriter pw = new PrintWriter(new FileOutputStream("f.txt"),true);
        //pw.println(97);             //�Զ�ˢ��ֻ���println����
        //pw.write(97);
        pw.print(97);
        //pw.println(97);
        pw.close();
    }

    private static void demo1() {
        System.out.println("aaa");
        PrintStream ps = System.out;        //��ȡ��׼�����
        ps.println(97);                     //�ײ�ͨ��Integer.toString()��97ת�����ַ�������ӡ
        ps.write(97);                    //��������ҵ���Ӧ��a��ӡ
        Person p1 = new Person("����",23);
        ps.println(p1);                     //��ӡ�����������ͣ������null���ʹ�ӡnull���������null�ʹ�ӡtoString����
        ps.close();
    }

}
