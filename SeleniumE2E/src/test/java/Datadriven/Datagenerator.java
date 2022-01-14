package Datadriven;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Datagenerator {

	@DataProvider(name = "logindata")
	public static Object[][] getData() {

		Object[][] arr = new Object[3][2];

		arr[0][0] = "sagar19@gmail.com";
		arr[0][1] = "12345";
		arr[1][0] = "kms@yahoo.com";
		arr[1][1] = "457";
		arr[2][0] = "vks@yahoo.com";
		arr[2][1] = "12897";

		return arr;

	}

}
