package socket;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo4_GUIChat extends Frame {

    private TextField tf;
    private Button send;
    private Button log;
    private Button clear;
    private Button shake;
    private TextArea viewText;
    private TextArea sendText;
    private DatagramSocket socket;
    private BufferedWriter bw;


    public Demo4_GUIChat () {
        init();
        centerPanel();
        southPanel();
        event();
    }

    public void event() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                try {
                    socket.close();
                    bw.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                System.exit(0);
            }
        });
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    send();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

                try {
                    new Receive();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        log.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    logFile();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewText.setText("");
            }
        });

        shake.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    send(new byte[]{-1},tf.getText());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }


        });

        sendText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER && e.isControlDown()) {        //   ctrl���Ƿ񱻰���
//                if(e.getKeyCode() == KeyEvent.VK_ENTER ) {
                    try {
                        send();
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            }
        });
    }

    private void shake() {
        int x = this.getLocation().x;
        int y = this.getLocation().y;


        try {
            this.setLocation(x + 20,y + 20);
            Thread.sleep(20);
            this.setLocation(x + 20,y + 20);
            Thread.sleep(20);
            this.setLocation(x - 20,y - 20);
            Thread.sleep(20);
            this.setLocation(x - 20,y - 20);
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void logFile() throws IOException {
        bw.flush();             //ˢ�»�����
        FileInputStream fis = new FileInputStream("config.txt");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        int len;
        byte[] arr = new byte[8192];
        while((len = fis.read(arr)) != -1) {
            baos.write(arr,0,len);
        }
        String str = baos.toString();
        viewText.setText(str);

        fis.close();
    }

    private void send(byte[] arr,String ip) throws IOException {

        DatagramPacket packet = new
                DatagramPacket(arr,arr.length, InetAddress.getByName(ip),9999);
        socket.send(packet);
    }


    private void send() throws Exception{
        String message  = sendText.getText();       //��ȡ��������ĵ�����
        String ip = tf.getText();       //��ȡip
        ip = ip.trim().length() == 0 ? "255.255.255.255" : ip;
        send(message.getBytes(),ip);

        String time = getCurrentTime();
        String str = time + "�Ҷ�" + (ip.equals("255.255.255.255") ? "������" : ip) + "˵\r\n" + message + "\r\n";
        viewText.append(str);       //����Ϣ��ӵ���ʾ������
        bw.write(str);
        sendText.setText("");


    }

    private String getCurrentTime() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");
        return sdf.format(d);
    }

    public void centerPanel() {
        Panel center = new Panel();             //�����м��Panel
        //��ʾ�ı�����
        viewText = new TextArea();
        //���͵��ı�����
        sendText = new TextArea(5,1);
        center.setLayout(new BorderLayout());          //����Ϊ�߽粼�ֹ�����
        center.add(sendText,BorderLayout.SOUTH);   //���͵��ı���������ϱ�
        center.add(viewText,BorderLayout.CENTER);  //��ʾ��������м�
        viewText.setEditable(false);
        viewText.setBackground(Color.WHITE);
        sendText.setFont(new Font("xxx", Font.PLAIN,15));
        viewText.setFont(new Font("xxx", Font.PLAIN,15));
        this.add(center,BorderLayout.CENTER);

    }

    public void southPanel() {
        Panel south = new Panel();          //�����ϱߵ�Panel

        tf = new TextField(15);         //�����ı��ֶδ洢ip��ַ
        tf.setText("127.0.0.1");
        //�������Ͱ�ť
        send = new Button("����");
        //������¼��ť
        log = new Button("��¼");
        //����������ť
        clear = new Button("����");
        //�����𶯰�ť
        shake = new Button("��");
        south.add(tf);
        south.add(send);
        south.add(log);
        south.add(clear);
        south.add(shake);
        this.add(south,BorderLayout.SOUTH);
    }

    public void init() {
        this.setLocation(500,50);
        this.setSize(400,600);
        new Receive().start();
        try {
            socket = new DatagramSocket();
            bw = new BufferedWriter(new FileWriter("config.txt",true));         //���������¼����Ҫ��β��׷��
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setVisible(true);
    }

    private class Receive extends Thread {
        public void run() {
            try {
                DatagramSocket socket = new DatagramSocket(9999);
                DatagramPacket packet = new DatagramPacket(new byte[8192],8192);
                while(true){
                    socket.receive(packet);
                    byte[] arr = packet.getData();
                    int len = packet.getLength();
                    if ( arr[0] == -1 && len  == 1) {
                        shake();
                        continue;
                    }
                    String message = new String(arr,0,len);
                    String time = getCurrentTime();
                    String ip = packet.getAddress().getHostAddress();
                    String str = time + " " + ip + "����˵:\r\n"+ message + "\r\n\r\n";
                    viewText.append(str);
                    bw.write(str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }


    public static void main(String[] args) {
        new Demo4_GUIChat();
    }

}
