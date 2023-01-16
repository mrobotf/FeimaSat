public class ArrayTest {
    public static void main(String[] args) {
        int[] a;
        Person[] b;
        a = new int[10];
        b = new Person[3];
        for(int i = 0; i < 10; i++) {
            a[i] = (int)(100*Math.random());
        }
        b[0] = new Person("zhangsan", 28, 'M');
        // b[1] = new Person("lisi", )
    }
}