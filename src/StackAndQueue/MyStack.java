package StackAndQueue;

import java.util.*;

public class MyStack {
    private Deque<Integer> stack1;
    private Deque<Integer> stack2;

    public MyStack() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    public void offer(int val) {
        stack1.offerLast(val);
    }

    public Integer poll() {
        if(!stack2.isEmpty()) {
            return stack2.pollLast();
        }
        move();
        return stack2.pollLast();
    }

    public Integer peek() {
        Integer val = poll();
        if(val != null) {
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

    private void move() {
        while(!stack1.isEmpty()) {
            stack2.offerLast(stack1.pollLast());
        }
    }

}
