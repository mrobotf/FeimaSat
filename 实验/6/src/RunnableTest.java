import javax.swing.*;
import java.awt.*;

public class RunnableTest extends JFrame implements Runnable{
    JLabel prompt1 = new JLabel("第一个子线程");
    JLabel prompt2 = new JLabel("第二个子线程");
    JTextField threadFirst = new JTextField(14);
    JTextField threadSecond = new JTextField(14);
    Thread thread1, thread2;
    int count1 = 0, count2 = 0;      // 两个计数器

    public RunnableTest() {
        super("线程测试");
        setLayout(new FlowLayout());
        add(prompt1);
        add(threadFirst);
        add(prompt2);
        add(threadSecond);
    }
    public void start() {
        thread1 = new Thread(this,"FirstThread");
        thread2 = new Thread(this,"SecondThread");
        thread1.start();
        thread2.start();
    }
    public void run() {         // 实现Runnable接口的run()方法
        String currentRunning;
        while(true) {           // 无限循环
            try {               // 使当前活动线程休眠0-3s
                Thread.sleep((int)(Math.random()*3000));
            } catch(InterruptedException e){}
            currentRunning = Thread.currentThread().getName();
            if(currentRunning.equals("FirstThread")) {
                count1++;
                threadFirst.setText("线程 1 第" + count1 + "次被调度");
            }
            else if(currentRunning.equals("SecondThread")) {
                count2++;
                threadSecond.setText("线程 2 第" + count2 + "次被调度");
            }
        }
    }

    public static void main(String[] args) {
        RunnableTest myapp = new RunnableTest();
        myapp.setSize(300, 100);
        myapp.setVisible(true);
        myapp.start();
        myapp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
