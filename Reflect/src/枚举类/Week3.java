package ö����;

public enum Week3 {

    MON("����һ"){
        @Override
        public void show() {
            System.out.println("����һ");
        }
    },TUE("���ڶ�"){
        @Override
        public void show() {
            System.out.println("���ڶ�");
        }
    },WED("������"){
        @Override
        public void show() {
            System.out.println("������");
        }
    };

    String name;

    private Week3(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public abstract void show() ;

}
