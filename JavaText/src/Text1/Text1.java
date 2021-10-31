package Text1;


import java.util.*;

class Text implements Comparable {



    int age;
    String name;

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Text text = (Text) obj;
        if (text.age != this.age) {
            return false;
        } else if (!text.name.equals(this.name)) {
            return false;
        } else {
            return true;
        }
    }
}

public class Text1 {

    public static void main(String[] args) {
        TreeSet<Text> hashSet = new TreeSet<>(new Comparator<Text>() {
            @Override
            public int compare(Text o1, Text o2) {
                return 0;
            }
        });
    }

    public void sum() {

    }

}

interface Person {

}

interface Teacher {

}

interface Student extends Teacher {

}




