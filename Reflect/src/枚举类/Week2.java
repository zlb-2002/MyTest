package ö����;

public enum Week2 {

    MON("����һ"),TUE("���ڶ�"),WED("������");

    String name;

    private Week2 (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return name;
    }
}
