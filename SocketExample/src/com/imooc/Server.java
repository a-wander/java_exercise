package com.imooc;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(8888);
			System.out.println("****����������������****");
			Socket socket = null;
			// ��¼�ͻ�������
			int nCount = 0;
			while (true) {
				socket = serverSocket.accept();
				ServerThread serverThread = new ServerThread(socket);
				serverThread.start();
				++nCount;
				System.out.println("#�����ӵĿͻ���������"+nCount);
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
