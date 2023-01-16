import java.net.*;
import java.io.*;
public class Client {
    public static void main(String[] args) throws IOException {
        Socket soc = new Socket("localhost", 3389);    // 将target mechine替换为目标计算机的IP地址或主机名
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入消息至服务器");
        String message = "";
        String temp;
        PrintStream ps = new PrintStream(soc.getOutputStream());
        while(!((temp = br.readLine()).equals("quit"))) {
            ps.println(temp);
        }
        ps.close();
        soc.close();
    }
}
