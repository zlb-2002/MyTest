package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Demo1_Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",12345);

        InputStream is = socket.getInputStream();       //��ȡ�ͻ���������
        OutputStream os = socket.getOutputStream();     //��ȡ�ͻ��˵������

        byte[] arr = new byte[1024];
        int len = is.read(arr);                           //��ȡ������������������
        System.out.println(new String(arr,0,len));  //������ת�����ַ�������ӡ

        os.write("ѧϰ�ھ�������ļ�ǿ��".getBytes());
        socket.close();
    }


}
