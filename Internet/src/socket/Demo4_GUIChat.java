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
                if (e.getKeyCode() == KeyEvent.VK_ENTER && e.isControlDown()) {        //   ctrl键是否被按下
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
        bw.flush();             //刷新缓冲区
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
        String message  = sendText.getText();       //获取发送区域的的内容
        String ip = tf.getText();       //获取ip
        ip = ip.trim().length() == 0 ? "255.255.255.255" : ip;
        send(message.getBytes(),ip);

        String time = getCurrentTime();
        String str = time + "我对" + (ip.equals("255.255.255.255") ? "所有人" : ip) + "说\r\n" + message + "\r\n";
        viewText.append(str);       //将信息添加到显示区域中
        bw.write(str);
        sendText.setText("");


    }

    private String getCurrentTime() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        return sdf.format(d);
    }

    public void centerPanel() {
        Panel center = new Panel();             //创建中间的Panel
        //显示文本区域
        viewText = new TextArea();
        //发送的文本区域
        sendText = new TextArea(5,1);
        center.setLayout(new BorderLayout());          //设置为边界布局管理器
        center.add(sendText,BorderLayout.SOUTH);   //发送的文本区域放在南边
        center.add(viewText,BorderLayout.CENTER);  //显示区域放在中间
        viewText.setEditable(false);
        viewText.setBackground(Color.WHITE);
        sendText.setFont(new Font("xxx", Font.PLAIN,15));
        viewText.setFont(new Font("xxx", Font.PLAIN,15));
        this.add(center,BorderLayout.CENTER);

    }

    public void southPanel() {
        Panel south = new Panel();          //创建南边的Panel

        tf = new TextField(15);         //创建文本字段存储ip地址
        tf.setText("127.0.0.1");
        //创建发送按钮
        send = new Button("发送");
        //创建记录按钮
        log = new Button("记录");
        //创建清屏按钮
        clear = new Button("清屏");
        //创建震动按钮
        shake = new Button("震动");
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
            bw = new BufferedWriter(new FileWriter("config.txt",true));         //保留聊天记录，需要在尾部追加
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
                    String str = time + " " + ip + "对我说:\r\n"+ message + "\r\n\r\n";
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
