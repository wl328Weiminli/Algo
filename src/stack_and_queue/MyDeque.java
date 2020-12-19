package stack_and_queue;

import java.util.*;

public class MyDeque {
    Deque<Integer> stack1;
    Deque<Integer> stack2;
    Deque<Integer> stack3;

    public MyDeque() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
        stack3 = new ArrayDeque<>();
    }

    public void offerFirst(int value) {
        stack1.offerLast(value);
    }

    public void offerLast(int value) {
        stack2.offerLast(value);
    }

    public Integer pollFirst() {
        if (!stack1.isEmpty()) {
            return stack1.pollLast();
        }
        move(stack2, stack1);
        return stack1.pollLast();
    }

    public Integer pollLast() {
        if (!stack2.isEmpty()) {
            return stack2.pollLast();
        }
        move(stack1, stack2);
        return stack2.pollLast();
    }

    public Integer peekFirst() {
        Integer val = pollFirst();
        if (val != null) {
            stack1.offerLast(val);
        }
        return val;
    }

    public Integer peekLast() {
        Integer val = pollLast();
        if (val != null) {
            stack2.offerLast(val);
        }
        return val;
    }

    public int size() {
        return stack1.size() + stack2.size();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    private void move(Deque<Integer> deque1, Deque<Integer> deque2) {
        int size = deque1.size();
        if (size == 0) {
            return;
        }
        for (int i = size / 2; i > 0; i--) {
            stack3.offerLast(deque1.pollLast());
        }
        while (!deque1.isEmpty()) {
            deque2.offerLast(deque1.pollLast());
        }
        while (!stack3.isEmpty()) {
            deque1.offerLast(stack3.pollLast());
        }
    }

}

