package TestRunner;
import org.junit.runner.RunWith;		
import cucumber.api.CucumberOptions;		
import cucumber.api.junit.Cucumber;		

@RunWith(Cucumber.class)				
@CucumberOptions(
		features="src/test/resources/features",
		glue={"com.test.sirisha.steps"},
		monochrome = true,
		plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
				 "junit:target/cucumber-reports/Cucumber.xml",
				 "html:target/cucumber-reports" })
public class TestRunner 				
{		

}
