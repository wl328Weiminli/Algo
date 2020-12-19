package stringII;

public class Compress {
    public String compress(String input) {
        char[] array = input.toCharArray();

        // handle the element repeat more than twice
        int i = 0, j = 0, expandLength = 0;
        while (j < array.length) {
            char currentChar = array[j];
            Integer count = 0;
            while (j < array.length && array[j] == currentChar) {
                j++;
                count++;
            }
            array[i++] = currentChar;
            if (count > 1) {
                String strCount = count.toString();
                for (int d = 0; d < strCount.length(); d++) {
                    array[i++] = strCount.charAt(d);
                }
            }else {
                expandLength++;
            }
        }
        char[] res = new char[i + expandLength];
        int resIndex = res.length - 1, explore = i - 1;
        while (explore >= 0) 	 {
            if (Character.isDigit(array[explore])) {
                while (Character.isDigit(array[explore])) {
                    res[resIndex--] = array[explore--];
                }
            }else {
                res[resIndex--] = '1';

            }
            res[resIndex--] = array[explore--];
        }
        return new String(res);
    }


    public static void main(String[] args) {
        Compress test = new Compress();
        System.out.println(test.compress("hhhhhhhhhhhhhhhhhhhhhxxxxxxxxxxxxxxaaaaaaaaaddddffffooooooooooooll"));
    }


}
