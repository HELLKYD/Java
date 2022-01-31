package com.elbarto.network;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.TargetDataLine;

public class Sender {

	public static void main(String[] args) {

		System.setProperty("java.net.preferIPv4Stack", "true");
		TargetDataLine line;
		DatagramPacket dgp;
		AudioFormat.Encoding encoding = AudioFormat.Encoding.PCM_SIGNED;
		float rate = 44100.0f;
		int channels = 2;
		int sampleSize = 16;
		boolean bigEndian = false;

		InetAddress addr;
		int port = 9991;
		System.out.println("Server started on port " + port);

		AudioFormat format = new AudioFormat(encoding, rate, sampleSize, channels, (sampleSize / 8) * channels, rate,
				bigEndian);
		DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
		if (!AudioSystem.isLineSupported(info)) {
			System.err.println("Data line not supported");
		}

		try {
			line = (TargetDataLine) AudioSystem.getLine(info);
			line.open();
			line.start();
			byte[] data = new byte[4096];

			addr = InetAddress.getByName("225.6.7.8");
			MulticastSocket socket = new MulticastSocket();
			while (true) {
				line.read(data, 0, data.length);
				dgp = new DatagramPacket(data, data.length, addr, port);
				socket.send(dgp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
