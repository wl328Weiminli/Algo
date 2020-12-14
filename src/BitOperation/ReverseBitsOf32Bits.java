package BitOperation;

public class ReverseBitsOf32Bits {
    public long reverseBits(long num) {
        int i = 0, j = 31;
        while (i < j) {
            num = swap(num, i, j);
            i++;
            j--;
        }
        return num;

    }

    private long swap(long num, int i, int j) {
        if (((num >>> i) & 1) != ((num >>> j) & 1)) {
            num ^= (1L << i);
            num ^= (1L << j) ;
        }
        return num;
    }




}
