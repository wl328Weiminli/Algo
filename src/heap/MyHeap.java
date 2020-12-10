package heap;


// offer
// pop
// update(index, value)
// peek

// percolate up
// percolate down
// heapify

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyHeap {
    private int[] array;
    private int size;

    public MyHeap(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("the input array should not null and length should greater than 0");
        }
        this.array = array;
        size = array.length;
        heapify();
    }

    public MyHeap(int cap) {
        if (cap <= 0) {
            throw new IllegalArgumentException("The capacity can't less or equal to 0");
        }
        array = new int[cap];
    }

    private void heapify() {
        int index = (size - 2) / 2;
        for  (int i = size / 2 - 1; i >= 0; i--) {
            percolateDown(index);
        }
    }

    private void percolateDown(int index) {
        while (index <= size / 2 - 1) {
            int leftCandidate = index * 2 + 1, rightCandidate = index * 2 + 2;
            int candidate = leftCandidate;
            if (rightCandidate < size && array[leftCandidate] > array[rightCandidate]) {
                candidate = rightCandidate;
            }
            if (array[index] > array[candidate]) {
                swap(index, candidate);
            }else {
                break;
            }
            index = candidate;
        }
    }

    private void percolateUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (array[parent] < array[index]) {
                break;
            }else {
               swap(index, parent);
            }
            index = parent;
        }
    }

    public void offer(int val) {
        if (size == array.length) {
            array = Arrays.copyOf(array, (int)(array.length * 1.5));
        }
        array[size] = val;
        size++;
        percolateUp(size - 1);
    }

    public int poll() {
        if (size == 0) {
            throw new NoSuchElementException("heap is empty");
        }
        int val = array[0];
        array[0] = array[size - 1];
        size--;
        percolateDown(0);
        return val;
    }

    public int update(int index, int val) {
        if (index >= size || size < 0) {
            throw new NoSuchElementException("no such index in the heap");
        }
        int originVal = array[index];
        array[index] = val;
       if (originVal > val) {
           percolateUp(index);
       } else {
           percolateDown(index);
       }
       return originVal;
    }

    public int peek() {
        if (size == 0) {
            throw new NoSuchElementException("heap is Empty");
        }
        return array[0];
    }

    private void swap(int i, int j) {
       int temp = array[i];
       array[i] = array[j];
       array[j] = temp;
    }
}
