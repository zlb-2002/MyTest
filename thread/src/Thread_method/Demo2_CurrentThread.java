package Thread_method;

public class Demo2_CurrentThread {

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                System.out.println(getName() + "..aa");
            }
        }.start();

        new Thread(new Runnable() {
            public void run() {
                //Thread.currentThread()   获取当前线程
                System.out.println(Thread.currentThread().getName() + "..bb");
            }
        }).start();

        Thread.currentThread().setName("我是主线程");
        System.out.println(Thread.currentThread().getName());
    }

}
