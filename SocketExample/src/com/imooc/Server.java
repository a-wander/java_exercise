package com.imooc;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(8888);
			System.out.println("****服务器即将启动！****");
			Socket socket = null;
			// 记录客户端数量
			int nCount = 0;
			while (true) {
				socket = serverSocket.accept();
				ServerThread serverThread = new ServerThread(socket);
				serverThread.start();
				++nCount;
				System.out.println("#已连接的客户端数量："+nCount);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (serverSocket != null) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
