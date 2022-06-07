package com.example.demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
		tryRegEx();

	}
	
	private static void tryRegEx() {
		
		String str1 = "I love java";
		String str2 = "0912-345-678";
		String str3 = "1111-11111";
		String pattern = "\\d\\d\\d\\d-\\d\\d\\d-\\d\\d\\d";  // xxxx-xxx-xxx
		
		System.out.println("I love java is phone number: " + str1.matches(pattern));
		System.out.println("0912-345-678 is phone number: " + str2.matches(pattern));
		System.out.println("1111-11111 is phone number: " + str3.matches(pattern));
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
				System.out.print((char)b);		
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
			System.out.print((char)b);	
		}
		System.out.println("read finished");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void tryOutputInput() {
		//		FileOutputStream fo = null;
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
			byte[] byteArray =  new byte[fi.available()];
			fi.read(byteArray);  // Ū��(��J)
			fo.write(byteArray);  // �g�J(��X)���e�ܷs���ɮ� (�ƻs)
			
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
