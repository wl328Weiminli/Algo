package StackAndQueue;

public class MyCircularDeque {
    private int head;
    private int tail;
    private int[] array;
    public MyCircularDeque(int capacity) {
        head = 0;
        tail = 1;
        array = new int[capacity + 1];
    }

    public boolean isFull() {
        return head == tail;
    }

    public boolean isEmpty() {
       return (head + 1) % array.length == tail;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return array[(head + 1) % array.length];
    }

    public int getRear() {
        if (isEmpty()) return -1;
//        if (tail - 1 < 0) return array[array.length - 1];
//        return array[tail - 1];
        return tail - 1 < 0 ? array[array.length - 1] : array[tail - 1];
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        array[head] = value;
        head = head - 1 < 0 ?  array.length - 1 : head - 1;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        array[tail] = value;
        tail = (tail + 1) % array.length;
        return true;
    }
    public boolean deleteFront() {
        if (isEmpty()) return false;
        head = (head + 1) % array.length;
        return true;
    }
    public boolean deleteLast() {
        if (isEmpty()) return false;
        tail = tail - 1 < 0 ? array.length - 1 : tail - 1;
        return true;
    }

    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(3);
        System.out.println(circularDeque.insertLast(1));
        System.out.println(circularDeque.insertLast(2));
        System.out.println(circularDeque.insertFront(3));
        System.out.println(circularDeque.insertFront(4));
        System.out.println(circularDeque.getRear());
        System.out.println(circularDeque.isFull());
        System.out.println(circularDeque.deleteLast());
        System.out.println(circularDeque.insertFront(4));
        System.out.println(circularDeque.getFront());
    }

}
