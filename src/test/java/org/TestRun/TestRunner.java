
package org.TestRun;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;




@RunWith(Cucumber.class)
@CucumberOptions(features = {"C:\\Users\\susan\\eclipse-workspace\\WindowHandling\\src\\test\\resources\\Feature\\firsttest.feature"},
glue = {"org.StepDefinition2"},
dryRun = false,
plugin = {"html:report/WebReport"}


		)

public class TestRunner {
	
	
	

}
