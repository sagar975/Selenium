package BddRunner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

class Summy {

	@BeforeClass
	public void ZummyFirst() {

		System.out.println("parent before first");

	}

}

class Dummy extends Summy {

	@BeforeTest
	public void foo() {

		System.out.println("in @BeforeClass");

	}

	@Test
	public void test2() {

		System.out.println("ggotcha");

	}

}

public class TestNgAnnotationPractise {
	@Test
	public void test() {

		System.out.println("as testng");

	}

	public static void main(String[] args) {

		System.out.println("as java app");

	}

}
