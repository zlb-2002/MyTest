package leetcode;

import java.util.Stack;

    /*用栈实现队列
    用栈实现队列就需要先将stack1中的元素全部出栈，在stack2中入栈，再将需要
    入栈的元素入stack1，然后再将stack2中的元素再重新入stack1，这就实现了
    用两个栈实现队列。
     */
public class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    public void push(int x) {
        while (!stack1.isEmpty()) stack2.push(stack1.pop());
        stack1.push(x);
        while (!stack2.isEmpty()) stack1.push(stack2.pop());
    }
    public int pop() {
        return stack1.pop();
    }
    public int peek() {
        return stack1.peek();
    }
    public boolean empty() {
        return stack1.isEmpty();
    }
}
