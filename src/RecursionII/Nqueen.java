package RecursionII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nqueen {
    private void dfs(List<List<Integer>> res, List<Integer> aSol, int index, int n) {
        if (index == n) {
            res.add(new ArrayList<Integer>(aSol));
            return;
        }
        for (int i = 0; i < n; i++) {
            aSol.add(i);
            if (isValidPosition(aSol)) {
                dfs(res, aSol, index + 1, n);
            }
            aSol.remove(aSol.size() - 1);
        }

    }

    private boolean isValidPosition(List<Integer> aSol) {
        int currentRow = aSol.size() - 1;
        for (int i = 0; i < currentRow; i++) {
            if (aSol.get(currentRow) == aSol.get(i) || Math.abs(aSol.get(i) - aSol.get(currentRow)) == Math.abs(currentRow - i)) {
                return false;
            }
        }
        return true;
    }

    public List<List<Integer>> nqueens(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        List<Integer> aSol = new ArrayList<>();
        dfs(res, aSol, 0, n);
        return res;
    }

    public static void main(String[] args) {
        Nqueen test = new Nqueen();
        List<List<Integer>> res = test.nqueens(8);
        for (int i = 0; i < res.size(); i++) {
            List<Integer> temp = res.get(i);
            System.out.println(Arrays.toString(temp.toArray()));
        }

    }


}
