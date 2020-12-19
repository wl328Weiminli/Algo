package stringII;

public class Decompress {
    public String decompress(String input) {
        char[] array = input.toCharArray();
        int i = 0, j = 0, expand = 0;
        // handle the case will shorter the pattern
        while (j < array.length) {
            int count = getDigit(array[j + 1]);
            if (count >= 0 && count <= 2) {
                for (int c = 0; c < count; c++) {
                    array[i++] = array[j];
                }
            }else {
                expand += count - 2;
                array[i++] = array[j];
                array[i++] = (char)(count + '0');
            }
            j += 2;
        }
// handle the case will expand the array;
        char[] res = new char[i + expand];
        int resIndex = res.length - 1, explore = i - 1;
        while (explore >= 0) {
            if (Character.isDigit(array[explore])) {
                int count = getDigit(array[explore]);
                explore--;
                for (int c = 0; c < count; c++) {
                    res[resIndex--] = array[explore];
                }
                explore--;
            }else {
                res[resIndex--] = array[explore--];
            }
        }
        return new String(res);
    }

    private int getDigit(char s) {
        return s - '0';
    }

    public static void main(String[] args) {
        Decompress test = new Decompress();
        System.out.println(test.decompress("x2y0i0z3"));
    }


}
