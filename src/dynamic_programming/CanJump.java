package dynamic_programming;

public class CanJump {
    public boolean canJump(int[] array) {
        boolean[] dp = new boolean[array.length];
        dp[array.length - 1] = true;
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] + i >= array.length - 1) {
                dp[i] = true;
                break;
            }else {
                for (int j = array[i]; j >= 1; j--) {
                    if (dp[j + i]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[0];
    }

    public int minJump(int[] array) {
        int[] dp = new int[array.length];
        dp[0] = 0;
        for (int i = 1; i < array.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (dp[j] != -1 && j + array[j] >= i) {
                    min = Math.min(min, dp[j] + 1);
                }
            }
            dp[i] = (min == Integer.MAX_VALUE) ? -1 : min;
        }
        return dp[array.length -1];
    }


}
