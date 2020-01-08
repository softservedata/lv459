package com.softserve.edu;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
	public static void main(String args[]) {
		//String pattern = "[a-z]+";
		//String pattern = "[a-z N]+";
		//String text = "Now is the time";
		//
		//String pattern = "<.+>"; // All text
		//String pattern = "<[^>]+>"; // All tags
		//String pattern = ">[^<]+<"; // All text without tags
		//String pattern = "<([^>]+)>[^<]+</\\1>"; // All tags and text <font>22</font>
		//String pattern = "\\(\\d+\\)"; // Count
		////String pattern = "(\\d{1,3},)*\\d{1,3}\\.\\d{2}"; 
		//String pattern = "<\\w+>";
		////String text = "<p><b>Beginning with$10.00 bold text $2,101,201.50</b> next, text <font>(2)</font>body,<i>italic(123) text</i> end of text.</p>";
		//
		String pattern = "(\\w+\\.)*\\w+@(\\w+\\.)+\\w{2,}";
		String text = "abc.aa1a_e.a@ssss.sss.ua  a@i.ua  ab.@aa.aa  aaa@a.a  bbb@bb.bb";
		//String text = "a@i.ua";
		//
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(text);
		//
		if (m.matches()) {
			System.out.println("m.matches TRUE" );
		} else {
			System.out.println("m.matches FALSE" );
		}
		m.reset();
		//
		//List<String> texts = new ArrayList<>();
		////List<Double> texts = new ArrayList<>();
		while (m.find()) {
			////String str = text.substring(m.start(), m.end());
			//texts.add(str.substring(1,str.length()-1).trim()); // All text without tags
			//texts.add(str.substring(0,str.length()).trim()); // All tags and text <font>22</font>
			//texts.add(str.substring(1,str.length()-1).trim()); // Count
			//
			////str = str.replace(",", "");
			////texts.add(Double.parseDouble(str));
			System.out.print(text.substring(m.start(), m.end()) + "*");
		}
		////System.out.println("List: " + texts);
	}
}
