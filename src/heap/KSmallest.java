package heap;

import java.util.Arrays;

public class KSmallest {
    public int[] kSmallest(int[] array, int k) {
        if (array == null || array.length == 0 || k <= 0) {
            return new int[0];
        }
        helper(array, k - 1, 0, array.length);
        int[] res = Arrays.copyOf(array, k);
        Arrays.sort(res);
        return array;
    }

    private void helper(int[] array, int k, int left, int right) {
        int pivot = partition(array, left, right);
        if (pivot == k) {
            return;
        }
        if (pivot < k) {
            helper(array, k, pivot + 1, right);
        } else {
            helper(array, k, left, pivot - 1);
        }
        return;
    }

    private int partition(int[] array, int left, int right) {
        int i = left, j = right - 1;
        while (i <= j) {
            if (array[i] < array[right]) {
                i++;
            } else {
                swap(array, i, j);
                j--;
            }
        }
        swap(array, i, right);
        return i;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
