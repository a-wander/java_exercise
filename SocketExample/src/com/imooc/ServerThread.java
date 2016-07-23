package com.imooc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/*
 * 服务器线程处理类
 */
public class ServerThread extends Thread {
	//和本线程相关的socket
	Socket socket = null;
	
	public ServerThread(Socket socket){
		this.socket = socket;
	}
	
	public void run() {
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		OutputStream os = null;
		PrintWriter pw = null;
		try {
			is = socket.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			System.out.print("客户端说：");
			String info=null;
			while((info=br.readLine())!=null){
				System.out.println(info);
			}
			socket.shutdownInput();//关闭输入流
			
			os = socket.getOutputStream();
			pw = new PrintWriter(os);
			InetAddress address = socket.getInetAddress();
			pw.write("你好，你好！ IP:" + address.getHostAddress() + " 主机名:" + address.getHostName());
			pw.flush();
			socket.shutdownOutput();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pw != null) {
					pw.close();
				}
				if (os != null) {
					os.close();
				}
				if (br != null) {
					br.close();
				}
				if (isr != null) {
					isr.close();
				}
				if (is != null) {
					is.close();
				}
				if (socket != null) {
					socket.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}