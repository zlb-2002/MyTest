package Test;

import java.lang.reflect.Field;

public class Tool {
    //此方法可将obj对象中的propertyName的属性的值设置为value
    public void setProperty (Object obj,String propertyName,Object value) throws Exception, IllegalAccessException {
        Class clazz = obj.getClass();       //获取字节码对象
        Field f = clazz.getDeclaredField("propertyName");       //暴力反射
        f.setAccessible(true);              //去除权限
        f.set(obj,value);
    }


}
