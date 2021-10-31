package 动态代理;

import 动态代理.Student;

public class StudentImp implements Student {

    @Override
    public void login() {
        System.out.println("登录");
    }

    @Override
    public void submit() {
        System.out.println("提交");
    }
}
