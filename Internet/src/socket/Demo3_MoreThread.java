package socket;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Demo3_MoreThread {

    public static void main(String[] args) {
        new Receive().start();

        new Send().start();
    }

}

class Receive extends Thread {
    @Override
    public void run() {
       try {
           DatagramSocket socket = new DatagramSocket(6666);       //创建socket，相当于创建码头
           DatagramPacket packet = new DatagramPacket(new byte[1024],1024);    //创建Packet相当于集装箱
           while (true) {

               socket.receive(packet);                 //接货

               byte[] arr = packet.getData();          //获取数据
               int len = packet.getLength();           //获取有效字节个数
               String ip = packet.getAddress().getHostAddress();
               int port = packet.getPort();
               System.out.println(ip + ":" + port + ":" + new String(arr,0,len));
           }
       } catch (IOException e) {
           e.printStackTrace();
       }

    }
}

class Send extends Thread {
    @Override
    public void run() {
        try {
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
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
