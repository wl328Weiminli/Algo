package stack_and_queue;

public class MyCircularQueue {
    int head;
    int tail;
    int[] array;
    public MyCircularQueue(int capacity) throws Exception {
        if (capacity <= 2) {
            throw new Exception("The capacity need to great than one");
        }
        array = new int[capacity + 1];
        head = 0;
        tail = 1;
    }

    public boolean isFull() {
        return head == tail;
    }

    public boolean isEmpty() {
        return (head + 1) % array.length == tail;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return array[(head + 1) % array.length];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return tail - 1 < 0 ? array[array.length - 1] : array[tail - 1];
    }

    public boolean enQueue(int val) {
        if (isFull()) return false;
        array[tail] = val;
        tail = (tail + 1) % array.length;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        head = (head + 1) % array.length;
        return true;
    }


    public static void main(String[] args) throws Exception {
        MyCircularQueue test = new MyCircularQueue(3);
        System.out.println(test.enQueue(1));
        System.out.println(test.enQueue(2));
        System.out.println(test.enQueue(3));
        System.out.println(test.enQueue(4));
        System.out.println(test.Rear());
        System.out.println(test.isFull());
        System.out.println(test.deQueue());
        System.out.println(test.enQueue(4));
        System.out.println(test.Rear());

    }



}


