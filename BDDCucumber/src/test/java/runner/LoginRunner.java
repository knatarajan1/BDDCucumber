package runner;

import org.testng.annotations.DataProvider;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"src/test/java/stories/LoginNew.feature","src/test/java/stories/Login.feature"},
		glue={"steps","hooks"},
		dryRun = false,
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		plugin= {"pretty","html:HTMLReports","json:JsonReports/jsonReport.json"}
		)
public class LoginRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
