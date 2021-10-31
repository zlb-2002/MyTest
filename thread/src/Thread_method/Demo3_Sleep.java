package Thread_method;

public class Demo3_Sleep {

    //当遇到sleep时线程将会休眠
    public static void main(String[] args) throws InterruptedException {
        //demo1();
        new Thread() {
            @Override
            public void run() {

                for (int i = 0;i < 10;i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + "aaaaa");
                }

            }
        }.start();

        new Thread() {
            @Override
            public void run() {

                for (int i = 0;i < 10;i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + "bbbbbbbbbbbbb");
                }
            }
        }.start();
    }

    private static void demo1() throws InterruptedException {
        for (int i = 20 ;i >= 0;i--) {
            Thread.sleep(1000);
            System.out.println("倒计时" + i + "秒");
        }
    }

}
