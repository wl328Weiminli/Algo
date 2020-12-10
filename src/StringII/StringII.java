package StringII;

public class StringII {
    public String reverse(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        int i = 0, j = array.length - 1;
        while (i < j) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
        return new String(array);
    }


    public String reverseWords(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        int start = 0;
        for (int i = 0; i < array.length; i++) {
            // 利用逻辑短路
            if (i == 0 || array[i - 1] == ' ') {
                start = i;
            }
            if (i == array.length - 1 || array[i + 1] == ' ') {
                reverse(array, start , i);
            }
        }
        reverse(array, 0, array.length - 1);
        return new String(array);

    }


    private void reverse(char[] array, int start, int end) {
        while (start < end) {
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    public String rightShift(String input, int n) {
        if (input == null || input.length() <= 1 || n < 0) {
            return input;
        }
        char[] array = input.toCharArray();
        int actualShift = n % array.length;
        int splitIndex = array.length - actualShift - 1;
        reverse(array, 0, splitIndex);
        reverse(array, splitIndex + 1, array.length - 1);
        reverse(array, 0, array.length - 1);
        return new String(array);
    }





}
