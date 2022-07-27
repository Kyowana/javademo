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
		// �h����� �~��Thread���O
		HorseRacing t1 = new HorseRacing("Horse1");  // �إ�Horse1����
		HorseRacing t2 = new HorseRacing("Horse2");  // �إ�Horse2����
		t1.start();
		t2.start();
	}
	
	@Test
	public void tryImplRunnable() {
		// Java�����\�h���~�ӡA�Q����class�㦳Thread����k�i�ι�@Runnable����
		A a = new A();  // �إ�a����
		Thread t = new Thread(a);  // �إ�t�����
		t.start();
	}
	
	@Test
	public void tryJoin() {
		// �n�g�bapplication�_�h�L�k����
		Xjoin job1 = new Xjoin("Job1");
		Xjoin job2 = new Xjoin("Job2");
		Xjoin job3 = new Xjoin("Job3");
		job1.start();
//		try {
//			job1.join();  // Job1�u������쵲��
//		} catch (InterruptedException e) {
//			System.out.println(e);
//		}
		job2.start();
		job3.start();
	}
	
	@Test
	public void tryZip() throws IOException {
		// �إ߱����Y������src(�ɮ׶��w�s�b) �N�ӷ��إߦ�FileInputStream
		File fileToZip = new File("D:\\test\\test.txt");
		FileInputStream src = new FileInputStream(fileToZip);
		// �إ����Y�ت���m����: �إ߭n��X��ZipOutputStream
		FileOutputStream zipToSave = new FileOutputStream("D:\\test\\test.zip");
		ZipOutputStream dst = new ZipOutputStream(zipToSave);
		// �b���Y�ɮפ��إ����Y����: �إ�ZipEntry
		ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
		dst.putNextEntry(zipEntry);  // �n�ǳƼg�J������
		// byte�覡Ū�X�����Ysrc����A�Hzip�榡��X��y
		byte[] bytes = new byte[1024];  // �]�w��byte�}�C�Ŷ��A�w�]1024
		int length;  // �O��Ū��byte��
		while((length = src.read(bytes)) >= 0) {
			dst.write(bytes, 0, length);  // �Hzip�榡�g�J��X��y
		}
		dst.close();
		src.close();
	}
	
	@Test
	public void tryMultiFileToZip() throws IOException {
		// ���Y�h���ɮ�
		String[] srcFiles = {"D:\\test\\test1.txt", "D:\\test\\test2.txt"};
		
		FileOutputStream zipToSave = new FileOutputStream("D:\\test\\test12.zip");
		ZipOutputStream dst = new ZipOutputStream(zipToSave);
		
		for (String srcFile : srcFiles) {
			File fileToZip = new File(srcFile);
			FileInputStream src = new FileInputStream(fileToZip);
			
			ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
			dst.putNextEntry(zipEntry);
			
			byte[] bytes = new byte[1024];  // �]�w��byte�}�C�Ŷ��A�w�]1024
			int length;  // �O��Ū��byte��
			while((length = src.read(bytes)) >= 0) {
				dst.write(bytes, 0, length);  // �Hzip�榡�g�J��X��y
			}
			src.close();  // �C���j�餺���n������J��y
		}
		dst.close();  // ������X��y
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


class A implements Runnable {  // ��@A����
	@Override
	public void run() {
		System.out.println("A is running");
	}	
}


class HorseRacing extends Thread {
	HorseRacing(String name) {  // �غc��k
		super(name);  // �]�w�W��
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