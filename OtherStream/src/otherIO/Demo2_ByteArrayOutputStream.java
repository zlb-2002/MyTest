package otherIO;

import java.io.*;

public class Demo2_ByteArrayOutputStream {

    public static void main(String[] args) throws IOException {
        //Demo1();

        Demo2();
    }

    private static void Demo2() throws IOException {
        //����һ���ļ������������read(byte[] b)��������a.txt�ļ��е����ݴ�ӡ������byte�����С����Ϊ5��
        /*
        ������
            1.read(byte[] b)���ֽ���������ķ���������FileInputStream������e.txt
            2.�����ڴ��������������������д���ڴ��������
            3.�����ֽ����飬����Ϊ5
            4.���ڴ������������ȫ��ת��Ϊ�ַ�����ӡ
            5.�ر�������
         */
        FileInputStream fis = new FileInputStream("e.txt");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        byte[] arr = new byte[5];
        int len;
        while ((len = fis.read(arr)) != -1) {
            baos.write(arr,0,len);
        }

        System.out.println(baos);
        fis.close();
    }

    private static void Demo1() throws IOException {
        FileInputStream fis = new FileInputStream("e.txt");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();     //���ڴ��д����˿����������ڴ�����

        int b;
        while ((b = fis.read()) != -1) {
            baos.write(b);
        }

        byte[] arr = baos.toByteArray();
        System.out.println(new String(arr));

        System.out.println(baos.toString());        //��������������ת��Ϊ�ַ���

        fis.close();

    }

}
