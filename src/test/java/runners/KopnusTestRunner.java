package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/results/kopnus/cucumber-report.json",  "html:target/results/kopnus"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@register"

)
public class KopnusTestRunner extends BaseTestRunnerAndroid
{

}