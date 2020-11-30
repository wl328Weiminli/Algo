package Dfs;

import java.util.ArrayList;
import java.util.List;

public class DFSI {
    public List<List<Integer>> combinations(int target, int[] coins) {
        List<List<Integer>> res = new ArrayList<>();
        if (target < 0 || coins == null || coins.length == 0) {
            return res;
        }
        List<Integer> aSol = new ArrayList<>();
        dfs(res, target, coins, aSol, 0);
        return res;
    }


    private void dfs(List<List<Integer>> res, int moneyLeft, int[] coins, List<Integer> aSol, int index) {
        if (index == coins.length - 1) {
            if (moneyLeft % coins[index] == 0) {
                aSol.add(moneyLeft / coins[index]);
                res.add(new ArrayList<>(aSol));
                aSol.remove(aSol.size() - 1);
            }
            return;
        }

        for (int i = 0; i <= moneyLeft / coins[index]; i++) {
            aSol.add(i);
            dfs(res, moneyLeft - i * coins[index], coins, aSol, index + 1);
            aSol.remove(aSol.size() - 1);
        }
    }

    public List<String> permutations(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        char[] sArr = s.toCharArray();
        helper(sArr, res, 0);
        return res;
    }

    private void helper(char[] sArr, List<String> res, int index) {
        if (index == sArr.length) {
            res.add(new String(sArr));
            return;
        }
        for (int i = index; i < sArr.length; i++) {
            swap(sArr, index, i);
            helper(sArr, res, index + 1);
            swap(sArr, index, i);
        }

    }

    private void swap(char[] sArr, int i, int j) {
        char temp = sArr[i];
        sArr[i] = sArr[j];
        sArr[j] = temp;
    }


}
