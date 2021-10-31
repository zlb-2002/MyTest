package 动态代理;


import java.lang.reflect.Proxy;

public class Test {

    //动态代理

    public static void main(String[] args) {
        //demo1();
        StudentImp si = new StudentImp();
        si.login();
        si.submit();

        System.out.println("-------------");
        MyInvocationHanderler m = new MyInvocationHanderler(si);
        Student s = (Student) Proxy.newProxyInstance(si.getClass().getClassLoader(), si.getClass().getInterfaces(),m);

    }

    private static void demo1() {
        UserImp ui = new UserImp();
        ui.add();
        ui.delete();
        MyInvocationHanderler m = new MyInvocationHanderler(ui);
        User u = (User)Proxy.newProxyInstance(ui.getClass().getClassLoader(), ui.getClass().getInterfaces(),m);
        u.add();
        u.delete();
    }

}
