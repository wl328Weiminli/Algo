package dynamic_programming;

public class LongestAscendingSubarray {
    public int longest(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int pre = 1;
        int max = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                pre = pre + 1;
                max = Math.max(pre, max);
            }else {
                pre = 1;
            }
        }
        return max;
    }

}
