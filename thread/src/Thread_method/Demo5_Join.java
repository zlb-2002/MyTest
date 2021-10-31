package Thread_method;

public class Demo5_Join {

    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0;i < 10;i++) {
                    System.out.println(getName() + "..aaa");
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0;i < 10;i++) {
                    if (i == 2) {
                        try {
                            t1.join(1);     //插入一毫秒
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println(getName() + ".bb");
                    }
                }
            }
        };

        t1.start();
        t2.start();
    }

}
