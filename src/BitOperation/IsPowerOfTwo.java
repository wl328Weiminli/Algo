package BitOperation;

public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int number) {
        return (number > 0) && (((number - 1) & number) == 0);
    }

    public static void main(String[] args) {
        IsPowerOfTwo test = new IsPowerOfTwo();
        System.out.println(test.isPowerOfTwo(4));
    }

}
