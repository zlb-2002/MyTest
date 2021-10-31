package Thread;

public class Demo4_Thread {

    public static void main(String[] args) {
        new Thread() {                                  //继承Thread类
            @Override
            public void run() {                         //重写run()方法
                for (int i = 0;i < 1000;i++) {          //将要执行的代码写在run方法中
                    System.out.println("aaaaaaaaa");
                }
            }
        }.start();                                      //开启线程


        new Thread(new Runnable() {                     //将Runnable的子类对象传递给Thread的构造方法
            @Override
            public void run() {                         //重写run()方法
                for (int i = 0;i < 1000;i++) {          //将要执行的代码写在run()方法中
                    System.out.println("bb");
                }
            }
        }).start();                                     //开启线程
    }
}
