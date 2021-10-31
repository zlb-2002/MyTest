package Demo_cahrIO;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        String typed = sc.nextLine();

        int i = 0;
        int j = 0;
        while(i < name.length() && j < typed.length()) {
            if(name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        i--;
        j--;
        if(i != name.length() - 1) {
            System.out.println(false);
        } else if(name.charAt(i) == typed.charAt(j)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
