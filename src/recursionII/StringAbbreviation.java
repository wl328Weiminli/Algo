package recursionII;

public class StringAbbreviation {
    public boolean match(String input, String pattern) {
        return helper(input, pattern, 0, 0);
    }

    private boolean helper(String input, String pattern, int i, int j) {
        if (i == input.length() && j == pattern.length()) {
            return true;
        }
        if (i >= input.length() || j >= pattern.length()) {
            return false;
        }
        if (pattern.charAt(j) >= '0' && pattern.charAt(j) <= '9') {
            int count = 0;
            while (j < pattern.length() && (pattern.charAt(j) >= '0' &&  pattern.charAt(j) <= '9')) {
                count = count * 10 + (pattern.charAt(j) - '0');
                j++;
            }
            return helper(input, pattern, i + count, j);
        }else if (input.charAt(i) != pattern.charAt(j)) {
            return false;
        }else {
            return helper(input, pattern, ++i, ++j);
        }
    }

    public static void main(String[] args) {
        StringAbbreviation test = new StringAbbreviation();
        System.out.println(test.match("book", "b3"));
    }

}
