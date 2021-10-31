package JDK7;

public class Demo2_JDK8 {

    /*
    �ӿ��п��Զ����з�����ķ���������ǷǾ�̬��������defult���Σ�����Ǿ�̬�ľͲ�����
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