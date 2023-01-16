import jdk.jfr.events.ExceptionThrownEvent;

import java. io. * ;
import java. util. * ;
public class ObjectSaver {
    public static void main(String[] args) throws Exception {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("objectFile.obj"));
        String obj1 = "hello";
        Date obj2 = new Date();
        Student obj3 = new Student("张三", 20);
        out.writeObject(obj1);
        out.writeObject(obj2);
        out.writeObject(obj3);
        out.close();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("objectFile.obj"));
        String obj11 = (String) in.readObject();
        System.out.println("obj11: " + obj11);
        System.out.println("obj11 == obj1: " + (obj11 == obj1));
        System.out.println("obj11.equals(obj1): " + obj11.equals(obj1));
        Date obj22 = (Date) in.readObject();
        System.out.println("obj22: " + obj22);
        System.out.println("obj22 == obj2: " + (obj22 == obj2));
        System.out.println("obj22.equals(obj2): " + obj22.equals(obj2));
        Student obj33 = (Student) in.readObject();
        System.out.println("obj33: " + obj33);
        System.out.println("obj33 == obj3: " + (obj33 == obj3));
        System.out.println("obj33.equals(obj3): " + obj33.equals(obj3));
        in.close();
    }
}

class Student implements Serializable{
    private String name;
    private int age;
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("带两个参数的构造方法");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}