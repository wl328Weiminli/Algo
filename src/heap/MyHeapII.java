package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class MyHeapII<E> {
    private E[] array;
    private int size;
    private Comparator c;

    public MyHeapII(int cap, Comparator c) {
        if (cap <= 0) {
            throw new IllegalArgumentException("the capacity should greater than 0");
        }
        this.c = c;
        array = (E[]) new Object[cap];
        size = 0;
    }

    public MyHeapII(E[] array, Comparator c) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("the input array length should greater than 0");
        }
        this.array = array;
        this.c = c;
        size = array.length;
        heapify();
    }



    private int compare(E one, E two) {
        return c.compare(one, two);
    }

    private void heapify() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            percolateDown(i);
        }
    }

    private void percolateDown(int index) {
        while (index <= size / 2 - 1) {
            int leftChild = index * 2 + 1;
            int rightChild = index * 2 + 2;
            int candidate = leftChild;
            if (rightChild < size && compare(array[leftChild], array[rightChild]) > 0 ) {
                candidate = rightChild;
            }
            if (compare(array[index], array[candidate]) > 0) {
                swap(index, candidate);
                index = candidate;
            }else {
                break;
            }
        }

    }

    private void percolateUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (compare(array[parentIndex], array[index]) <= 0) {
                break;
            }else {
                swap(index, parentIndex);
                index = parentIndex;
            }
        }
    }

    private void swap(int i, int j) {
        E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void offer(E value) {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size] = value;
        size++;
        percolateUp(size - 1);
    }

    public E peek() {
        return array[0];
    }

    public E poll() {
        if (size == 0) {
            throw new NoSuchElementException("heap is Empty");
        }
        E res = array[0];
        array[0] = array[size - 1];
        size--;
        percolateDown(0);
        return res;
    }

    public E update(int index, E value) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("index shouldn't out of bound");
        }
        E pre = array[index];
        array[index] = value;
        if (compare(pre, value) > 0) {
            percolateDown(index);
        }else {
            percolateUp(index);
        }
        return pre;
    }



}