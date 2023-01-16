import java.io.*;
import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        File f = new File("RandomTest.java");
        try {
            RandomAccessFile random = new RandomAccessFile(f, "r");
            long l = random.length();  // 取文件长度
            char ch;
            for(long i = l - 1; i >= 0; i--) {
                random.seek(i);   // 指针定位到 i 处
                ch = (char)random.read();
                System.out.print(ch);
            }
            random.close();
        } catch (Exception e) {
            System.out.println("IOError!");
        }
    }
}
