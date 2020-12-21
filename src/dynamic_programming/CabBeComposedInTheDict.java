package dynamic_programming;

import java.util.HashSet;
import java.util.Set;

public class CabBeComposedInTheDict {
    public boolean canBreak(String word, String[] dict) {
        Set<String> dictSet = getDict(dict);
        boolean dp[] = new boolean[word.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= word.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dictSet.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }

    public Set getDict(String[] dict) {
        Set<String> dictSet = new HashSet<>();
        for (String i : dict) {
            dictSet.add(i);
        }
        return dictSet;
    }

}
