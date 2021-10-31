package Demo_cahrIO;

public class Demo6_Wrap {

    public static void main(String[] args) {
        XUPTStudent xs = new XUPTStudent(new Student());
        xs.code();
    }
}

interface Coder {
    public void code();
}

class Student implements Coder {

    @Override
    public void code() {
        System.out.println("javaee");
        System.out.println("javaweb");
    }

}

class XUPTStudent implements Coder {
    //获取装饰类的引用
    private Student s;



    //在构造方法中传入被装饰类的对象
    public XUPTStudent() {};

    public XUPTStudent(Student s) {
        this.s = s;
    }

    //3.对原有的功能进行升级
    @Override
    public void code() {
        s.code();
        System.out.println("ssh");
        System.out.println("数据库");
        System.out.println("大数据");
        System.out.println("Android");
        System.out.println("...");

    }

}
