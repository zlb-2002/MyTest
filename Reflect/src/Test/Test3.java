package Test;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Method;

public class Test3 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new
                BufferedReader(new
                    FileReader("D:\\Java\\production\\newProjext\\Reflect\\src\\Test\\Test.properties"));
        Class clazz = Class.forName(br.readLine());
        DemoClass d = (DemoClass) clazz.getConstructor().newInstance();

        d.run();
    }


}
