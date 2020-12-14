package StringII;

import java.util.Arrays;

public class ReOrder {
    public int[] reorder(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        if (array.length % 2 == 0) {
            helper(array, 0, array.length - 1);
        }else {
            helper(array, 0, array.length - 2);
        }
        return array;
    }


    private void helper(int[] array, int left, int right) {
        if (right - left <= 1) {
            return;
        }

        int size = right - left + 1;
        int mid = left + size / 2;
        int lr = left + size / 4;
        int rl = mid + size / 4;

        reverse(array, lr, mid - 1);
        reverse(array, mid, rl - 1);
        reverse(array, lr, rl - 1);

        helper(array, left, left + (lr - left) * 2 - 1);
        helper(array, left + (lr - left) * 2, right);

    }


    private void reverse(int[] array, int i, int j) {
        while (i < j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        ReOrder test = new ReOrder();
        int[] input = {1, 2, 3, 4, 5, 6};
        int[] res = test.reorder(input);
        System.out.println(Arrays.toString(res));
    }

}
