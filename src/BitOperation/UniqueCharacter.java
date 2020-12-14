package BitOperation;

public class UniqueCharacter {
    public boolean allUnique(String word) {
        if (word == null || word.length() <= 1) {
            return true;
        }
        int[] array = new int[8] ;
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            int row = cur / 32, col = cur % 32;
            if (((array[row] >>> col) & 1) != 1) {
                array[row] = array[row] | (1 << col);
            }else {
                return false;
            }
        }
        return true;
    }

}
