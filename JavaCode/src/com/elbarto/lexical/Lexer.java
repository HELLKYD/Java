package com.elbarto.lexical;

import java.util.ArrayList;

public class Lexer {

	private String sentence;
	private String[] splitted;
	private static final String LS_LOL = "LOL";
	private static final String LS_AND = "and";
	private static final String LS_LIL = "LIL";
	private static final String DIGITS = "0123456789";

	public Lexer(String sentence) {
		this.sentence = sentence;
	}

	public void analyze() {
		this.splitted = splitSent(this.sentence);
		ArrayList<LSToken> tokens = analyzeForToken(splitted);
		printTokens(tokens);
	}

	private static void printTokens(ArrayList<LSToken> tokens) {
		for (LSToken cur : tokens) {
			System.out.println(cur.printType());
		}
	}

	private static ArrayList<LSToken> analyzeForToken(String[] input) {
		ArrayList<LSToken> tokens = new ArrayList<LSToken>();
		for (String cur : input) {
			String temp = cur;
			if (checkForInt(temp)) {
				LSToken temp_tok = new LSToken(TokenTypes.LS_INT, Integer.parseInt(temp));
				tokens.add(temp_tok);
			} else if (checkForFloat(temp)) {
				LSToken temp_tok = new LSToken(TokenTypes.LS_FLOAT, Float.parseFloat(temp));
				tokens.add(temp_tok);
			} else {
				LSToken temp_tok = new LSToken(TokenTypes.LS_INVALID, null);
				System.exit(0);
			}
		}
		return tokens;
	}

	private static boolean checkForFloat(String pot_float) {
		try {
			float i = Float.parseFloat(pot_float);
		} catch (NumberFormatException e) {
			System.out.println("Error");
			return false;
		}
		return true;
	}

	private static boolean checkForInt(String potInt) {
		try {
			int i = Integer.parseInt(potInt);
		} catch (NumberFormatException e) {
			System.out.println("Error");
			return false;
		}
		return true;
	}

	private static String[] splitSent(String sentence) {
		return sentence.split(" ");
	}

}
