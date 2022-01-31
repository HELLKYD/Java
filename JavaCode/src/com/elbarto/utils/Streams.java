package com.elbarto.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Streams {

	public static void main(String[] args) {
		File inFile = new File("/home/jakob/Dokumente/inFile");
		File outFile = new File("/home/jakob/Dokumente/outFile");
		Streams.inFileStream(inFile, outFile);

	}

	public static void inFileStream(File in, File out) {
		InputStream inStream = null;
		OutputStream outStream = null;

		try {
			inStream = new FileInputStream(in);
			outStream = new FileOutputStream(out);

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

	}

}
