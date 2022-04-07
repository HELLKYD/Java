package com.elbarto.lexical;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {

	public static void main(String[] args) {
		String input = "numerus = 999;";
		Pattern p = Pattern.compile("numerus\\s=\\s([0-9]){1,9};");
		Matcher m = p.matcher(input);
		while (m.find()) {
			System.out.println("Found " + m.group());
			Pattern p2 = Pattern.compile("([0-9]){1,9}");
			Matcher m2 = p2.matcher(input);
			if (m2.find()) {
				String s = m2.group();
				System.out.println(s);
			}
		}
	}

}
