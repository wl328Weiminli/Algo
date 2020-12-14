public class Hello {

    public void scopeTest() {
        int a = 10;
        sc(a);
        System.out.println(a);

    }

    public void sc(int a) {
        a = 20;
    }

    public static void main(String[] args) {
        System.out.println("Hello M1");
        int a = Integer.MIN_VALUE ;
        System.out.println(Integer.toBinaryString(a));
        int b = -1;
        System.out.println(Integer.toBinaryString(b));

//        int c = Math.abs(a);
//        System.out.println(c);
    }
}
