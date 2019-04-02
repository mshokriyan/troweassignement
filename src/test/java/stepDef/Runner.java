package stepDef;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"./src/test/resources/features"}
				, glue= {"stepDef"}
				,plugin= {"pretty"
				, "html:target/cucumber-defualt-reports"
				}
				,dryRun=false
				,monochrome=true
				)

public class Runner {

}
