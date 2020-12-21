package dynamic_programming;

public class EditDistance {
    public int editDistance(String source, String target) {
        int[][] M = new int[source.length() + 1][target.length() + 1];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (i == 0) {
                    M[i][j] = j;
                }else if (j == 0) {
                    M[i][j] = i;
                }else {
                    if (source.charAt(i - 1) == target.charAt(j - 1)) {
                        M[i][j] = M[i - 1][j - 1];
                    }else {
                        M[i][j] = Math.min(Math.min(M[i][j -1], M[i - 1][j]), M[i - 1][j - 1]) + 1;
                    }
                }
            }
        }
        return M[source.length()][target.length()];

    }


}
