package com.example.demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class DemoApplication {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
//		SpringApplication.run(DemoApplication.class, args);

		// 0606
//		tryOutputInput();
//		tryFileWriter();
//		tryBuffered();

		// 0607
//		tryRegEx();
//		tryRegEx2();
//		tryRegEx3();

//		Scanner scanner = new Scanner(System.in);
//		while (true) {
//			System.out.println("Please input: ");
//			String input = scanner.next();
//			System.out.println("Your input is: " + input);
//		}
		
		tryJoin();

	}

	private static void tryJoin() {
		Xjoin job1 = new Xjoin("Job1");
		Xjoin job2 = new Xjoin("Job2");
		Xjoin job3 = new Xjoin("Job3");
		job1.start();
		try {
			job1.join();  // Job1優先執行到結束
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		job2.start();
		job3.start();
	}
	
	private static void tryRegEx3() {

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

	private static void tryRegEx2() {

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

	private static void tryRegEx() {

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

	private static void tryBuffered() {

		try (FileOutputStream fo = new FileOutputStream("D:\\test\\test21.txt", true);
				BufferedOutputStream bos = new BufferedOutputStream(fo);
				FileInputStream fi = new FileInputStream("D:\\test\\test21.txt");
				BufferedInputStream bis = new BufferedInputStream(fi)) {

			bos.write("hello123".getBytes());
			bos.flush();
//			bos.close();
			System.out.println("file write finished");

			int b;
			while ((b = fi.read()) != -1) {
				System.out.print((char) b);
			}
			System.out.println("read finished");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void tryFileWriter() {
		// 適用非英語系
		try (FileWriter fw = new FileWriter("D:\\test\\test11.txt", true);
				FileReader fr = new FileReader("D:\\test\\test11.txt")) {

			fw.write("你好");
			System.out.println("file write finished");

			int b;
			while ((b = fr.read()) != -1) {
				System.out.print((char) b);
			}
			System.out.println("read finished");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void tryOutputInput() {
		// FileOutputStream fo = null;
		// try with resource
		try (FileOutputStream fo = new FileOutputStream("D:\\test\\test2.txt", true);
				FileInputStream fi = new FileInputStream("D:\\test\\test.txt")) {
//			fo = new FileOutputStream("D:\\test\\test.txt", true);  // 若無指定路徑，會寫在專案底下
//			fo.write(97);
//			fo.write("\r\n".getBytes());
//			fo.write("hello".getBytes());
//			fo.write("\r\n===========\r\n".getBytes());
//			System.out.println("=====================");

			System.out.println("file size: " + fi.available());
			byte[] byteArray = new byte[fi.available()];
			fi.read(byteArray); // 讀取(輸入)
			fo.write(byteArray); // 寫入(輸出)內容至新的檔案 (複製)

////			FileInputStream fi = new FileInputStream("D:\\test\\test.txt");
//			fi = new FileInputStream("D:\\test\\test.txt");
//			int b;  // 若這邊也宣告一次，第一個字會讀不到
//			while ((b = fi.read()) != -1) {  // -1: 檔案末端 (迴圈停止條件)
//				System.out.print((char)b);	// ln:換行		
//			}
//			System.out.println("read finished");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
//			fo.close();
//			System.out.println("finally");
		}
	}

}

class Xjoin extends Thread {
	Xjoin(String name) {
		super(name);
	}
	public void run() {
		for (int i = 1; i <= 5; i++) {
			try {
				sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
			System.out.println(getName() + " is running " + i);
		}
	}
}
