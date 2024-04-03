package testCases;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
	@CucumberOptions(
		features= {"C:\\Users\\2308397\\eclipse-workspace\\CAS-Project\\seleniumcas\\src\\test\\resources\\FeatureFiles\\Feature.feature"},
			glue="stepDefinitions",
			plugin= {"pretty",
					"html:reports/myCucumberReport.html"
			}
			)
	 
	public class TestRunner {
		
	 
	}


