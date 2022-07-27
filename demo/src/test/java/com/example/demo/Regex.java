package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

public class Regex {

	@Test
	public void trySwitch() {
		int score = 99;
		switch (score / 10) {
		case 10:
		case 9:
		case 8:
			System.out.println("high score");
			break;

		default:
			System.out.println("not good");
			break;
		}
	}
	
	@Test
	public void tryTernary() {
		for (int i = 0; i < 10; i++) {
			double r = Math.random();  // 0 < q < 1
			String result = r > 0.5 ? " > 0.5" : " <= 0.5";
			System.out.println(r + result);
		}
	}
	
	@Test
	public void homework0608() {

		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Please input: ");
			String input = scanner.next();
//			System.out.println("Your input is: " + input);

//			String id = "A236263094";
			String id = input;
			String pattern = "[A-Z](1|2)\\d{8}";

			Map<String, String> map = new HashMap<>();
			map.put("A", "10");
			map.put("B", "11");
			map.put("C", "12");
			map.put("D", "13");
			map.put("E", "14");
			map.put("F", "15");
			map.put("G", "16");
			map.put("H", "17");
			map.put("I", "34");
			map.put("J", "18");
			map.put("K", "19");
			map.put("L", "20");
			map.put("M", "21");
			map.put("N", "22");
			map.put("O", "35");
			map.put("P", "23");
			map.put("Q", "24");
			map.put("R", "25");
			map.put("S", "26");
			map.put("T", "27");
			map.put("U", "28");
			map.put("V", "29");
			map.put("W", "32");
			map.put("X", "30");
			map.put("Y", "31");
			map.put("Z", "33");

			if (!id.matches(pattern)) {
				System.out.println("This is not correct ID number.");
			} else {
				String val = null;
				for (Map.Entry<String, String> item : map.entrySet()) {
					String key = item.getKey();
					if (id.substring(0, 1).equals(key)) {
						val = item.getValue();
						break;
					}
				}
				int index00 = Integer.parseInt(val.substring(0, 1));
				int index01 = Integer.parseInt(val.substring(1));
				int index1 = Integer.parseInt(id.substring(1, 2));
				int index2 = Integer.parseInt(id.substring(2, 3));
				int index3 = Integer.parseInt(id.substring(3, 4));
				int index4 = Integer.parseInt(id.substring(4, 5));
				int index5 = Integer.parseInt(id.substring(5, 6));
				int index6 = Integer.parseInt(id.substring(6, 7));
				int index7 = Integer.parseInt(id.substring(7, 8));
				int index8 = Integer.parseInt(id.substring(8, 9));
				int verifyCode = Integer.parseInt(id.substring(9));

				int product = index00 * 1 + index01 * 9 + index1 * 8 + index2 * 7 + index3 * 6 + index4 * 5 + index5 * 4
						+ index6 * 3 + index7 * 2 + index8 * 1;
				int expectedNumber = 10 - product % 10;
				if (expectedNumber == verifyCode) {
					System.out.println("This is correct ID number.");
				} else {
					System.out.println("This is not correct ID number.");
				}

			}
		}
	}

	@Test
	public void tryRegEx4() {

		String str1 = "cat";
		String str2 = "flat";
		String str3 = "at";
		String pattern = ".*at"; // .(萬用字元): 除了\n以外的所有字元
		System.out.println("cat: " + str1.matches(pattern));
		System.out.println("flat: " + str2.matches(pattern));
		System.out.println("at: " + str3.matches(pattern));

		// 1
		Pattern p = Pattern.compile(pattern); // 編譯正規表達式
		Matcher m = p.matcher(str1);
		System.out.println(m.matches());

		// 2
		System.out.println(Pattern.matches(pattern, str1));

	}

	@Test
	public void tryRegEx3() {

		String str1 = "98_ad";
		String str2 = "98_@ad";
		String pattern = "\\w+"; // (不限長度) 數字/大小寫英文/底線
		System.out.println("98_ad: " + str1.matches(pattern));
		System.out.println("98_@ad: " + str2.matches(pattern));

		String str3 = "AAA";
		String pattern1 = "AAA" + "\\w+"; // 至少1
		String pattern2 = "AAA" + "\\w*"; // 可0
		System.out.println("AAA: " + str3.matches(pattern1));
		System.out.println("AAA: " + str3.matches(pattern2));

	}

	@Test
	public void tryRegEx2() {

		// ? * +
		List<String> list1 = new ArrayList<>();
		list1.add("Johnson");
		list1.add("Johnnason");
		list1.add("Johnnanason");
		list1.add("John");

		List<String> patternList = new ArrayList<>();
		patternList.add("John(na)?son");
		patternList.add("John(na)*son");
		patternList.add("John(na)+son");

		for (String string : list1) {
			for (String string2 : patternList) {
				System.out.println(String.format("%s is %s : ", string, string2) + string.matches(string2));
			}
		}

	}

	@Test
	public void tryRegEx() {

		String str1 = "I love java";
		String str2 = "0912-345-678";
		String str3 = "1111-11111";
		String pattern = "\\d{4}(-\\d{3}){2}"; // xxxx-xxx-xxx // -\\d{3} 重複了2次

		System.out.println("I love java is phone number: " + str1.matches(pattern));
		System.out.println("0912-345-678 is phone number: " + str2.matches(pattern));
		System.out.println("1111-11111 is phone number: " + str3.matches(pattern));

		String str4 = "(02)23456789";
		String str5 = "02-23456789";
		String pattern2 = "\\(\\d{2}\\)\\d{8}|\\d{2}-\\d{8}"; // 括弧也要跳脫 // |前後不可有空格
		System.out.println("(02)23456789 is local phone number: " + str4.matches(pattern2));
		System.out.println("02-23456789 is local phone number: " + str5.matches(pattern2));

		// 練習
//		String str6 = "038 - 123456";
//		str6 = str6.replace(" ", "");

//		String[] strArr = str6.split("-");
//		if (strArr[0].equalsIgnoreCase("02")) {
//			// == 只能做物件比對
//			System.out.println("this is TW local phone number: " + strArr[1].matches("\\d{8}"));
//		} else if (strArr[0].matches("0\\d|0\\d{2}|0\\d{3}")) {
//			String str41 = str6.replace("-", "").substring(2);
//			System.out.println("this is TW local phone number: " + str41.matches("\\d{7}"));
//		} else {
//			System.out.println("this is TW local phone number: " + false);
//		}

		String str6 = "03-1234567";
		String str7 = "02-1234567";
		String pattern3 = "02-\\d{8}|0(3|4|5|6|7|8|9)-\\d{7}|0\\d{2}-\\d{6}|0\\d{3}-\\d{5}";
		System.out.println("03-1234567 is TW local phone number: " + str6.matches(pattern3));
		System.out.println("02-1234567 is TW local phone number: " + str7.matches(pattern3));

	}

}
