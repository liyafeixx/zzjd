package com.orclewdp.webserver_v01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Tcpfu {

	public static void main(String[] args) {
		//
		ServerSocket serverSocket=null;
		try {
			serverSocket=new ServerSocket(8070);
			//������
			while (true) {
				Socket bx=serverSocket.accept();
				new ServerTh(bx).start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (serverSocket!=null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
        
      
	}

}
