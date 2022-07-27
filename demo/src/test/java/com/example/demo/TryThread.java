package com.example.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.junit.jupiter.api.Test;

public class TryThread {
	
	@Test
	public void tryThread() {
		MultiThread t = new MultiThread();
		t.start();
		System.out.println("default Thread name: " + t.getName());
	}
	
	@Test
	public void tryMultiThread() {
		// 多執行緒 繼承Thread類別
		HorseRacing t1 = new HorseRacing("Horse1");  // 建立Horse1物件
		HorseRacing t2 = new HorseRacing("Horse2");  // 建立Horse2物件
		t1.start();
		t2.start();
	}
	
	@Test
	public void tryImplRunnable() {
		// Java不允許多重繼承，想讓此class具有Thread的方法可用實作Runnable介面
		A a = new A();  // 建立a物件
		Thread t = new Thread(a);  // 建立t執行緒
		t.start();
	}
	
	@Test
	public void tryJoin() {
		// 要寫在application否則無法執行
		Xjoin job1 = new Xjoin("Job1");
		Xjoin job2 = new Xjoin("Job2");
		Xjoin job3 = new Xjoin("Job3");
		job1.start();
//		try {
//			job1.join();  // Job1優先執行到結束
//		} catch (InterruptedException e) {
//			System.out.println(e);
//		}
		job2.start();
		job3.start();
	}
	
	@Test
	public void tryZip() throws IOException {
		// 建立欲壓縮的物件src(檔案須已存在) 將來源建立成FileInputStream
		File fileToZip = new File("D:\\test\\test.txt");
		FileInputStream src = new FileInputStream(fileToZip);
		// 建立壓縮目的位置物件: 建立要輸出的ZipOutputStream
		FileOutputStream zipToSave = new FileOutputStream("D:\\test\\test.zip");
		ZipOutputStream dst = new ZipOutputStream(zipToSave);
		// 在壓縮檔案內建立壓縮項目: 建立ZipEntry
		ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
		dst.putNextEntry(zipEntry);  // 要準備寫入的項目
		// byte方式讀出未壓縮src物件，以zip格式輸出串流
		byte[] bytes = new byte[1024];  // 設定的byte陣列空間，預設1024
		int length;  // 記錄讀取byte數
		while((length = src.read(bytes)) >= 0) {
			dst.write(bytes, 0, length);  // 以zip格式寫入輸出串流
		}
		dst.close();
		src.close();
	}
	
	@Test
	public void tryMultiFileToZip() throws IOException {
		// 壓縮多個檔案
		String[] srcFiles = {"D:\\test\\test1.txt", "D:\\test\\test2.txt"};
		
		FileOutputStream zipToSave = new FileOutputStream("D:\\test\\test12.zip");
		ZipOutputStream dst = new ZipOutputStream(zipToSave);
		
		for (String srcFile : srcFiles) {
			File fileToZip = new File(srcFile);
			FileInputStream src = new FileInputStream(fileToZip);
			
			ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
			dst.putNextEntry(zipEntry);
			
			byte[] bytes = new byte[1024];  // 設定的byte陣列空間，預設1024
			int length;  // 記錄讀取byte數
			while((length = src.read(bytes)) >= 0) {
				dst.write(bytes, 0, length);  // 以zip格式寫入輸出串流
			}
			src.close();  // 每次迴圈內都要關閉輸入串流
		}
		dst.close();  // 關閉輸出串流
	}

}

//class Xjoin extends Thread {
//	Xjoin(String name) {
//		super(name);
//	}
//	public void run() {
//		for (int i = 1; i <= 5; i++) {
//			try {
//				sleep(500);
//			} catch (InterruptedException e) {
//				System.out.println(e);
//			}
//			System.out.println(getName() + " is running " + i);
//		}
//	}
//}


class A implements Runnable {  // 實作A介面
	@Override
	public void run() {
		System.out.println("A is running");
	}	
}


class HorseRacing extends Thread {
	HorseRacing(String name) {  // 建構方法
		super(name);  // 設定名稱
	}
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println(getName() + " now at " + i + " round");
		}
	}
}


class MultiThread extends Thread {
	@Override
	public void run() {
		System.out.println("Thread runs");
	}
}