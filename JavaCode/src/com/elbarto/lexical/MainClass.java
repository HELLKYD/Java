package com.elbarto.lexical;

public class MainClass {

	public static void main(String[] args) {
		String sentence = "2 5.6 LOL";
		Lexer lexer = new Lexer(sentence);
		lexer.analyze();
		System.out.println("finished");
	}

}
