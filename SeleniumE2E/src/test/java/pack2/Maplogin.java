package pack2;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Pack1.Pageobject;

public class Maplogin {

	public static WebDriver driver;

	@Test(enabled = false)
	public HashMap<String, String> login() {

		HashMap<String, String> mp = new HashMap<String, String>();

		mp.put("sagar", "sagarsonawane1991@gmail.com,Kms60$");

		mp.put("vishal", "vishalsonawane88@gmail.com,vishal1234");

		mp.put("papa", "khandusonawane60@gamil.com,Kms123 ");

		String usrandpwd = mp.get("sagar");

		String[] arr = usrandpwd.split(",");

		Pageobject obj3 = new Pageobject(driver);

		obj3.getUsername().sendKeys(arr[0]);

		obj3.getPassword().sendKeys(arr[1]);

		obj3.clickbutton();

		return mp;

	}

}
