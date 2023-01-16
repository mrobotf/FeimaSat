package main;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
//服务端启动类
import thread.ServerThread;//新开的一个服务端线程

public class ServerMain
{
	public static void main(String[] args) 
	{
		try {
			ServerSocket ss=new ServerSocket(11111);//监视端口11111
			while(true)
			{
				System.out.println("等待用户连接");
				Socket s=ss.accept();//检验是否是连接客户端成功
				System.out.println(s.getInetAddress()+"链接成功");
				new Thread(new ServerThread(s)).start();//每一次执行一边线程
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
}