package Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class Test1 {

    /*
    ArrayList<Integer>��һ��������������������һ���ַ������ݣ���α�ʵ�֣�
    ����ֻ�ڱ�������Ч���������ڻᱻ������
     */
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list  = new ArrayList<>();
        list.add(111);
        list.add(222);

        Class clazz = Class.forName("java.util.ArrayList");     //��ȡ�ֽ������
        Method m = clazz.getMethod("add",Object.class);
        m.invoke(list,"abc");

        System.out.println(list);
    }

}
