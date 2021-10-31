package Text;

public class Text2 {

    public static void main(String[] args) {
        final String a = "abc";
        String b = "abc";
        String c = "abc1";
        System.out.println(a + "1" == c);
        System.out.println(b + "1" == c);
    }

    public static void swap (String a, String b) {
        a = "abc";
    }

    public static int getValue(int i) {
        int result = 0;
        switch (i) {
            case 1:
                result = result + i;
            case 2:
                result = result + i * 2;
            case 3:
                result = result + i * 3;
        }
        return result;
    }

}
