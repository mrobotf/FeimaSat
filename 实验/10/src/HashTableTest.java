import java.util.*;
class Student {
    String name;
    int number;
    float score;
    Student(String name, int number, float score) {
        this.name = name;
        this.number = number;
        this.score = score;
    }

    @Override
    public String toString() {
        return "No.: " + number +
                "\nname = " + name +
                "\nscore = " + score +
                "\n";
    }
}
class HashTableTest {
    public static void main(String[] args) {
        Hashtable h = new Hashtable<>();
        Enumeration e;
        Student stu;
        String str;
        h.put("10001", new Student("ma", 10001, 98));
        h.put("10002", new Student("jian", 10002, 88));
        h.put("10003", new Student("li", 10003, 77));
        e = h.keys();
        while (e.hasMoreElements()) {
            str = (String)e.nextElement();
            System.out.println("" + (Student)h.get(str));
        }
        System.out.println();
        float score = ((Student)h.get("10003")).score;
        h.put("10003", new Student("li", 10003, score + 15));
        System.out.println("li修改后的信息：" + (Student)h.get("10003"));
    }
}
