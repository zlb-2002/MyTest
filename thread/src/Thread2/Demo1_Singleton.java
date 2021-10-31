package Thread2;

public class Demo1_Singleton {

    public static void main(String[] args) {
        //Singleton s1 = new Singleton();
        Singleton s1 = Singleton.s;
        Singleton s2 = Singleton.s;
    }

}

/*
    饿汉式

class Singleton {
    //私有构造方法，其他类不能访问该构造方法
    private Singleton(){}
    //创建本类对象
    private static Singleton s = new Singleton();
    //对外提供公共访问方法
    public static Singleton getInstance() {
        return s;
    }
} */

/*
    懒汉式，单例的延迟加载模式
 */

/*
class Singleton {
    //私有构造方法，其他类不能访问该构造方法
    private Singleton(){}
    //创建本类对象
    private static Singleton s;
    //对外提供公共访问方法
    public static Singleton getInstance() {     //获取实例
        if(s == null) {
            s = new Singleton();
        }
        return s;
    }
}*/
/*
饿汉式和懒汉式的区别：
    1.饿汉式是空间换时间，懒汉式是时间换空间
    2.在多线程访问时，懒汉式不会创建多个对象，懒汉式可能会创建多个对象

 */
class Singleton {
    private Singleton(){}

    public static final Singleton s = new Singleton();
}
