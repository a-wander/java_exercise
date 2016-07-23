package com.imooc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		Socket socket=null;
		try {
			socket = new Socket("localhost", 8888);
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			Scanner scanner = new Scanner(System.in);
			pw.write(scanner.nextLine());
			scanner.close();
			pw.flush();
			socket.shutdownOutput();
			
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String info=null;
			while((info=br.readLine())!=null){
				System.out.println(info);
			}
			socket.shutdownInput();//πÿ±’ ‰»Î¡˜
			br.close();
			isr.close();
			is.close();
			
			pw.close();
			os.close();
			
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
