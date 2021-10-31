package 动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHanderler implements InvocationHandler {
    private Object target;

    public MyInvocationHanderler(Object target) {
        this.target = target;


    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("权限校验");
        method.invoke(target,args);
        System.out.println("日志记录");
        return null;
    }
}
