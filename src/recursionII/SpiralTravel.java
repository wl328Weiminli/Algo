package recursionII;

import java.util.ArrayList;
import java.util.List;

public class SpiralTravel {
    public List<Integer> spiral(int[][] input) {
        List<Integer> res = new ArrayList<>();
        int n = input.length;
        helper(input, res, 0, n);
        return res;
    }

    public void helper(int[][] input, List<Integer> res, int offset, int n) {
        while (n > 1) {
            for (int i = 0; i < n - 1; i++) {
                res.add(input[offset][offset + i]);
            }
            for (int i = 0; i < n - 1; i++) {
                res.add(input[offset + i][offset + n - 1]);
            }
            for (int i = n - 1; i >= 1; i--) {
                res.add(input[offset + n - 1][offset + i]);
            }
            for (int i = n - 1; i >= 1; i--) {
                res.add(input[offset + i][offset]);
            }
            n -= 2;
        }
        if (n <= 1) {
            if (n == 1) {
                res.add(input[offset][offset]);
            }
            return;
        }
    }


    private void helper(int[][] input, List<Integer> res, int offset, int row, int col) {
        if (row <= 1 || col <= 1) {
            if (row == 1) {
                for (int i = 0; i < col; i++) {
                    res.add(input[offset][offset + i]);
                }
            }else if (col == 1) {
                for (int i =0; i < row; i++) {
                    res.add(input[offset + i][offset]);
                }
            }
            return;
        }
        for (int i = 0; i < col - 1; i++) {
            res.add(input[offset][offset + i]);
        }
        for (int i = 0; i < row - 1; i++) {
            res.add(input[offset + i][offset + col - 1]);
        }
        for (int i = col - 1; i >= 1; i--) {
            res.add(input[offset + row - 1][offset + i]);
        }
        for (int i = row - 1; i >= 1; i--) {
            res.add(input[offset + i][offset]);
        }
        helper(input, res, offset + 1, row - 2, col - 2);
    }

    public List<Integer> spiralII(int[][] input) {
        List<Integer> res = new ArrayList<>();
        int row = input.length, col = input[0].length;
        helper(input, res, 0, row, col);
        return res;
    }


}
