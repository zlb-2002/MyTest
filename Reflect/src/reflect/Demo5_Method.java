package reflect;

import bean.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Demo5_Method {

    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("bean.Person");
        Constructor c = clazz.getConstructor(String.class,int.class);
        Person p = (Person) c.newInstance("张三",23);
        Method m = clazz.getMethod("eat");          //获取eat方法
        m.invoke(p);

        Method m2 = clazz.getMethod("eat",int.class);       //获取有参的方法
        m2.invoke(p);
    }
}
