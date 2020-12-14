package BitOperation;

public class NUmberOfDifferentBits {
    public int diffBits(int a, int b) {
        int dif = a ^ b;
        int count = 0;
        while (dif != 0) {
            count += dif & 1;
            dif >>>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        NUmberOfDifferentBits test = new NUmberOfDifferentBits();
        int res = test.diffBits(-1, Integer.MAX_VALUE);
        System.out.println(res);

    }
}
