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

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws IOException {
//		SpringApplication.run(DemoApplication.class, args);

		// 0606
//		tryOutputInput();
//		tryFileWriter();
//		tryBuffered();

		// 0607
//		tryRegEx();
		tryRegEx2();

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
		String pattern = "\\d{4}(-\\d{3}){2}"; // xxxx-xxx-xxx // -\\d{3} ���ƤF2��

		System.out.println("I love java is phone number: " + str1.matches(pattern));
		System.out.println("0912-345-678 is phone number: " + str2.matches(pattern));
		System.out.println("1111-11111 is phone number: " + str3.matches(pattern));

		String str4 = "(02)23456789";
		String str5 = "02-23456789";
		String pattern2 = "\\(\\d{2}\\)\\d{8}|\\d{2}-\\d{8}"; // �A���]�n���� // |�e�ᤣ�i���Ů�
		System.out.println("(02)23456789 is local phone number: " + str4.matches(pattern2));
		System.out.println("02-23456789 is local phone number: " + str5.matches(pattern2));

		// �m��
		String str6 = "038 - 123456";
		str6 = str6.replace(" ", "");

		String[] strArr = str6.split("-");
		if (strArr[0].equalsIgnoreCase("02") || strArr[0].equalsIgnoreCase("04")) {
			// == �u�వ������
			System.out.println("this is TW local phone number: " + strArr[1].matches("\\d{8}"));
		} else if (strArr[0].matches("0\\d|0\\d{2}")) {
			String str41 = str6.replace("-", "").substring(2);
			System.out.println("this is TW local phone number: " + str41.matches("\\d{7}"));
		} else {
			System.out.println("this is TW local phone number: " + false);
		}

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
		// �A�ΫD�^�y�t
		try (FileWriter fw = new FileWriter("D:\\test\\test11.txt", true);
				FileReader fr = new FileReader("D:\\test\\test11.txt")) {

			fw.write("�A�n");
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
//			fo = new FileOutputStream("D:\\test\\test.txt", true);  // �Y�L���w���|�A�|�g�b�M�ש��U
//			fo.write(97);
//			fo.write("\r\n".getBytes());
//			fo.write("hello".getBytes());
//			fo.write("\r\n===========\r\n".getBytes());
//			System.out.println("=====================");

			System.out.println("file size: " + fi.available());
			byte[] byteArray = new byte[fi.available()];
			fi.read(byteArray); // Ū��(��J)
			fo.write(byteArray); // �g�J(��X)���e�ܷs���ɮ� (�ƻs)

////			FileInputStream fi = new FileInputStream("D:\\test\\test.txt");
//			fi = new FileInputStream("D:\\test\\test.txt");
//			int b;  // �Y�o��]�ŧi�@���A�Ĥ@�Ӧr�|Ū����
//			while ((b = fi.read()) != -1) {  // -1: �ɮץ��� (�j�鰱�����)
//				System.out.print((char)b);	// ln:����		
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
