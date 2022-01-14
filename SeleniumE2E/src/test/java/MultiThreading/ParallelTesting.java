package MultiThreading;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import EnvironmentVar.Constant;
import Singlton.Singeltonclass;

public class ParallelTesting extends Thread {

	public static WebDriver driver;

	@Test
	public void testParallel() {

		ParallelTesting ob = new ParallelTesting();

		Thread one = new Thread(ob);
		Thread two = new Thread(ob);
		Thread third = new Thread(ob);
		one.setName("thread1");
		two.setName("thread2");
		third.setName("thread3");

	}

	public void run() {

	}

}
