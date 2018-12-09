package com.orclewdp.webserver_v01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerTh extends Thread {

	private Socket bx;
	public ServerTh(Socket bx) {
		this.bx = bx;
	}
	@Override
	public void run() {
		PrintWriter pw = null;
		BufferedReader br = null;
		try {
			pw = new PrintWriter(bx.getOutputStream());
			//响应行
			pw.println("HTTP/1.1 200 OK");
			//响应头
			pw.println("Content-type:text/html;charset=utf-8");
			//空白行
			pw.println();
			//正文
			pw.println("<title>我的第一个页面</title>");
			pw.print("<b style='color:red'>Holle World</b>");
			
			pw.flush();// ǿ�Ʒ���
//			br = new BufferedReader(new InputStreamReader(bx.getInputStream()));
//			String mm = br.readLine();//
//			System.out.println(mm);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();// �ر�
			}
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
