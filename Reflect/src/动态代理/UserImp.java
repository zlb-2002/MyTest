package 动态代理;

import 动态代理.User;

public class UserImp implements User {

    @Override
    public void add() {
        System.out.println("添加功能");
    }

    @Override
    public void delete() {
        System.out.println("删除功能");
    }
}
