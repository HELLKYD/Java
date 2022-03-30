package com.elbarto.lexical;

import java.util.ArrayList;

public class Lexer {
	private static String[] letters;
	private static ArrayList<LSToken> ls_Tokens = new ArrayList<>();
	private static int cur_Pos = 0;

	public static void main(String[] args) {
		String line = "-295 + 3.5456";
		Analyze(line);
	}

	public static void Analyze(String line) {
		readAndSplit(line);
		searchForNumberTypes();
		PrintTokens();
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
		int FloatCounter = 0;
		while (cur_Pos < letters.length) {
			String cur = letters[cur_Pos];
			if (cur.equals(" ") || cur.equals(".") || cur.equals("(") || cur.equals(")")) {
				cur_Pos++;
				continue;
			} else if (cur.equals("+")) {
				LSToken temp_tok = new LSToken(cur);
				ls_Tokens.add(temp_tok);
				cur_Pos++;
			} else if (cur.equals("-") && cur_Pos != 0) {
				LSToken temp_tok = new LSToken(cur);
				ls_Tokens.add(temp_tok);
				cur_Pos++;
			} else {
				String not_converted_chars = cur;
				int index = cur_Pos + 1;
				boolean isFloat = false;
				boolean isOperator = false;
				while (index < letters.length) {
					String temp = letters[index];
					if (temp.equals(" ") || temp.equals("+")) {
						break;
					} else if (temp.equals(".")) {
						not_converted_chars += temp;
						isFloat = true;
						index++;
					} else {
						not_converted_chars += temp;
						index++;
					}
				}
				try {
					if (isFloat) {
						FloatCounter++;
						float float_tok_value = Float.parseFloat(not_converted_chars);
						LSToken temp_tok = new LSToken(float_tok_value);
						ls_Tokens.add(temp_tok);
						cur_Pos = index;
					} else {
						IntCounter++;
						int tok_value = Integer.parseInt(not_converted_chars);
						LSToken temp_tok = new LSToken(tok_value);
						ls_Tokens.add(temp_tok);
						cur_Pos = index;
					}
				} catch (NumberFormatException e) {
					System.out.println("Error: An Error occured with one of the numbers");
					System.exit(404);
				}
			}
		}
		System.out.println("Integer: " + IntCounter);
		System.out.println("Floats: " + FloatCounter);
	}

	private static void PrintTokens() {
		for (LSToken cur : ls_Tokens) {
			cur.printToken();
		}
	}

	private static class LSToken {
		private int value;
		private float float_value;
		private String type;
		private boolean isFloat;
		private boolean is_op;
		private String op_value;

		public LSToken(int value) {
			this.value = value;
			this.type = "Int";
		}

		public LSToken(float float_value) {
			this.float_value = float_value;
			this.type = "Float";
			this.isFloat = true;
		}

		public LSToken(String op_value) {
			this.is_op = true;
			this.op_value = op_value;
			this.type = "Operator";
		}

		public void printToken() {
			if (isFloat) {
				System.out.println("Type: " + type + " Value: " + float_value);
			} else if (is_op) {
				System.out.println("Type: " + type + " Value: " + op_value);
			} else {
				System.out.println("Type: " + type + " Value: " + value);
			}
		}
	}
}