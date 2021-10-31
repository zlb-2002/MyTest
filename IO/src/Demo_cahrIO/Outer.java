package Demo_cahrIO;

public class Outer {
    private String name = "小明";

    public class Inner {
        private String name = "小红";

        public void method() {
            System.out.println(this.name);
            System.out.println(Outer.this.name);

        }


    }

    public static void main(String[] args) {
        Outer.Inner oi = new Outer().new Inner();
        oi.method();
    }
}

