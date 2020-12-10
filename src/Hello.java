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
        Hello test = new Hello();
        test.scopeTest();
    }
}
