package 枚举类;

public enum Week2 {

    MON("星期一"),TUE("星期二"),WED("星期三");

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
