package com.elbarto.lexical;

import java.util.ArrayList;

public class Lexer {
	private static String[] letters;
	private static String[] numbers = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
	private static ArrayList<IntToken> intTokens = new ArrayList<>();
	private static int cur_Pos = 0;

	public static void main(String[] args) {
		String line = "295 + 3.5";
		Analyze(line);
	}

	public static void Analyze(String line) {
		readAndSplit(line);
		searchForNumberTypes();
		PrintIntTokens();
		cur_Pos = 0;
	}

	private static void readAndSplit(String toRead) {
		String[] chars = new String[toRead.length()];
		for (int i = 0; i < toRead.length(); i++) {
			// System.out.println(toRead.substring(i,i+1));
			chars[i] = toRead.substring(i, i + 1);
		}
		letters = chars;
	}

	private static void searchForNumberTypes() {
		int IntCounter = 0;
		while (cur_Pos < letters.length) {
			String cur = letters[cur_Pos];
			if (cur.equals(" ") || cur.equals("+") || cur.equals(".")) {
				cur_Pos++;
				continue;
			} else {
				String not_converted_chars = cur;
				int index = cur_Pos + 1;
				while (index < letters.length) {
					String temp = letters[index];
					if (temp.equals(" ") || temp.equals("+") || temp.equals(".")) {
						break;
					} else {
						not_converted_chars += temp;
						index++;
					}
				}
				try {
					IntCounter++;
					int tok_value = Integer.parseInt(not_converted_chars);
					IntToken temp_tok = new IntToken(tok_value);
					intTokens.add(temp_tok);
					cur_Pos = index;
				} catch (NumberFormatException e) {
					System.out.println("Error: Number too large");
					System.exit(404);
				}
			}
		}
		System.out.println("Integer: " + IntCounter);
	}

	private static void PrintIntTokens() {
		for (IntToken cur : intTokens) {
			cur.printToken();
		}
	}

	private static class IntToken {
		private int value;
		private String type;

		public IntToken(int value) {
			this.value = value;
			this.type = "Int";
		}

		public void printToken() {
			System.out.println("Type: " + type + " Value: " + value);
		}
	}
}
