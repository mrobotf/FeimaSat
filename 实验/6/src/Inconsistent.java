public class Inconsistent {
    static boolean started = false;

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                }
                System.out.println("started set to true");
                started = false;
            }
        });
        thread1.start();
        while (!started) {
        }
        System.out.println("Wait 3 3seconds and exit");
    }
}
