package com.elbarto.test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class TestConnect {

	public static void main(String[] args) {
		InetSocketAddress address = new InetSocketAddress("192.168.178.37", 9998);
		Socket client = new Socket();
		try {
			client.connect(address, 5000);
			Scanner s = new Scanner(new InputStreamReader(client.getInputStream()));
			if (s.hasNextLine()) {
				String l = s.nextLine();
				System.out.println(l);
			}
			if (s.hasNextLine()) {
				String l = s.nextLine();
				System.out.println(l);
			}
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
