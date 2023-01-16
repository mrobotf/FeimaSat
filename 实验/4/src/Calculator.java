import java.util.Scanner;

class Calculator {
    public static void main(String[] args) {
        int x, y, result = 0;
        char op;
            try {
                x = Integer.parseInt(args[0]);
                y = Integer.parseInt(args[2]);
                op = args[1].charAt(0);
                switch (op) {
                    case '+':
                        result = x + y;
                        System.out.println("result = " + result);
                        break;
                    case '-':
                        result = x - y;
                        System.out.println("result = " + result);
                        break;
                    case 'x':
                        result = x * y;
                        System.out.println("result = " + result);
                        break;
                    case '/':
                        while(y == 0) {
                            System.out.println("捕获到了数学类异常，除数不能为0");
                            System.out.println("请重新输入除数：");
                            Scanner sc = new Scanner(System.in);
                            y = sc.nextInt();
                            x = Integer.parseInt(args[0]);
                            op = args[1].charAt(0);
                            int tag = 1;
                            switch (op) {
                                case '+':
                                    result = x + y;
                                    System.out.println("result = " + result);
                                    break;
                                case '-':
                                    result = x - y;
                                    System.out.println("result = " + result);
                                    break;
                                case '*':
                                    result = x * y;
                                    System.out.println("result = " + result);
                                    break;
                                case '/':
                                    if (y == 0)
                                        tag = 0;
                                    else {
                                        result = x / y;
                                        System.out.println("result = " + result);
                                        break;
                                    }
                            }
                            if (tag == 1)
                                break;
                        }
                }
            } catch (ArrayIndexOutOfBoundsException e1) {
                System.out.println("捕获到了异常,此程序要输入两个参数");
            } catch (NumberFormatException e2) {
                System.out.println("捕获到了异常，必须输入数字");
            } finally {
                System.out.println("不管是否有异常，总执行");
            }
        }
}