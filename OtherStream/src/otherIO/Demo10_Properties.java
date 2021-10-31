package otherIO;

import java.util.Enumeration;
import java.util.Properties;

public class Demo10_Properties {

    public static void main(String[] args) {
        //demo1();
        Properties prop = new Properties();
        prop.setProperty("name","ÕÅÈý");
        prop.setProperty("tel","12345678910");

        Enumeration<String> en = (Enumeration<String>) prop.propertyNames();
        while (en.hasMoreElements()) {
            String key = en.nextElement();
            String value = prop.getProperty(key);
            System.out.println(key + "=" + value);
        }

    }

    private static void demo1() {
        Properties prop = new Properties();
        prop.put("abc",123);
        System.out.println(prop);
    }

}
