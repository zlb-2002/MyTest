package leetcode;

import java.util.LinkedList;
import java.util.Queue;


/*�ö���ʵ��ջ
ʹ�ö���ʵ��ջ������Ҫ�����������У��Ƚ������Ҫ����е�Ԫ�������queue2��
Ȼ��queue1�е�ȫ��Ԫ�ض������queue2��Ȼ���������н��з�ת���Ӷ��ɶ���ʵ��ջ��
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
