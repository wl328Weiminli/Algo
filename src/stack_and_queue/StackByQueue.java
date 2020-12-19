package stack_and_queue;

import java.util.*;

public class StackByQueue {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public StackByQueue() {
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    public int size() {
        return queue1.size();
    }

    public void push(int val) {
        queue1.offer(val);
    }

    public Integer pop() {
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
        Integer val = queue1.poll();
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return val;
    }

    public Integer top() {
        Integer val = pop();
        if (val != null) queue1.offer(val);
        return val;
    }

}
