package StackAndQueue;

import java.util.*;

public class MyStackWithMin {
    private static class MinEle {
        int value;
        int sizeOfStack1;

        private MinEle(int value, int size) {
            this.value = value;
            sizeOfStack1 = size;
        }
    }

    Deque<Integer> stack1;
    Deque<MinEle> stack2;

    public MyStackWithMin() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    public void push(int ele) {
        stack1.offerLast(ele);
        if (stack2.isEmpty() || ele < stack2.peekLast().value) {
            stack2.offerLast(new MinEle(ele, stack1.size()));
        }
    }

    public int pop() {
        if (stack1.isEmpty()) {
            return -1;
        }
        int ele = stack1.pollLast();
        if (ele == stack2.peekLast().value && stack1.size() + 1 == stack2.peekLast().sizeOfStack1) {
            stack2.pollLast();
        }
        return ele;
    }

    public int top() {
        if (stack1.isEmpty()) {
            return -1;
        }
        return stack1.peekLast();
    }

    public int min() {
        if (stack2.isEmpty()) {
            return -1;
        }
        return stack2.peekLast().value;
    }

    public static void main(String[] args) {
        MyStackWithMin test = new MyStackWithMin();
        test.push(6);
        test.min();
        test.push(5);
        test.push(9);
        test.top();
        test.min();
        test.pop();
        test.min();
        test.min();
        test.pop();
        test.min();
    }



}

