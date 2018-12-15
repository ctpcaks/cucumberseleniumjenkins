package steps;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		dryRun = 		false,
		monochrome = 	true,
		features = {	"src/test/resources/"},
		glue	 = {	"steps/"},
		plugin	 = {	"pretty",
						"html:target/cucumberhtmlreport",
						"json:target/cucumber-report.json",
						"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/ExtentReport.html"		
		}
		)
public class runner {

}
