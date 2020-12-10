package HashTableAndStringI;

import java.util.HashSet;
import java.util.Set;

public class StringRemove {
    public String remove(String a, String b) {
        Set<Character> set = getSet(b);
        int i = 0;
        char[] aArr = a.toCharArray();
        for (int j = 0; j < aArr.length; j++) {
            if (!set.contains(aArr[j])) {
                aArr[i] = aArr[j];
                i++;
            }
            j++;
        }
        return new String(aArr, 0, i);
    }

    private Set<Character> getSet(String b) {
        char[] bArr = b.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char i : bArr) {
            set.add(i);
        }
        return set;
    }

    public String removeSpaces(String a) {
        char[] array = a.toCharArray();
        int i = 0, j = 0;
        while (j < array.length) {
            if (array[j] != ' ' || (j > 0 && array[j - 1] != ' ')) {
                array[i] = array[j];
                i++;
            }
            j++;
        }
        if (i > 0 && array[i - 1] == ' ') {
            i--;
        }
        return new String(array, 0, i);
    }

    public String deDup(String s) {
        if (s == null || s.length() <= 1) {
            return null;
        }
        char[] array = s.toCharArray();
        int i = 1, j = 1;
        while (j < array.length) {
            if (array[i - 1] == array[j]) {
                while (j < array.length && array[j] == array[i - 1]) {
                    j++;
                }
            }else {
                array[i] = array[j];
                i++;
                j++;
            }
        }
        return new String(array, 0, i);
    }

    public int strstr(String large, String small) {
        if (large == null || small == null || large.length() == 0 || large.length() < small.length()) {
            return -1;
        }
        char[] array = large.toCharArray();
        for (int i = 0; i <= array.length - small.length(); i++) {
            if (match(array, small, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean match(char[] array, String small, int i) {
        for (int j = 0; j < small.length(); j++) {
            if (array[i + j] != small.charAt(j)) {
                return false;
            }
        }
        return true;
    }




}
