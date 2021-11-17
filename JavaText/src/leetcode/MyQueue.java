package leetcode;

import java.util.Stack;

    /*��ջʵ�ֶ���
    ��ջʵ�ֶ��о���Ҫ�Ƚ�stack1�е�Ԫ��ȫ����ջ����stack2����ջ���ٽ���Ҫ
    ��ջ��Ԫ����stack1��Ȼ���ٽ�stack2�е�Ԫ����������stack1�����ʵ����
    ������ջʵ�ֶ��С�
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
