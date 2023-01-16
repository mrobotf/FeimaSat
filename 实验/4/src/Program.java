class Program {
    String name = "信息学院";
    int no1 = 10;
    int no2 = 20;
    public Program() {
        try {
            System.out.println(name);
            System.out.println("相除结果为：" + no1/no2);
        } catch(ArithmeticException I) {
            System.out.println("不能除 0 ！");
        }
        finally {
            name = null;
            System.out.println("Finally 已执行");;
        }
    }

    public static void main(String[] args) {
        new Program();
    }
}
