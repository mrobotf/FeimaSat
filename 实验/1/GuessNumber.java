import java.util.*;
public class GuessNumber {
    public static void main(String[] args) {
        System.out.println("给一个 1-100 的整数，猜这个数");
        int realNumber = (int)(Math.random() * 100) + 1;
        int myGuess = 0;
        int guessCount = 1;
        Scanner reader = new Scanner(System.in);
        System.out.println("输入猜测：");
        myGuess = reader.nextInt(); //
        while(myGuess != realNumber) {
            if(myGuess > realNumber) {
                System.out.println("猜大了，再猜："); 
                myGuess = reader.nextInt(); // ?
            }
            else if(myGuess < realNumber) {
                System.out.println("猜小了，再猜：");
                myGuess = reader.nextInt(); // ?
            }
            guessCount++;
        }
        if(guessCount < 4)
            System.out.println("你太聪明了");
        else if(guessCount > 8)
            System.out.println("要努力哦");
        else 
            System.out.println("正常");
    }
}