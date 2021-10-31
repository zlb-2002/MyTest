package Thread_method;

public class Demo7_Priority {

    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0;i < 1000;i++) {
                    System.out.println(getName() + "....aaaaaaaa");
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0;i < 1000;i++) {
                    System.out.println(getName() + "..bb");
                }
            }
        };

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
    }

}
