package Text;

import java.util.Scanner;

class ListNode {
    int val;
    int id;
    ListNode next;
}

class MyLinkedList {

    private int n;
    private int m;

    public MyLinkedList (int n, int m) {
        this.n = n;
        this.m = m;

    }

    public ListNode init () {
        ListNode head = new ListNode();
        head.id = 1;
        head.next = head;
        return head;
    }

    public ListNode create (ListNode head) {
        Scanner sc = new Scanner(System.in);
        ListNode t = head;
        head.val = sc.nextInt();
        for (int i = 2; i <= n; i++) {
            ListNode p = new ListNode();
            p.val = sc.nextInt();
            p.id = i;
            p.next = t.next;
            t.next = p;
            t = p;
        }
//        System.out.println("创建单链表完成！");
        return head;
    }

    public ListNode delete (ListNode head, int x) {
        ListNode t = head;
        while (t.next != head) {
            if (t.id == x) {
                t.id = t.next.id;
                t.val = t.next.val;
                t.next = t.next.next;
            } else {
                t = t.next;
            }
        }
        if (t.id == x) {
            head = head.next;
            t.id = t.next.id;
            t.val = t.next.val;
            t.next = t.next.next;
        }
        return head;
    }

    public int length (ListNode head) {
        int i = 1;
        ListNode p = head;
        while (p.next != head) {
            p = p.next;
            ++i;
        }
        return i;
    }

    public void printLinked (ListNode head) {
        ListNode p = head;
        while (p.next != head) {
            System.out.print(p.val + " ");
            p = p.next;
        }

        System.out.println(p.val);
    }

}
