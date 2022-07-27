package com.example.demo;

import org.junit.jupiter.api.Test;

public class Inherited2 {
	
	@Test
	public void tryMultiDefault() {
		// �h�h���~�Ӥ�default��k�W�٬ۦP
		Pet obj = new Pet();
		obj.running();
		obj.who();
	}

}

interface Animals {
	void who();
	default void running() {
		System.out.println("animal is running");
	}
}

interface Cat extends Animals {
	default void running() {
		System.out.println("cat is running");
	}
}

class Pet implements Cat {

	@Override
	public void who() {
		System.out.println("I am animal");		
	}	
}

