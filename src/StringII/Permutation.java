package StringII;

import java.util.*;

public class Permutation {
    public List<String> permutations(String s) {
        List<String> res = new ArrayList<>();
        if (s == null) {
            return res;
        }
        char[] sArr = s.toCharArray();
        dfs(sArr, res, 0);
        return res;
    }

    private void dfs(char[] array, List<String> res, int index) {
        if (index == array.length) {
            res.add(new String(array));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = index; i < array.length; i++) {
            if (!set.contains(array[i])) {
                set.add(array[i]);
                swap(array, i, index);
                dfs(array, res, index + 1);
                swap(array, i, index);
            }else {
                continue;
            }
        }
    }

    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
