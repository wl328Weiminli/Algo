package dynamic_programming;

public class MaxSubArraySum {
    public int largestSum(int[] array) {
        // assume array is not null and length is at least one
        int pre = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (pre < 0) {
                pre = array[i];
            }else {
                pre = pre + array[i];
            }
            max = Math.max(pre, max);
        }
        return max;
    }

    public int[] largestSumGetPath(int[] array) {
        int pre = array[0];
        int curStart = 0;
        int globalStart = 0;
        int globalEnd = 0;
        int globalMax = array[0];
        for (int i = 1; i < array.length; i++) {
            if (pre < 0) {
                curStart = i;
                pre = array[i];
            }else {
                pre = pre + array[i];
            }
            if (pre > globalMax) {
                globalStart = curStart;
                globalEnd = i;
                globalMax = pre;
            }
        }
        return new int[] {globalMax, curStart, globalEnd};
    }


}
