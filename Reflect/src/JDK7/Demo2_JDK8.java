package JDK7;

public class Demo2_JDK8 {

    /*
    接口中可以定义有方法体的方法，如果是非静态，必须用defult修饰，如果是静态的就不用了
     */
    public static void main(String[] args) {
        //new Demo().print();
        new Demo().run();
    }
}

interface Inter {
    public default void print() {
        System.out.println("helloWorld");
    }

    public static void method () {
        System.out.println("static method");
    }

}

class Demo implements Inter {
    public void run () {
        class Inner {
            public void fun() {
                System.out.println("fun");
            }
        }
        Inner i = new Inner();
        i.fun();
    }
}