package Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class Test1 {

    /*
    ArrayList<Integer>的一个对象，在这个集合中添加一个字符串数据，如何被实现？
    泛型只在编译器有效，在运行期会被擦除掉
     */
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list  = new ArrayList<>();
        list.add(111);
        list.add(222);

        Class clazz = Class.forName("java.util.ArrayList");     //获取字节码对象
        Method m = clazz.getMethod("add",Object.class);
        m.invoke(list,"abc");

        System.out.println(list);
    }

}
