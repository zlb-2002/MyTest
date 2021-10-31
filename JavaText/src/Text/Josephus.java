package Text;

import java.util.Scanner;

public class Josephus {
    private static int n;
    private static int m;
    private static ListNode head;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        MyLinkedList my = new MyLinkedList(n, m);
        head = my.init();
        head = my.create(head);
        cycle(my);

    }

    public static void cycle (MyLinkedList myLinkedList) {
        int i = 0;
        int temp = 0;
        int x = 0;
        ListNode p = head;
        while (temp < n) {
            while (m > 1) {
                p = p.next;
                m--;
            }
            m = p.val;
            x = p.id;
            head = myLinkedList.delete(head, x);
            System.out.print(x + " ");
            temp++;
        }

    }


}
