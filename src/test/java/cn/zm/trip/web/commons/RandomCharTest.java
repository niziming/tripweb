package cn.zm.trip.web.commons;

import org.junit.Test;

import java.util.List;

public class RandomCharTest {

	@Test
	public void randomChar() {
		char c = GenerateCharacters.generateChar();
		System.out.println(c);
	}

	@Test
	public void generateString() {
		StringBuffer stringBuffer = GenerateCharacters.generateString(5);
		int i = 5;
		while (i>0){
			System.out.println(stringBuffer);
			i--;
		}
	}

	@Test
	public void generatestrings() {
		List<String> generatestrings = GenerateCharacters.generatestrings(3);
		for (String string : generatestrings){
			System.out.println(string);
		}
	}
}