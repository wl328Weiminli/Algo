package StringII;
import java.util.*;
public class Anagram {
    public List<Integer> allAnagrams(String target, String input) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> pattern = getPattern(target);
        int match = pattern.size();
        for (int i = 0; i < input.length(); i++) {
            if (i - target.length() >= 0) {
                char removedChar = input.charAt(i - target.length());
                Integer removedFreq = pattern.get(removedChar);
                if (removedFreq != null) {
                    if (removedFreq == 0) match++;
                    pattern.put(removedChar, removedFreq + 1);
                }
            }
            Integer freq = pattern.get(input.charAt(i));
            if (freq != null) {
                if (freq == 1) {
                    match--;
                }
                pattern.put(input.charAt(i), freq - 1);
                if (match == 0) {
                    res.add(i - target.length() + 1);
                }
            }
        }
        return res;
    }

    private Map<Character, Integer> getPattern(String target) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length(); i++) {
            Integer count = map.get(target.charAt(i));
            if (count == null) {
                map.put(target.charAt(i), 1);
            }else {
                map.put(target.charAt(i), count + 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        Anagram test = new Anagram();
        List<Integer> res = test.allAnagrams("aab", "ababacbbaac");
        System.out.println(Arrays.toString(res.toArray()));
    }

}
