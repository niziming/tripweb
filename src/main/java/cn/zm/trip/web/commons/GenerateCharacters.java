package cn.zm.trip.web.commons;

import java.util.ArrayList;
import java.util.List;

public class GenerateCharacters {
	/**
	 * 随机生成单个字符
	 * @return
	 */
	public static char generateChar(){
		int a = (int)(Math.random()*(1+1));
		if (a == 0){
			return (char)('a'+Math.random()*('z'-'a'+1));
		}
		else{
			return (char)('A'+Math.random()*('Z'-'A'+1));
		}
	}
	// 生成 SB 随机串
	public static StringBuffer generateString(int length){

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < length; i++){
			sb.append(generateChar());
		}

		for(int i = 0; i < sb.toString().toCharArray().length; i++){
			if ((i+1) % 5 == 0){
				System.out.printf("%-3s\n",sb.toString().toCharArray()[i]);
				System.out.println("-------------");
			}else {
				System.out.printf("%-3s",sb.toString().toCharArray()[i]);
			}
		}
		return sb;
	}

	public static List<String>  generateStrings(int number){

		List<String> strings = new ArrayList<>();
		while (number > 0){
			strings.add(generateString(5).toString());
			number--;
		}
		return strings;
	}
}
