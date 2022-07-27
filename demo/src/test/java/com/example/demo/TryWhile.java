package com.example.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;

public class TryWhile {
	
	@Test
	public void tryArray1() {
		
		int[] [] x = new int[2][];  // 宣告二微陣列但先配置第一維空間
		x[0] = new int[3];
		x[1] = new int[5];  // 第一維的每個index長度都不同
	}
	
	@Test
	public void tryArray() {
		
		Set<Integer> set = new HashSet<>();	

		for (int i = 2; i < 20; i++) {
			set.add(i);
			for (int j = 2; j < i; j++) {				
				if(i % j == 0) {
					set.remove(i);
				}
			}
		}
		for (Integer integer : set) {
			System.out.println(integer);
		}
		
	}
	
	@Test
	public void tryDoWhile() {
		
		int i = 1;
		do {
			int j = 1;
			do {
				System.out.println(String.format("%s * %s = ", i, j) + i*j);
				j++;				
			} while (j <= 9);			
			i++;
		} while (i <= 9);		
	}

}
