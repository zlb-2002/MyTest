package Thread;

public class Demo2_Thread {

    public static void main(String[] args) {
        MyThread mt = new MyThread();
        mt.start();

        for (int i = 0;i < 1000;i++) {
            System.out.println("bb");
        }
    }
}

class MyThread extends Thread {             //继承Thread
    @Override                               //重写run方法
    public void run() {                     //将要执行的代码写在了run方法中
        for (int i = 0;i < 1000; i++) {
            System.out.println("aaaaaaaaa");
        }
    }
}