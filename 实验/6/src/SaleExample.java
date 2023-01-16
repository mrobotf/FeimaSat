class BreadSeller {         // 卖面包，一块面包5块钱
    int fiveNum = 1, tenNum = 0, twentyNum = 0;      // 面包师傅现有各面额的钱币的数量
    public synchronized void sellBread(int receiveMoney, int buyNumber) {
        if(receiveMoney == 5) {
            fiveNum = fiveNum + 1;
            System.out.println("\");
        }
    }
}
public class SaleExample {
}
