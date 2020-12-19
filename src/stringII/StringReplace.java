package stringII;

import java.util.ArrayList;
import java.util.List;

public class StringReplace {
    public String replace(String input, String source, String target) {
        char[] array = input.toCharArray();
        List<Integer> startOfSourcePattern = getStartIndex(array, source);
        if (startOfSourcePattern.size() == 0) {
            return input;
        }
        if (source.length() >= target.length()) {
            int i = 0, j = 0, startIndex = 0;
            while (j < array.length) {
                if (startIndex < startOfSourcePattern.size() && startOfSourcePattern.get(startIndex) == j) {
                    j += source.length();
                    startIndex++;
                    for (int t = 0; t < target.length(); t++) {
                        array[i++] = target.charAt(t);
                    }

                }else {
                    array[i++] = array[j++];
                }
            }
            return new String(array, 0, i);
        }else {
            int expandSize = startOfSourcePattern.size() * (target.length() - source.length());
            char[] newArr = new char[array.length + expandSize];
            int j = array.length - 1, i = newArr.length - 1, startIndex = startOfSourcePattern.size() - 1;
            while (j >= 0) {
                if ( startIndex > - 1 && j == startOfSourcePattern.get(startIndex) + source.length() - 1) {
                    j -= source.length();
                    startIndex--;
                    for (int t = target.length() - 1; t >= 0; t--) {
                        newArr[i--] = target.charAt(t);
                    }
                }else {
                    newArr[i--] = array[j--];

                }
            }
            return new String(newArr, 0, newArr.length);
        }
    }

    private List<Integer> getStartIndex(char[] array, String source) {
        List<Integer> res = new ArrayList<>();
        int i = 0;
        while (i <= array.length - source.length()) {
            if (match(array, source, i)) {
                res.add(i);
                i += source.length();
            }else {
                i++;
            }
        }
        return res;
    }


    private boolean match(char[] array, String source, int start) {
        for (int i = 0; i < source.length(); i++) {
            if (array[start + i] != source.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        StringReplace test = new StringReplace();
        System.out.println(test.replace("appledogapple", "apple", "cat"));
        System.out.println(test.replace("laicode", "code", "offers"));



    }

}
