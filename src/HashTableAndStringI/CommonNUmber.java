package HashTableAndStringI;

import java.util.ArrayList;
import java.util.List;

public class CommonNUmber {
    public List<Integer> common(int[] a, int[] b) {
        if (a == null || b == null) {
            return new ArrayList<Integer>();
        }
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                i++;
            }else if (a[i] > b[j]) {
                j++;
            }else {
                res.add(a[i]);
                i++;
                j++;
            }
        }
        return res;
    }

}
