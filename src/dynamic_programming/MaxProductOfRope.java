package dynamic_programming;

public class MaxProductOfRope {
    public int maxProduct(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int max = 1;
            for (int j = 1; j < n; j++) {
                int temp = Math.max(dp[j], j) * (i - j);
                max = Math.max(temp, max);
            }
            dp[i] = max;
        }
        return dp[n];
    }

}
