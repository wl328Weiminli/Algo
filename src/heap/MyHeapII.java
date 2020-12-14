package heap;

import java.util.Arrays;

public class MyHeapII {
    private int[] array;
    private int size;

    public MyHeapII(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("the array can not null or empty!");
        }
        this.array = array;
        size = array.length;
        heapify();
    }

    public MyHeapII(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("the array length should greater or equal to 1!");
        }
        array = new int[capacity];
        size = 0;
    }


    private void heapify() {
        int index = size / 2 - 1;
        while (index >= 0) {
            percolateDown(index);
            index--;
        }
    }

    private void percolateDown(int index) {
        while (index <= size / 2 - 1) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int candidateIndex = leftChildIndex;
            if (rightChildIndex < size && array[rightChildIndex] < array[leftChildIndex]) {
                candidateIndex = rightChildIndex;
            }
            if (array[index] < array[candidateIndex]) {
                break;
            }
            swap(index, candidateIndex);
            index = candidateIndex;
        }

    }


    public void percolateUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (array[index] < array[parentIndex]) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }

    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void offer(int value) {
        if (size == array.length) {
            array = Arrays.copyOf(array, (int) (array.length * 1.5));
        }
        array[size] = value;
        size++;
        percolateUp(size - 1);
    }


    public Integer poll() {
        if (size == 0) {
            return null;
        }
        int res = array[0];
        array[0] = array[size - 1];
        size--;
        percolateDown(0);
        return res;
    }


    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return array[0];
    }

    public Integer update(int value, int index) {
        if (index >= size || index < 0) {
            return null;
        }
        int pre = array[index];
        if (value < array[index]) {
            array[index] = value;
            percolateUp(index);
        } else {
            array[index] = value;
            percolateDown(index);
        }
        return pre;
    }

    public int size() {
        return size;
    }


}


