package part2;
import java.io.*;
import java.net.*;  // 导入网络包
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class JsClient extends JFrame implements Runnable, ActionListener {
    JButton connection, jsbutton;
    JTextField inputA, inputB, inputC;
    JTextArea showResult;
    Socket socket = null;    // 定义 Socket 引用
    DataInputStream in = null;
    DataOutputStream out = null;
    Thread thread;
    public JsClient() {
        socket = new Socket();
        connection = new JButton("链接服务器");
        jsbutton = new JButton("求三角形的面积");
        jsbutton.setEnabled(false);
        inputA = new JTextField("0", 12);
        inputB = new JTextField("0", 12);
        inputC = new JTextField("0", 12);

        Box boxV1 = Box.createVerticalBox();
        boxV1.add(new JLabel("输入边 A"));
        boxV1.add(new JLabel("输入边 B"));
        boxV1.add(new JLabel("输入边 C"));

        Box boxV2 = Box.createVerticalBox();
        boxV2.add(inputA);
        boxV2.add(inputB);
        boxV2.add(inputC);

        Box baseBox = Box.createHorizontalBox();
        baseBox.add(boxV1);
        baseBox.add(boxV2);
        Container con = getContentPane();
        con.setLayout(new FlowLayout());
        showResult = new JTextArea(8, 18);
        con.add(connection);
        con.add(baseBox);
        con.add(jsbutton);
        con.add(new JScrollPane(showResult));
        jsbutton.addActionListener(this);
        connection.addActionListener(this);
        thread = new Thread(this);
        setBounds(100, 100, 360, 310);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == connection)
            try{
                if(socket.isConnected()) {}
                else {
                    InetAddress address = InetAddress.getByName(null);   // IP 地址
                    InetSocketAddress socketAddress = new InetSocketAddress(address, 4444); // 创建端口为 4444，地址为 address 的 socketAddress
                    socket.connect(socketAddress);
                    in = new DataInputStream(socket.getInputStream());     // socket 返回输入流
                    out = new DataOutputStream(socket.getOutputStream());     // socket 返回输出流
                    jsbutton.setEnabled(true);
                    thread.start();
                }
            } catch (IOException ee) {}

        if(e.getSource() == jsbutton) {
            try {
                double a = Double.parseDouble(inputA.getText()),
                       b = Double.parseDouble(inputB.getText()),
                       c = Double.parseDouble(inputC.getText());
                if(a + b > c && a + c > b && b + c > a) {
                    out.writeDouble(a);
                    out.writeDouble(b);
                    out.writeDouble(c);
                } else
                    inputA.setText("你输入的 3 个数不构成三角形");
            } catch (Exception ex) {
                inputA.setText("请输入数字字符");
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            try{
                double area = in.readDouble();   // in 读入一个 double 型数据
                showResult.append("\n三角形的面积：\n" + area);
                showResult.setCaretPosition((showResult.getText()).length());
            } catch (IOException e) {
                showResult.setText("与服务器已断开");
                jsbutton.setEnabled(false);
                break;
            }
        }
    }

    public static void main(String[] args) {
        JsClient win = new JsClient();
    }
}
