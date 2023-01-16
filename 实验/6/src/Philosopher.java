class Phil implements Runnable {
    private int position;           // 哲学家所在的位置
    private int numLeftChop = 0;    // 左手拿到筷子的人数
    private Integer[] chop;

    public Phil(int position, Integer[] chop){
        this.position = position;
        this.chop = chop;
    }

    @Override
    public void run() {
        while(true) {
            int left = position;
            int right = (position - 1)%5;
            if(position == 0)
                right = 4;
            if(numLeftChop < 4) {     // 限制取筷子人数
                synchronized (chop[left]) {
                    numLeftChop++;
                    System.out.println("哲学家" + position + "取到他左手边的筷子");
                    synchronized (chop[right]) {
                        System.out.println("哲学家" + position + "取到他右手边的筷子");
                        System.out.println("哲学家" + position + "正在吃饭");
                        try {       // 吃饭
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("哲学家" + position + "吃完了");
                        numLeftChop--;      // 放下筷子
                    }
                }
                try {               // 思考
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class Philosopher {
    public static void main(String[] args) {
        Integer []chop = new Integer[5];
        for(int i = 0; i < 5; i++)
            chop[i] = i;

        Phil phil0 = new Phil(0, chop);
        Phil phil1 = new Phil(1, chop);
        Phil phil2 = new Phil(2, chop);
        Phil phil3 = new Phil(3, chop);
        Phil phil4 = new Phil(4, chop);

        new Thread(phil0).start();
        new Thread(phil1).start();
        new Thread(phil2).start();
        new Thread(phil3).start();
        new Thread(phil4).start();
    }

}