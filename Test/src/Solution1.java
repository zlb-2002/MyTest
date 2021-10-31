public class Solution1 {

    public static void main(String[] args) {
        Solution s = new Solution();
        int a = s.myAtoi("words and 987");
        System.out.println(a);
    }

}

class Solution {
    public int myAtoi(String s) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb1.append(s);
        for (int i = 0;i < sb1.length();i++) {
            if (i == 0) {
                if (!(sb1.charAt(i) >= '0' && sb1.charAt(i) <= '9') || sb1.charAt(i) == ' ') {
                    break;
                } else if (sb1.charAt(i) == ' ') {
                    sb1.deleteCharAt(i);
                }
            }
            if (sb1.charAt(i) == '-' || (sb1.charAt(i) >= '0' && sb1.charAt(i) <= '9')) {
                sb2.append(sb1.charAt(i));
                continue;
            }
            if (!(sb1.charAt(i) >= '0' && sb1.charAt(i) <= '9') && sb2.length() > 0) {
                break;
            }

        }

        int a = 0;
        if (sb2.length() > 0) {
            a = Integer.parseInt(sb2.toString());
        }
        return a;
    }
}
