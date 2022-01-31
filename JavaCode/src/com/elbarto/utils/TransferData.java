package com.elbarto.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TransferData {

	public void transfer(String startPath, String endPath) {

		File startFile = new File(startPath);
		File endFile = new File(endPath);

		InputStream inStream = null;
		OutputStream outStream = null;

		try {
			inStream = new FileInputStream(startFile);
			outStream = new FileOutputStream(endFile);

			int input;
			while ((input = inStream.read()) != -1) {
				outStream.write(input);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inStream.close();
				outStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Process finished");
	}

}
