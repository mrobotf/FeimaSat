class ShopWorker implements Runnable{
    static Thread zhangSan, liSi, boss;
    ShopWorker() {
        boss = new Thread(this, "boss");
        zhangSan = new Thread(this, "zhangSan");
        liSi = new Thread(this, "liSi");
    }
    public void run() {
        int i = 0;
        if(Thread.currentThread() == zhangSan) {
            while(true) {
                try{
                    i++;
                    System.out.println(Thread.currentThread().getName() + "已搬" + i + "箱货物");
                    if(i == 3) return;
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    System.out.println(boss.getName() + "让" + Thread.currentThread().getName() + "继续工作");
                }
            }
        }
        else if(Thread.currentThread() == liSi) {
            while (true) {
                try{
                    i++;
                    System.out.println(Thread.currentThread().getName() + "已搬" + i + "箱货物");
                    if(i == 3) return;
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    System.out.println(boss.getName() + "让" + Thread.currentThread().getName() + "继续工作");
                }
            }
        }
        else if(Thread.currentThread() == boss) {
            while(true) {
                zhangSan.interrupt();           // 唤醒 zhangSan
                liSi.interrupt();
                if(!(zhangSan.isAlive() || liSi.isAlive())) {
                    System.out.println("下班了");
                    return;
                }
            }
        }
    }
}
class ShopWork {
    public static void main(String[] args) {
        ShopWorker shop = new ShopWorker();
         shop.zhangSan.start();
         shop.liSi.start();
         shop.boss.start();
    }
}
