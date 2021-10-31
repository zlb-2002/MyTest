package socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Demo2_Send {

    /*
    1.发送Send
    创建DatagramSocket，随机端口号
    创建DatagramPacket,指定数据，长度，地址，端口
    使用DatagramSocket发送DatagramPacket
    关闭DatagramSocket
     */

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        DatagramSocket socket = new DatagramSocket();               //创建socket相当于码头
        while (true) {
            String str = sc.nextLine();
            if (!"quit".equals(str)) {
                DatagramPacket packet = new                                 //创建Packet相当于集装箱
                        DatagramPacket(str.getBytes(),str.getBytes().length, InetAddress.getByName("127.0.0.1"),6666);
                socket.send(packet);                                        //发货，将数据发出去

            } else {
                break;
            }

        }
        socket.close();

    }

}
