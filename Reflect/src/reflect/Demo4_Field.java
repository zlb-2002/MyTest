package reflect;

import bean.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Demo4_Field {

    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("bean.Person");
        Constructor c = clazz.getConstructor(String.class,int.class);
        Person p = (Person) c.newInstance("张三",23);

        /*Field f = clazz.getField("name");      //获取姓名字段
        f.set(p,"李四");*/                        //通过有参构造创建对象

        Field f = clazz.getDeclaredField("name");       //暴力反射获取字段
        f.setAccessible(true);                                //去除私有权限
        f.set(p,"李四");
        System.out.println(p);
    }

}
