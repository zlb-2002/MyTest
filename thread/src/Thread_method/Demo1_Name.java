package Thread_method;

public class Demo1_Name {

    public static void main(String[] args) {
        //demo1();
        //demo2();
        //demo3();
    }

    private static void demo3() {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println(this.getName() + "a");
            }
        };
        t1.setName("张三");

        Thread t2 = new Thread() {
            @Override
            public void run() {
                System.out.println(this.getName() + "b");
            }
        };
        t2.setName("李四");

        t1.start();
        t2.start();
    }

    private static void demo2() {
        new Thread() {
            public void run() {
                this.setName("张三");
                System.out.println(this.getName() + "a");
            }
        }.start();

        new Thread() {
            public void run() {
                this.setName("李四");
                System.out.println(this.getName() + "b");
            }
        }.start();
    }

    private static void demo1() {
        new Thread("QQ") {
            public void run() {
                System.out.println(this.getName() + "aaaaaaaaaa");
            }
        }.start();

        new Thread("微信") {
            public void run() {
                System.out.println(this.getName() + "bb");
            }
        }.start();
    }
}
