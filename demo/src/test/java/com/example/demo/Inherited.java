package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;


import org.junit.jupiter.api.Test;

public class Inherited {

	@Test
	public void test1() {
		Dog dog = new Dog();
		dog.eat();
		dog.sleep();
		dog.barking();
		
		Animal animal = new Dog();
		animal.eat();  // Upcasting
		Dog dog1 = (Dog)animal;  // Downcasting
		dog1.eat();
		
		// 匿名內部類別: 通常只使用一次 宣告的同時就建立物件
		Animal inner = new Animal() {
			public void moving() {
				System.out.println("cat can walk and jump");
			}
		};  // 記得分號
		inner.moving();
		animal.moving();
	}
	
	@Test
	public void test2() {
		School a = new School();
		School.Motto inner = a.new Motto();  // 建立內部類別物件
		School b = new Department();
		Department c = new Department();
		
		a.demo();
		b.demo();
		c.demo();
//		b.demo1();  // 無法使用
		c.demo1();
		inner.printInfo();  // 呼叫內部類別方法
	}

	@Test
	public void test3() {
//		Circle circle = new Circle(2);
		Circle circle = new Circle();
		System.out.println("area = " + circle.area(2));
	}
	
	@Test
	public void testNoLambda() {
		int r = 5;
		Shapes obj = new Shapes() {
			public void draw() {
				System.out.println("r = 5");
			}
		};
		obj.draw();
	}
	
	@Test
	public void testWithLambda() {
		int r = 5;
		// 沒有傳遞參數的Lambda表達式
		Shapes obj = ()-> {
				System.out.println("r = 5");
			};
		obj.draw();
	}
	
	@Test
	public void testStaticMethod() {
		// 參考靜態方法 (不須new物件)
//		Message obj = ()-> DoTest.talking();  // 無參數Lambda表達式
		Message obj = DoTest::talking;  // 方法參照
		obj.msg();
	}
	
	@Test
	public void tryLambda2() {
		InterfaceD d1 = (x, y)-> x + y;
		InterfaceD d2 = (x, y)-> {return x + y;};  // 多行寫法 要有分號
	}
	
	@Test
	public void tryFunction() {
		// 匿名內部類別寫法
		Function<Integer, String> innerClass = new Function<>() {  // <引數, return>
			@Override
			public String apply(Integer t) {
				// TODO Auto-generated method stub
				return Integer.toString(t * t);
			}			
		};
		System.out.println(innerClass.apply(3));
		
		// Lambda寫法
		Function<Integer, String> useLambda = x -> {
			return Integer.toString(x * x);
		};
		System.out.println(useLambda.apply(5));
	}
	
	@Test
	public void tryPredicate() {
		Predicate<String> lengthTest = new Predicate<>() {
			@Override
			public boolean test(String t) {
				// TODO Auto-generated method stub
				return t.length() > 4 ? true : false;
			}			
		};
		Predicate<String> andCondition = new Predicate<>() {
			@Override
			public boolean test(String t) {
				return t.equalsIgnoreCase("Python") ? true : false;
			}			
		};
		List<String> list = new ArrayList<>(List.of("Java", "Python", "C#", "hello"));
		// 搭配 Lambda Stream 的 filter
		list.stream().filter(lengthTest.and(andCondition)).forEach(item -> {  // 條件1 AND (條件2 OR 條件3)
			System.out.println(item);
		});
	}
	
	@Test
	public void trySupplier() {
		Supplier<String> str = new Supplier<>() {
			@Override
			public String get() {
				return "Hello Java";
			}			
		};
		System.out.println(str.get());
		
		// Lambda 寫法
		Supplier<String> str1 = ()-> "Hello Java yeah";
		System.out.println(str1.get());
	}
	
	@Test
	public void tryStream() {
		List<Integer> list = new ArrayList<>();
		list.addAll(List.of(1, 2, 3, 4, 5));
		List<Integer> odds = new ArrayList<>();
		odds = findOddNumber(list);
		odds.forEach(item -> {
			System.out.println(item);
		});
	}
	
	private List<Integer> findOddNumber(List<Integer> numbers) {
		return numbers.stream()
				.filter(number -> number % 2 != 0)
				.collect(Collectors.toList());
	}
	
	@Test
	public void tryComparator() {
		List<Integer> list = Arrays.asList(3, 1, 4, 5, 2);
		list.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}			
		});
		
		// Lambda
		list.sort((o1, o2) -> o1.compareTo(o2));
		list.forEach(item -> System.out.println(item));
	}
	
	@Test
	public void tryDefault() {
		Eagle eagle = new Eagle();
		eagle.action();  // 直接呼叫default方法
		eagle.showMe();
	}
	
}

interface Bird {
	void showMe();
	default void action() {  // 實作在介面內
		System.out.println("I can fly");
	}
}

class Eagle implements Bird {

	@Override
	public void showMe() {
		System.out.println("I am bird");		
	}
	
}


//@FunctionalInterface
//interface Predicate<T> {  // 接受一個引數，回傳Boolean
//	boolean test(T t);
//}


//@FunctionalInterface
//interface Function<T, R> {
//	R apply(T t);
//}


@FunctionalInterface
interface InterfaceD {
	int returnResult(int x, int y);
}


@FunctionalInterface
interface Message {
	void msg();
}

class DoTest {
	public static void talking() {
		System.out.println("static method");
	}
}


@FunctionalInterface
interface Shapes {
	public void draw();
}


abstract class Shape {  // 定義抽象類別
	// 若有抽象方法，則類別須宣告為抽象類別
	public abstract double area(int a);  //定義抽象方法
}

class Circle extends Shape {

//	protected double r;
//	Circle(double r) {
//		this.r = r;
//	}
	
	@Override
	// 重新定義方法: 回傳值型態、參數要與抽象方法一致
	public double area(int a) {
		// TODO Auto-generated method stub
//		return Math.PI * r * r;
		return Math.PI * a * a;
	}
	
}


class School {
	void college() {
		int students = 400;
		// 方法內部類別: 將類別寫在方法內
		class Mis {
			public int getNum() {
				return students;				
			}
		}
	}
	// 一般內部類別 inner class
	class Motto {  // no modifier (內部類別的存取權限不能是private否則外部不能存取)
		public void printInfo() {
			System.out.println("print info");
		}
	}
	
	void display() {
		Motto meobj = new Motto();  // 讀取Inner class
		meobj.printInfo();  // 建立內部類別物件
	}
	
	public void demo() {
		System.out.println("School demo");
	}
}

class Department extends School {
	public void demo() {  // 重新定義父類別的demo()
		System.out.println("Department demo");
	}
	public void demo1() {
		System.out.println("Department demo1");
	}
}


class Animal {
	Animal() {
		System.out.println("Animal construct");
	}

	protected String name;
	
	public void moving() {
		System.out.println("animal can walk and jump");
	}

	public void eat() {
		System.out.println("eat");
	}

	public void sleep() {
		System.out.println("sleep");
	}
}

class Dog extends Animal {
	Dog() {
		System.out.println("Dog construct");
	}

	Dog(String name) {
		this.name = name;
	}

	public void barking() {
		System.out.println("bark");
	}
}