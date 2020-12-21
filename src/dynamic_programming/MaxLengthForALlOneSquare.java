package dynamic_programming;

public class MaxLengthForALlOneSquare {
    public int largest(int[][] input) {
        int row = input.length, col = input[0].length;
        int[][] M = new int[row][col];
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0) {
                    M[i][j] = input[i][j];
                }else if (j == 0) {
                    M[i][j] = input[i][j];
                }else {
                    if (input[i][j] == 0) {
                        M[i][j] = 0;
                    }else {
                        M[i][j] = Math.min(Math.min(M[i - 1][j], M[i][j - 1]), M[i - 1][j - 1]) + 1;

                    }
                }
                max = Math.max(M[i][j], max);
            }
        }
        return max;
    }

}
