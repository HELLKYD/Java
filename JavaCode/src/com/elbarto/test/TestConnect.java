package com.elbarto.test;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class TestConnect {

	public static void main(String[] args) {
		InetSocketAddress address = new InetSocketAddress("10.0.2.15", 9998);
		Socket client = new Socket();
		try {
			client.connect(address, 5000);
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
			pw.println(7);
			System.out.println("Message Sent");
			pw.flush();
			pw.close();
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
