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
		
		// 拔ず场摸: 硄盽ㄏノΩ 碞ミン
		Animal inner = new Animal() {
			public void moving() {
				System.out.println("cat can walk and jump");
			}
		};  // 癘眔だ腹
		inner.moving();
		animal.moving();
	}
	
	@Test
	public void test2() {
		School a = new School();
		School.Motto inner = a.new Motto();  // ミず场摸ン
		School b = new Department();
		Department c = new Department();
		
		a.demo();
		b.demo();
		c.demo();
//		b.demo1();  // 礚猭ㄏノ
		c.demo1();
		inner.printInfo();  // ㊣ず场摸よ猭
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
		// ⊿Τ肚患把计Lambda笷Α
		Shapes obj = ()-> {
				System.out.println("r = 5");
			};
		obj.draw();
	}
	
	@Test
	public void testStaticMethod() {
		// 把σ繰篈よ猭 (ぃ斗newン)
//		Message obj = ()-> DoTest.talking();  // 礚把计Lambda笷Α
		Message obj = DoTest::talking;  // よ猭把酚
		obj.msg();
	}
	
	@Test
	public void tryLambda2() {
		InterfaceD d1 = (x, y)-> x + y;
		InterfaceD d2 = (x, y)-> {return x + y;};  // ︽糶猭 璶Τだ腹
	}
	
	@Test
	public void tryFunction() {
		// 拔ず场摸糶猭
		Function<Integer, String> innerClass = new Function<>() {  // <ま计, return>
			@Override
			public String apply(Integer t) {
				// TODO Auto-generated method stub
				return Integer.toString(t * t);
			}			
		};
		System.out.println(innerClass.apply(3));
		
		// Lambda糶猭
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
		// 穎皌 Lambda Stream  filter
		list.stream().filter(lengthTest.and(andCondition)).forEach(item -> {  // 兵ン1 AND (兵ン2 OR 兵ン3)
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
		
		// Lambda 糶猭
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
		eagle.action();  // 钡㊣defaultよ猭
		eagle.showMe();
	}
	
}

interface Bird {
	void showMe();
	default void action() {  // 龟ざず
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
//interface Predicate<T> {  // 钡ま计肚Boolean
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


abstract class Shape {  // ﹚竡┾禜摸
	// 璝Τ┾禜よ猭玥摸斗┾禜摸
	public abstract double area(int a);  //﹚竡┾禜よ猭
}

class Circle extends Shape {

//	protected double r;
//	Circle(double r) {
//		this.r = r;
//	}
	
	@Override
	// 穝﹚竡よ猭: 肚篈把计璶籔┾禜よ猭璓
	public double area(int a) {
		// TODO Auto-generated method stub
//		return Math.PI * r * r;
		return Math.PI * a * a;
	}
	
}


class School {
	void college() {
		int students = 400;
		// よ猭ず场摸: 盢摸糶よ猭ず
		class Mis {
			public int getNum() {
				return students;				
			}
		}
	}
	// ず场摸 inner class
	class Motto {  // no modifier (ず场摸舦ぃ琌private玥场ぃ)
		public void printInfo() {
			System.out.println("print info");
		}
	}
	
	void display() {
		Motto meobj = new Motto();  // 弄Inner class
		meobj.printInfo();  // ミず场摸ン
	}
	
	public void demo() {
		System.out.println("School demo");
	}
}

class Department extends School {
	public void demo() {  // 穝﹚竡摸demo()
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