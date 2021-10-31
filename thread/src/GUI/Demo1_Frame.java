package GUI;

import java.awt.*;
import java.awt.event.*;

public class Demo1_Frame {

    public static void main(String[] args) {
        Frame f = new Frame("我的第一个窗口");
        f.setSize(400,600);                         //设置床群体大小
        f.setLocation(500,50);                              //设置窗体位置
        f.setIconImage(Toolkit.getDefaultToolkit().createImage("qq.png"));  //设置图标
        Button b1 = new Button("111");
        Button b2 = new Button("111");

        b1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {           //释放
                System.exit(0);
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        b1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    System.exit(0);
                }

            }
        });

        f.add(b1);
        f.add(b2);
        f.setLayout(new FlowLayout());          //设置布局管理器
        //f.addWindowListener(new MyWindowListener());
        //f.addWindowListener(new MyWindowAdapter());
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                System.exit(0);
            }
        });
        f.setVisible(true);                     //设置窗体可见
    }

}

/*
class MyWindowListener implements WindowListener {
    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("Closed");
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}*/

/*

class MyWindowAdapter extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}*/
