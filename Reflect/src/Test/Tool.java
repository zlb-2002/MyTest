package Test;

import java.lang.reflect.Field;

public class Tool {
    //�˷����ɽ�obj�����е�propertyName�����Ե�ֵ����Ϊvalue
    public void setProperty (Object obj,String propertyName,Object value) throws Exception, IllegalAccessException {
        Class clazz = obj.getClass();       //��ȡ�ֽ������
        Field f = clazz.getDeclaredField("propertyName");       //��������
        f.setAccessible(true);              //ȥ��Ȩ��
        f.set(obj,value);
    }


}
