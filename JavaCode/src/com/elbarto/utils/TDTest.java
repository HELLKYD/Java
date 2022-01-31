package com.elbarto.utils;

public class TDTest {

	public static void main(String[] args) {

		String path1 = "/home/jakob/Dokumente/inFile";
		String path2 = "/home/jakob/Dokumente/outFile";

		TransferData transfer = new TransferData();
		transfer.transfer(path1, path2);

	}

}
