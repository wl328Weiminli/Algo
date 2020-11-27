import java.util.ArrayList;
import java.util.List;

public class PerformanceTest {
    public List<String>valid(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(res, sb, n,0, 0);
        return res;
    }

    private void helper(List<String> res, StringBuilder sb, int n, int l, int r) {
        if (l + r == 2 * n) {
            res.add(sb.toString());
            return;
        }
        if (l < n) {
            sb.append('(');
            helper(res, sb, n, l + 1, r);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (r < l) {
            sb.append(')');
            helper(res, sb, n, l, r + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public long fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        PerformanceTest test = new PerformanceTest();
//        System.out.println(test.valid(5));
        System.out.println(test.fib(20));
    }
}
