package leetcode;

import java.util.LinkedList;
import java.util.Queue;


/*用队列实现栈
使用队列实现栈，首先要定义两个队列，先将这个需要入队列的元素入队列queue2，
然后将queue1中的全部元素都入队列queue2，然后将两个队列进行反转，从而由队列实现栈。
 */
class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }
    public int pop() {
        return queue1.poll();
    }
    public int top() {
        return queue1.peek();
    }
    public boolean empty() {
        return queue1.isEmpty();
    }
}
