package Thread_method;

public class Demo4_Daemon {

    //设置一个线程为守护线程，该线程不会单独执行，当其他非守护线程都执行结束后，自动退出
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0;i < 50;i++) {
                    System.out.println(getName() + "...aaaaa");
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0;i < 2;i++) {
                    System.out.println(getName() + "..bb");
                }
            }
        };

        t1.setDaemon(true);     //设置守护线程
        t1.start();
        t2.start();
    }

}
