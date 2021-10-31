import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

public class Test4 {

    public static void main(String[] args) {

    }

    public static void Max(String[] str,int k) {
        TreeMap<String,Integer> tm = new TreeMap<>();

        for (String string: str) {
            if (tm.containsKey(string)) {
                tm.put(string, tm.get(string) + 1);
            } else {
                tm.put(string,1);

            }
        }
        ArrayList<String> list = new ArrayList<>();

    }


}
