package StringII;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeating {
    public int longest(String input) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();
        while (j < input.length()) {
            if (!set.contains(input.charAt(j))) {
                set.add(input.charAt(j));
                j++;
                if (j - i > max) {
                    max = j - i;
                }
            }else {
                set.remove(input.charAt(i));
                i++;
            }
        }
        return max;
    }

    public int longestII(String input, int k) {
        int i = 0, j = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (j < input.length()) {
            Integer fre = map.get(input.charAt(j));
            if (fre == null || fre < k) {
                if (fre == null) {
                    map.put(input.charAt(j), 1);
                }else {
                    map.put(input.charAt(j), fre + 1);
                }
                j++;
                max = Math.max(max, j - i);
            }else {
                Integer freAtI = map.get(input.charAt(i));
                if (freAtI == 1) {
                    map.remove(input.charAt(i));
                }else {
                    map.put(input.charAt(i), freAtI - 1);
                }
                i++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeating test = new LongestSubstringWithoutRepeating();
        int res = test.longestII("abaacadefghtbb", 2);
        System.out.println(res);

    }

}
