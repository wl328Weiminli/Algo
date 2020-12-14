package BitOperation;

public class IntegerToHex {
    public String hex(int number) {
        if (number == 0) {
            return "0x" + number;
        }
        StringBuilder sb = new StringBuilder();
        while (number != 0) {
            int num = number & 0b1111;
            if (num < 10) {
                sb.append((char)('0' + num));
            }else {
                sb.append((char)((num - 10) + 'A'));
            }
            number >>>= 4;
        }
        sb.append("x0");
        return sb.reverse().toString();
    }
}
