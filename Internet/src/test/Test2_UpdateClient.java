package test;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Test2_UpdateClient {

    /*
    1.��ʾ����Ҫ�ϴ����ļ�·������֤·���Ƿ�����Լ��Ƿ����ļ���
    2.�����ļ���������
    3.���ս����������ڸ�����ʾ������ֱ���˳�
    4.��������ڣ�����FileinputStream��ȡ�ļ���д��������
     */
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1",12345);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream ps = new PrintStream(socket.getOutputStream());
        File file = getFile();
        ps.println(file.getName());
        System.out.println("�ļ����ϴ�");
        String result = br.readLine();
        if ("����".equals(result)) {
            System.out.println("���ϴ����ļ��Ѿ����ڣ��벻Ҫ�ظ��ϴ���");
            return ;
        }

        FileInputStream fis = new FileInputStream(file);
        byte[] arr = new byte[8192];
        int len;

        System.out.println("�ļ���ʼ�ϴ�");
        while ((len = fis.read(arr)) != -1) {
            ps.write(arr,0, len);
        }
        fis.close();
        socket.close();
    }

    private static File getFile() {
        Scanner sc = new Scanner(System.in);
        System.out.println("������һ���ļ�·����");
        while (true) {
            String line = sc.nextLine();
            File file = new File(line);

            if (!file.exists()) {
                System.out.println("�ļ������ڣ�������¼�룺");
            } else if (file.isDirectory()) {
                System.out.println("��¼������ļ���·����������һ���ļ�·����");
            } else {
                return file;
            }
        }

    }

}
