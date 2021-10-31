package syn;

public class Demo5_DeadLock {

    /*
    Vector 是线程安全的，ArrayList是线程不安全的
    StringBuffer是线程安全的。StringBuilder是线程不安全的
    HashMap是线程不安全的，Hashable是线程不安全的
     */

    private static String s1 = "筷子左";
    private static String s2 = "筷子右";
    public static void main(String[] args) {

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (s1) {
                        System.out.println(getName() + "获取" + s1 + "等待" + s2);
                        synchronized (s2) {
                            System.out.println(getName() +  "拿到" + s2 + "开吃");
                        }

                    }
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (s2) {
                        System.out.println(getName() + "获取" + s2 + "等待" + s1);
                        synchronized (s1) {
                            System.out.println(getName() +  "拿到" + s1 + "开吃");
                        }
                    }
                }
            }
        }.start();
    }

}
