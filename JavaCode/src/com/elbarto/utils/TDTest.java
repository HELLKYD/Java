package com.elbarto.utils;

public class TDTest {

	public static void main(String[] args) {

		String path1 = "/home/jakob/Dokumente/Wörter/A-Konjugation.txt";
		String path2 = "/home/jakob/Dokumente/Wörter/A-Konjugation_Perf.txt";

		TransferData transfer = new TransferData();
		transfer.transfer(path1, path2);

	}

}
