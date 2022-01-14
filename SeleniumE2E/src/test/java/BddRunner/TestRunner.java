package BddRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Feature/Login.feature", glue = "StepDefination")
public class TestRunner {

// this class will run the test with help of feature and stepdefination file	

}
